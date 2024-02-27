<!--
 * @Author: Dandan
 * @Date: 2023-06-16 10:42:24
-->
<template>
  <el-form ref="form" :model="user" :rules="rules" label-width="80px">
    <el-form-item label="旧密码" prop="originOldPassword">
      <el-input
        v-model="user.originOldPassword"
        placeholder="请输入旧密码"
        type="password"
        show-password
      />
    </el-form-item>
    <el-form-item label="新密码" prop="inputNewPassword">
      <el-input
        v-model="user.inputNewPassword"
        placeholder="请输入新密码"
        type="password"
        show-password
      />
    </el-form-item>
    <el-form-item label="确认密码" prop="confirmPassword">
      <el-input
        v-model="user.confirmPassword"
        placeholder="请确认新密码"
        type="password"
        show-password
      />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" size="mini" @click="submit">保存</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { alterUser } from "@/api/user";
import { getUserInfo } from "@/utils/auth";
import { Message } from "element-ui";

export default {
  data() {
    const equalToPassword = (rule, value, callback) => {
      if (this.user.inputNewPassword !== value) {
        callback(new Error("两次输入的密码不一致"));
      } else {
        callback();
      }
    };
    return {
      user: {
        userJobNumber: getUserInfo().userJobNumber,
        originOldPassword: undefined,
        inputNewPassword: undefined,
        confirmPassword: undefined,
      },
      // 表单校验
      rules: {
        originOldPassword: [
          { required: true, message: "旧密码不能为空", trigger: "blur" },
        ],
        inputNewPassword: [
          { required: true, message: "新密码不能为空", trigger: "blur" },
          {
            min: 6,
            max: 20,
            message: "长度在 6 到 20 个字符",
            trigger: "blur",
          },
        ],
        confirmPassword: [
          { required: true, message: "确认密码不能为空", trigger: "blur" },
          { required: true, validator: equalToPassword, trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    submit() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          const { originOldPassword, inputNewPassword, userJobNumber } =
            this.user;
          const params = {
            userJobNumber,
            originOldPassword,
            inputNewPassword,
          };
          alterUser(params).then((res) => {
            const message =
              res.data.code == 200 ? Message.success : Message.error;
            message(res.data.msg);
          });
        }
      });
    },
  },
};
</script>
