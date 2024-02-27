<template>
  <div class="app-container">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>{{ comName }}</span>
      </div>
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm"
        label-position="right">
        <el-form-item label="专案名称" prop="project">
          <el-input v-model="ruleForm.project" placeholder="例：D8X"></el-input>
        </el-form-item>
        <el-form-item label="备注" prop="line">
          <el-input v-model="ruleForm.line" placeholder="输入机台名称等相关信息"></el-input>
        </el-form-item>
        <el-form-item v-show="showType" label="文件类型" prop="type">
          <el-radio-group v-model="ruleForm.type">
            <el-radio label="ESOP"></el-radio>
            <el-radio label="SOP"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item v-show="showPlan" label="保养计划" prop="plan">
          <el-radio-group v-model="ruleForm.plan">
            <el-radio label="日保养"></el-radio>
            <el-radio label="周保养"></el-radio>
            <el-radio label="月保养"></el-radio>
            <el-radio label="季保养"></el-radio>
            <el-radio label="半年保养"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="文件上传" prop="files">
          <el-upload :on-change="handleChange" :on-progress="uploadFileProcess" :on-remove="handleRemove"
            class="upload-demo" drag multiple action="#" :auto-upload="false" :file-list="files">
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">
              将文件拖到此处，或<em>点击上传</em>
            </div>
          </el-upload>
          <!-- 进度条 -->
          <el-progress v-if="progressFlag" :percentage="loadProgress"></el-progress>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" v-loading.fullscreen.lock="fullscreenLoading"
            @click="submitForm('ruleForm')">立即上传</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      files: [],
      loadProgress: 0, // 动态显示进度条
      progressFlag: false, // 关闭进度条
      ruleForm: {
        project: "",
        line: "",
        isModule: false,
        module: "",
        plan: "",
        type: "",
      },
      fullscreenLoading: false,
      rules: {
        project: [
          {
            required: true,
            message: "请输入专案名称，只包含数字、字母和“-”",
            trigger: "blur",
          },
        ],
        plan: [
          { required: true, message: "请选择保养计划", trigger: "change" },
        ],
        type: [
          { required: true, message: "请选择文件类型", trigger: "change" },
        ],
      },
    };
  },
  computed: {
    showPlan() {
      return this.comName == "设备保养计划";
    },
    showType() {
      return this.comName == "设备操作规范";
    },
  },
  // 定义props接收从父组件传来的参数(组件名称和提交的url地址)
  props: [
    "comName", //组件名称
    "flag", //是否需要模组的标志
    "uploadFile",
  ],
  methods: {
    // 提交请求
    submitForm(formName) {
      // 字符串校验，并转换为大写
      const projectResult = this.$validateStr(this.ruleForm.project);
      if (!projectResult) {
        this.$message({
          showClose: true,
          message: "请检查输入的数据，格式是否正确，只包含数字、字母和“-”。",
          type: "error",
        });
      } else {
        const flag = this.ruleForm.isModule ? 1 : 0;
        let maintenanceFlag = "";
        switch (this.ruleForm.plan) {
          case "日保养":
            maintenanceFlag = "d";
            break;
          case "周保养":
            maintenanceFlag = "w";
            break;
          case "月保养":
            maintenanceFlag = "m";
            break;
          case "季保养":
            maintenanceFlag = "q";
            break;
          case "年保养":
            maintenanceFlag = "y";
            break;
        }
        let standardFlag = this.ruleForm.type;

        const formData = new FormData();
        this.files.forEach((file) => {
          formData.append("file", file);
        });
        formData.append("product", this.ruleForm.project);
        formData.append("remark", this.ruleForm.line);
        formData.append("maintenance_file_flag", maintenanceFlag);
        formData.append("standard_file_flag", standardFlag);

        this.fullscreenLoading = true;

        // 上传文件
        this.uploadFile(formData).then(
          // 成功的回调
          (res) => {
            // 关闭加载
            this.fullscreenLoading = false;
            // 清空表单数据
            // this.resetForm();
            let self = this;
            this.$nextTick(() => {
              // 在DOM元素加载完后执行
              self.$refs[formName].resetFields();
              this.files = [];
            });
            this.$message({
              showClose: true,
              message: "文件上传成功！",
              type: "success",
            });
          },
          // 失败的回调
          (err) => {
            // 关闭加载
            this.fullscreenLoading = false;
            this.$message({
              showClose: true,
              message: "文件上传失败" + err,
              type: "error",
            });
          }
        );
      }
    },
    // 进度条事件
    uploadFileProcess(event, file, fileList) {
      this.progressFlag = true; // 显示进度条
      this.loadProgress = parseInt(event.percent); // 动态获取文件上传进度
      if (this.loadProgress >= 100) {
        this.loadProgress = 100;
        setTimeout(() => {
          this.progressFlag = false;
        }, 2000); // 2秒后关闭进度条
      }
    },
    // 重置表单内容
    resetForm(formName) {
      let self = this;
      this.$nextTick(() => {
        //在DOM元素加载完后执行
        self.$refs[formName].resetFields();
        this.files = [];
      });
    },
    // 给files赋值
    handleChange(file, fileList) {
      this.files.push(file.raw);
    },
    // 移除文件
    handleRemove(file) {
      this.files.forEach((i) => {
        if (i.uid === i.uid) this.files.pop(i);
      });
    },
  },
};
</script>

<style scoped>
.app-container {
  display: flex;
  justify-content: center;
}

.box-card {
  display: flex;
  flex-direction: column;
  width: 800px;
}

.upload-demo {
  flex-direction: column;
  align-items: flex-start;
}

.el-input {
  width: 200px;
}

.el-upload-list__item-name {
  word-break: break-word;
}

.clearfix {
  font-size: 16px;
  color: #606266;
  font-family: Helvetica Neue, Helvetica, PingFang SC, Hiragino Sans GB,
    Microsoft YaHei, Arial, sans-serif;
}
</style>

