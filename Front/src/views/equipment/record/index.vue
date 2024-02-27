<!--
 * @Author: Dandan
 * @Date: 2023-05-12 11:17:21
-->
<template>
  <div class="app-container">
    <SubForm comName="设备履历" :uploadFile="uploadRecordFile" :flag="true"></SubForm>
  </div>
</template>

<script>
import SubForm from "@/components/SubForm";
import { uploadRecordFile } from "@/api/equipment/record";

export default {
  components: {
    SubForm,
  },
  data() {
    return {};
  },

  methods: {
    uploadRecordFile,
  },
};
</script>

<style scoped>
.app-container {
  display: flex;
  justify-content: center;
}
</style>

