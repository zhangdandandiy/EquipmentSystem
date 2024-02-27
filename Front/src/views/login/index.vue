<template>
  <div class="login">
    <el-form
      ref="loginForm"
      :model="loginForm"
      :rules="loginRules"
      class="login-form"
    >
      <h3 class="title">设备管理系统</h3>
      <el-form-item prop="userJobNumber">
        <el-input
          v-model="loginForm.userJobNumber"
          type="text"
          auto-complete="off"
          placeholder="工号"
          prefix-icon="el-icon-user"
        >
        </el-input>
      </el-form-item>
      <el-form-item prop="userPassword">
        <el-input
          v-model="loginForm.userPassword"
          type="password"
          auto-complete="off"
          placeholder="密码"
          @keyup.enter.native="handleLogin"
          prefix-icon="el-icon-lock"
        >
        </el-input>
      </el-form-item>
      <el-form-item prop="code" v-if="captchaEnabled">
        <el-input
          v-model="loginForm.captcha"
          auto-complete="off"
          placeholder="验证码"
          style="width: 61%"
          @keyup.enter.native="handleLogin"
          prefix-icon="el-icon-position"
        >
        </el-input>
        <div class="login-code">
          <img
            :src="codeUrl"
            @click="getCode"
            class="login-code-img"
            width="115px"
            v-if="codeUrl"
          />
        </div>
      </el-form-item>
      <el-checkbox
        v-model="loginForm.rememberMe"
        style="margin: 0px 0px 25px 0px"
        >记住密码</el-checkbox
      >
      <el-form-item style="width: 100%">
        <el-button
          :loading="loading"
          size="medium"
          type="primary"
          style="width: 100%"
          @click.native.prevent="handleLogin"
        >
          <span v-if="!loading">登 录</span>
          <span v-else>登 录 中...</span>
        </el-button>
        <div style="float: right" v-if="register">
          <router-link class="link-type" :to="'/register'"
            >立即注册</router-link
          >
        </div>
      </el-form-item>
    </el-form>
    <!--  底部  -->
    <div class="el-login-footer">
      <span>Copyright © 2018-2023 Dandan All Rights Reserved.</span>
    </div>
  </div>
</template>

<script>
import { getCodeImg } from "@/api/user";
import Cookies from "js-cookie";
import { encrypt, decrypt } from "@/utils/jsencrypt";

export default {
  name: "Login",
  data() {
    return {
      codeUrl: "",
      loginForm: {
        userJobNumber: "15961641",
        userPassword: "123456",
        rememberMe: false,
        captcha: "",
        uuid: "",
      },
      loginRules: {
        userJobNumber: [
          { required: true, trigger: "blur", message: "请输入您的工号" },
        ],
        userPassword: [
          { required: true, trigger: "blur", message: "请输入您的密码" },
        ],
        captcha: [
          { required: true, trigger: "change", message: "请输入验证码" },
        ],
      },
      loading: false,
      // 验证码开关
      captchaEnabled: true,
      // 注册开关
      register: false,
      redirect: undefined,
    };
  },
  created() {
    this.getCode();
    this.getCookie();
  },
  methods: {
    getCode() {
      getCodeImg().then((res) => {
        this.codeUrl = "data:image/gif;base64," + res.data.img;
        this.loginForm.uuid = res.data.uuid;
      });
    },
    getCookie() {
      const userJobNumber = Cookies.get("userJobNumber");
      const userPassword = Cookies.get("userPassword");
      const rememberMe = Cookies.get("rememberMe");
      this.loginForm = {
        userJobNumber:
          userJobNumber === undefined
            ? this.loginForm.userJobNumber
            : userJobNumber,
        userPassword:
          userPassword === undefined
            ? this.loginForm.userPassword
            : decrypt(userPassword),
        rememberMe: rememberMe === undefined ? false : Boolean(rememberMe),
      };
    },
    handleLogin() {
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
          this.loading = true;
          // 点击记住密码，指定cookie的过期时间为30天
          if (this.loginForm.rememberMe) {
            Cookies.set("userJobNumber", this.loginForm.userJobNumber, {
              expires: 30,
            });
            Cookies.set("userPassword", encrypt(this.loginForm.userPassword), {
              expires: 30,
            });
            Cookies.set("rememberMe", this.loginForm.rememberMe, {
              expires: 30,
            });
          } else {
            Cookies.remove("userJobNumber");
            Cookies.remove("userPassword");
            Cookies.remove("rememberMe");
          }
          this.$store
            .dispatch("Login", this.loginForm)
            .then(() => {
              this.$router
                .push({ path: this.redirect || "/home/home" })
                .catch(() => {});
            })
            .catch(() => {
              this.loading = false;
              if (this.captchaEnabled) {
                this.getCode();
              }
            });
        }
      });
    },
  },
};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.login {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  background-image: url("../../assets/images/login-background.jpg");
  background-size: cover;
}

.title {
  margin: 0px auto 30px auto;
  text-align: center;
  color: #707070;
}

.login-form {
  border-radius: 6px;
  background: #ffffff;
  width: 400px;
  padding: 25px 25px 5px 25px;

  .el-input {
    height: 38px;

    input {
      height: 38px;
    }

    width: 100%;
  }

  .input-icon {
    height: 39px;
    width: 14px;
    margin-left: 2px;
  }
}

.login-tip {
  font-size: 13px;
  text-align: center;
  color: #bfbfbf;
}

.login-code {
  width: 33%;
  height: 38px;
  float: right;

  img {
    cursor: pointer;
    vertical-align: middle;
  }
}

.el-login-footer {
  height: 40px;
  line-height: 40px;
  position: fixed;
  bottom: 0;
  width: 100%;
  text-align: center;
  color: #fff;
  font-family: Arial;
  font-size: 12px;
  letter-spacing: 1px;
}

.login-code-img {
  height: 38px;
}
</style>
