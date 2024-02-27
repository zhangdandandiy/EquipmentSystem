<template>
  <div class="frame">
    <div class="search-frame">
      <div>
        专案名称：<el-input
          v-model="project"
          placeholder="请输入专案名称"
        ></el-input>
      </div>
      <div>
        关键字：<el-input
          v-model="line"
          placeholder="请输入线体名称"
        ></el-input>
      </div>
      <el-button
        type="primary"
        v-loading.fullscreen.lock="fullscreenLoading"
        @click="onSearch"
        icon="el-icon-search"
        >搜索</el-button
      >
    </div>
    <transition name="table" appear>
      <el-table
        v-show="tableData.length"
        v-loading="true"
        class="item-list"
        :data="tableData"
        border
        stripe
        style="width: 100%"
      >
        <el-table-column prop="id" label="id" width="90"> </el-table-column>
        <el-table-column prop="file" label="文件" width="540">
        </el-table-column>
        <el-table-column prop="time" label="上传时间" width="270">
        </el-table-column>
        <el-table-column label="操作" width="240">
          <template slot-scope="scope">
            <el-button size="mini" @click="handlePreview(scope.row)"
              >预览</el-button
            >
            <el-button
              size="mini"
              type="primary"
              @click="handleDownload(scope.row)"
              >下载</el-button
            >
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.row)"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </transition>
  </div>
</template>
  
<script>
export default {
  data() {
    return {
      project: "",
      line: "",
      module: "",
      tableData: [],
      fullscreenLoading: false,
    };
  },
  props: [
    "comName",
    "flag",
    "deleteFile", //删除文件
    "searchFile", //查询文件
    "downloadFile", //下载文件
    "previewFile", //预览文件
  ],
  methods: {
    // 通过查询字段获取数据
    async onSearch() {
      // 置空
      this.tableData = [];
      // params
      let params = {
        project: this.project,
        line: this.line,
        machine: this.module || "null",
      };
      // 开启loading
      this.fullscreenLoading = true;
      // 获取查询结果，并展示
      let fileList = await this.searchFile(params);
      this.fullscreenLoading = false;
      if (fileList.length) {
        this.tableData = fileList;
        // console.log(this.tableData);
      } else {
        this.$message({
          showClose: true,
          message: "查询结果为空！",
          type: "warning",
        });
      }
    },
    // 预览
    handlePreview(row) {
      this.$message({
        showClose: true,
        message: "此功能暂未开发",
        type: "warning",
      });
    },
    // 下载
    async handleDownload(row) {
      try {
        const response = await this.downloadFile(row.id);
        const url = window.URL.createObjectURL(new Blob([response.data]));
        const link = document.createElement("a");
        link.href = url;
        link.setAttribute("download", row.file);
        document.body.appendChild(link);
        link.click();
      } catch (error) {
        this.$message({
          showClose: true,
          message: "文件下载失败" + error,
          type: "error",
        });
      }
    },
    // 删除
    async handleDelete(row) {
      this.$confirm("此操作将永久删除该文件, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(async () => {
          await this.deleteFile(row.id);
          this.$message({
            type: "success",
            message: "删除成功!",
          });
          // 再次请求数据
          await this.onSearch();
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
  },
};
</script>
  
<style lang="scss" scoped>
.app-container {
  display: flex;
  align-items: center;
  justify-content: center;
}
.upload-demo {
  display: flex;
  align-items: center;
}
.el-input {
  width: 200px;
  margin-right: 20px;
}
.frame {
  display: flex;
  flex-direction: column;
  align-content: center;
  justify-content: center;
  align-items: center;
}

/* 进入的起点和离开的终点 */
.table-enter,
.table-leave-to {
  transform: translateX(-100%);
}

/* 过渡效果 */
.table-enter-active,
.table-leave-active {
  transition: 1s linear;
}

/* 进入的终点和离开的起点 */
.table-enter-to,
.table-leave {
  transform: translateX(0);
}

.search-frame {
  display: flex;
  flex-direction: row;
}

.item-list {
  margin-top: 50px;
}
</style>
  
  