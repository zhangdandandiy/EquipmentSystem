<!--
 * @Author: Dandan
 * @Date: 2023-06-14 14:51:08
-->
<template>
  <!-- Excel在线预览 -->
  <div class="excel-view-container">
    <el-button size="mini" type="success" @click="previewFile()"
      >预览 </el-button
    ><!--文件预览-->
    <preview-file-dialog ref="previewFileDialog"></preview-file-dialog>
  </div>
</template>

<script>
import XLSX from "xlsx";
import axios from "axios";
import PreviewFileDialog from "@/components/PreviewFileDialog";
import UploadDialog from "@/components/UploadDialog";
export default {
  name: "PreviewIndex",
  components: {
    PreviewFileDialog,
    UploadDialog,
  },
  data() {
    return {
      excelView: "", // 添加excelView属性
    };
  },
  mounted() {},
  methods: {
    previewFile(row) {
      this.$refs.previewFileDialog.fileInfo = row;
      this.$refs.previewFileDialog.dialogVisible = true;
    },
  },
};
</script>