<!--
 * @Author: Dandan
 * @Date: 2023-05-12 11:17:20
-->
<template>
  <div class="home">
    <div ref="file"></div>
  </div>
</template>
  
  <script>
import axios from "axios";
const docx = require("docx-preview");
window.JSZip = require("jszip");
export default {
  mounted() {
    axios({
      method: "get",
      responseType: "blob", // 设置响应文件格式
      url: "http://10.52.6.32:8091/detailfile/preview/2",
    }).then(({ data }) => {
      docx.renderAsync(data, this.$refs.file); // 渲染到页面预览
    });
  },
};
</script>
  