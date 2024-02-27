<!--
 * @Author: Dandan
 * @Date: 2023-06-24 13:18:20
-->
<template>
  <i-frame :src="url" />
</template>
<script>
import iFrame from "@/components/iFrame/index";
export default {
  name: "Swagger",
  components: { iFrame },
  data() {
    return {
      url: "https://localhost:8091/swagger-ui",
    };
  },
};
</script>
