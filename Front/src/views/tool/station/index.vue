<!--
 * @Author: Dandan
 * @Date: 2022-03-24 08:27:33
-->
<template>
  <div class="station-container">
    <div class="left-station">
      <el-form :model="form" :rules="rules" label-position="top">
        <el-form-item label="站点名称" prop="stationName">
          <el-input placeholder="请输入站点名称" prefix-icon="el-icon-circle-plus-outline" v-model="form.stationName" />
        </el-form-item>
        <el-form-item label="上传文件" prop="uploadFile">
          <el-upload class="upload-demo" ref="file" action="#" drag :auto-upload="false" :on-change="handleFileUpload">
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">
              将CSV文件拖到此处，或<em>点击上传</em>
            </div>
          </el-upload>
        </el-form-item>
        <el-form-item :class="{ 'upload-button': isMyDataEmpty }">
          <el-button icon="el-icon-circle-check" type="primary" @click="submitFormData">提交</el-button>
          <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div class="right-container">
      <el-input ref="createTable" type="textarea" :autosize="{ minRows: 2, maxRows: 28 }" placeholder="创建数据库表的语句"
        v-model="creTabSen" style="margin-bottom: 20px" />
      <el-input type="textarea" :rows="2" placeholder="插入数据库表的语句" v-model="insTabSen" style="margin-bottom: 20px" />
    </div>
  </div>
</template>

<script>
import Papa from "papaparse"
import { savaNewFile, savaOldFile } from '@/api/ict'

export default {
  data() {
    return {
      // 表单校验
      rules: {
        stationName: [
          { required: true, message: "站点名称不能为空", trigger: "blur" },
        ],
        uploadFile: [{ required: true }],
      },
      // 表单数据
      form: {
        // 站点名称
        stationName: ""
      },
      // 上传的文件表头
      csvData: null,
      // 建表语句
      creTabSen: undefined,
      // 插入语句
      insTabSen: undefined,
      // 创建表所有字段
      allCreColArr: [],
      // 插入表所有字段
      allInsColArr: [],
      // 固定创建语句
      fixCrePrePre: `CREATE TABLE [dbo].[`,
      fixCrePre: `](
          [items] [int] IDENTITY(1,1) NOT NULL,
          [Testpcid] [nvarchar](100) NULL,
          [Collecttime] [datetime] NULL,
          [FileName] [nvarchar](100) NULL,\n`,
      sufCre: `\n          [Result] [nvarchar](100) NULL,\n          [ErrorCode] [nvarchar](100) NULL\n)`,
      // 固定插入语句
      fixInsPre: `INSERT INTO [MESDataCenter].[dbo].[`,
      fixInsPrePre: `]([Testpcid],[Collecttime],[FileName],`,
      sufIns: `,[Result],[ErrorCode]) VALUES(`,
      // testType表中字段
      testType: [],
      // StationRules表中字段
      stationRules: [],
      // 数据库表表头
      tableHeader: null,
      // 是否上传文件标志
      flag: 0
    }
  },
  computed: {
    isMyDataEmpty() {
      return this.flag === 1;
    }
  },
  methods: {
    // 保存上传表头文件为.txt，等新的保存，再保存旧的，生成差异文件
    saveNew(tableHeader) {
      savaNewFile(tableHeader).then(async res => {
        try {
          const response = await savaOldFile(this.form.stationName);
          const blob = new Blob([response.data], { type: 'application/octet-stream' });
          const url = window.URL.createObjectURL(blob);
          const a = document.createElement('a');
          a.href = url;
          a.download = "different.html";
          document.body.appendChild(a);
          a.click();
          window.URL.revokeObjectURL(url);
          document.body.removeChild(a);
        } catch (error) {
          console.error('下载文件出现错误：', error);
        }
      })
    },
    // 处理文件上传
    handleFileUpload(file) {
      this.flag = 1
      const targetFile = file
      const reader = new FileReader()

      reader.onload = () => {
        const fileData = reader.result
        const parsedData = Papa.parse(fileData)
        this.csvData = parsedData.data
      }

      reader.readAsText(targetFile.raw)
    },
    // 提交表单
    submitFormData() {
      const {
        csvData
      } = this
      if (csvData != null) {
        this.handleCreSen()
        this.handleInsSen()
        this.tableHeader = csvData[0]
        this.saveNew(this.tableHeader)
      }
    },
    // 拼接新建表的语句
    handleCreSen() {
      const {
        csvData,
        allCreColArr,
        fixCrePrePre,
        fixCrePre,
        sufCre,
        form: { stationName },
      } = this
      if (csvData.length > 0) {
        let data = csvData[0]
        for (let i = 0; i < data.length; i++) {
          if (data[i].includes('Lot') || data[i].includes('lot')) {
            allCreColArr.push(
              `${" ".repeat(10)}[${data[i]}] [nvarchar](max) NULL`
            )
          } else if (data[i].includes('Time') || data[i].includes('time')) {
            allCreColArr.push(
              `${" ".repeat(10)}[${data[i]}] datetime NULL`
            )
          } else {
            allCreColArr.push(
              `${" ".repeat(10)}[${data[i]}] [nvarchar](100) NULL`
            )
          }

        }
        this.creTabSen = `${fixCrePrePre}${stationName}${fixCrePre}${allCreColArr.join(
          ",\n"
        )},${sufCre}`
      }
    },
    // 拼接插入表的语句
    handleInsSen() {
      const {
        fixInsPre,
        fixInsPrePre,
        sufIns,
        csvData,
        allInsColArr,
        form: { stationName },
      } = this
      if (csvData.length > 0) {
        let data = csvData[0]
        for (let i = 0; i < data.length; i++) {
          allInsColArr.push(`[${data[i]}]`)
        }
        this.insTabSen = `${fixInsPre}${stationName}${fixInsPrePre}${allInsColArr.join(
          ","
        )}${sufIns}`
      }
    },
    // 重置按钮
    resetQuery() {
      this.form = {
        stationName: ""
      }
      this.allCreColArr = []
      this.allInsColArr = []
      this.creTabSen = ""
      this.insTabSen = ""
      this.$refs.file.clearFiles()
      this.csvData = null
      this.flag = 0
    }
  },
}
</script>

<style scoped  lang="scss">
.station-container {
  display: flex;
  margin: 20px;

  .left-station {
    display: flex;
    flex-direction: column;
    width: 40%;

    .upload-demo {
      border-radius: 6px;
      font-size: 14px;
      text-align: center;
      color: #c0c4cc;
      height: 180px;
      float: left;

      em {
        color: #409eff;
        font-style: normal;
      }
    }

    .upload-button {
      margin-top: 60px;
    }
  }

  .right-station {
    width: 60%;
  }

  .el-input {
    width: 230px;
  }
}
</style>