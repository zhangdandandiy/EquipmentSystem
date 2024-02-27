<!--
 * @Author: Dandan
 * @Date: 2023-06-16 11:35:21
-->
<template>
  <el-form ref="form" :model="user" :rules="rules" label-width="80px">
    <el-form-item label="用户工号" prop="userJobNumber">
      <el-input v-model="user.userJobNumber" maxlength="30" :disabled="true" />
    </el-form-item>
    <el-form-item label="用户名称" prop="userName">
      <el-input v-model="user.userName" maxlength="30" />
    </el-form-item>
    <el-form-item label="手机号码" prop="userPhoneNumber">
      <el-input v-model="user.userPhoneNumber" maxlength="11" />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" size="mini" @click="submit">保存</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { alterUser } from "@/api/user";
import { Message } from "element-ui";

export default {
  props: {
    user: {
      type: Object,
    },
  },
  data() {
    return {
      // 表单校验
      rules: {
        userName: [
          { required: true, message: "用户昵称不能为空", trigger: "blur" },
        ],
        userPhoneNumber: [
          { required: true, message: "手机号码不能为空", trigger: "blur" },
          {
            pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
            message: "请输入正确的手机号码",
            trigger: "blur",
          },
        ],
      },
    };
  },
  methods: {
    submit() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          const { userJobNumber, userName, userPhoneNumber } = this.user;
          const params = {
            userJobNumber,
            userName,
            userPhoneNumber,
          };
          alterUser(params).then((res) => {
            const message =
              res.data.code === 200 ? Message.success : Message.error;
            message(res.data.msg);
          });
        }
      });
    },
  },
};
</script>
