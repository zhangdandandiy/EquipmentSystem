<template>
  <div class="app-container">
    <SubForm
      comName="设备保养计划"
      :uploadFile="uploadMaintenanceFile"
      :flag="true"
    ></SubForm>
  </div>
</template>

<script>
import SubForm from "@/components/SubForm";
import { uploadMaintenanceFile } from "@/api/equipment/maintenance";
export default {
  components: {
    SubForm,
  },
  data() {
    return {};
  },
  methods: {
    uploadMaintenanceFile,
  },
};
</script>

<style scoped>
.app-container {
  display: flex;
  justify-content: center;
}
</style>

