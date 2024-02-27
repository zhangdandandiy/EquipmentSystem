<!--
 * @Author: Dandan
 * @Date: 2023-05-12 11:17:21
-->
<template>
  <div class="app-container">
    <SearchTable
      :downloadFile="downloadRecordFile"
      :previewFile="previewRecordFile"
      :deleteFile="deleteRecordFile"
      :searchFile="searchRecordFile"
      :flag="true"
    ></SearchTable>
  </div>
</template>

<script>
import SearchTable from "@/components/SearchTable/index.vue";
import {
  deleteRecordFile,
  downloadRecordFile,
  previewRecordFile,
} from "@/api/equipment/record";
import { searchRecordFile } from "@/api/equipment/equipmentFile";

export default {
  data() {
    return {};
  },
  components: { SearchTable },
  methods: {
    onSubmit() {
      console.log("submit!");
    },
    searchRecordFile,
    downloadRecordFile,
    deleteRecordFile,
    previewRecordFile,
  },
};
</script>

<style scoped>
</style>

