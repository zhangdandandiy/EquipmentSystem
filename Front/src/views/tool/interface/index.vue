<!--
 * @Author: Dandan
 * @Date: 2023-06-17 16:20:11
-->
<template>
  <div>
    interface
    <el-button type="primary" @click="test">测试</el-button>
  </div>
</template>

<script>
import axios from 'axios'
import { test1, test2, test3 } from "@/api/ict";
export default {

  methods: {
    test() {
      console.log("测试");
      this.test3()
      // this.test1();
      // this.test2();
    },
    async test1() {
      let result1 = await test1();
      console.log("result1", result1);
    },
    async test2() {
      let result2 = await test2();
      console.log("result2", result2);
    },
    async test3() {
      let result3 = await test3();
      console.log("result3", result3);
    }
  }
}

</script>