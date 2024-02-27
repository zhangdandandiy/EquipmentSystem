<!--
 * @Author: Dandan
 * @Date: 2023-05-12 11:17:21
-->
<template>
  <div class="app-container">
    <SubForm
      comName="设备操作规范"
      :uploadFile="uploadStandardFile"
      :flag="true"
    ></SubForm>
  </div>
</template>

<script>
import SubForm from "@/components/SubForm";
import { uploadStandardFile } from "@/api/equipment/standard";
export default {
  components: {
    SubForm,
  },
  data() {
    return {};
  },
  methods: {
    uploadStandardFile,
  },
};
</script>

<style scoped>
.app-container {
  display: flex;
  justify-content: center;
}
</style>

