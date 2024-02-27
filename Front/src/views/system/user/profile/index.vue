<template>
  <div class="app-container">
    <el-row :gutter="20" style="width: 100%">
      <el-col :span="6" :xs="24">
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>个人信息</span>
          </div>
          <div>
            <div class="text-center">
              <userAvatar :user="user" />
            </div>
            <ul class="list-group list-group-striped">
              <li class="list-group-item">
                <i class="el-icon-tickets"> 用户工号 </i>
                <div class="pull-right">{{ user.userJobNumber }}</div>
              </li>
              <li class="list-group-item">
                <i class="el-icon-user"> 用户名称 </i>
                <div class="pull-right">{{ user.userName }}</div>
              </li>
              <li class="list-group-item">
                <i class="el-icon-mobile-phone"> 手机号码 </i>
                <div class="pull-right">{{ user.userPhoneNumber }}</div>
              </li>
              <li class="list-group-item">
                <i class="el-icon-bangzhu"> 所属角色 </i>
                <div class="pull-right">{{ user.userRole }}</div>
              </li>
              <li class="list-group-item">
                <i class="el-icon-date"> 创建日期 </i>
                <div class="pull-right">{{ user.userCreateTime }}</div>
              </li>
            </ul>
          </div>
        </el-card>
      </el-col>
      <el-col :span="18" :xs="24">
        <el-card>
          <div slot="header" class="clearfix">
            <span>基本资料</span>
          </div>
          <el-tabs v-model="activeTab">
            <el-tab-pane label="基本资料" name="userinfo">
              <userInfo :user="user" />
            </el-tab-pane>
            <el-tab-pane label="修改密码" name="resetPwd">
              <resetPwd />
            </el-tab-pane>
          </el-tabs>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import userAvatar from "./userAvatar";
import userInfo from "./userInfo";
import resetPwd from "./resetPwd";
import { getUser } from "@/api/user";
import { getUserInfo } from "@/utils/auth";

export default {
  name: "Profile",
  components: { userAvatar, userInfo, resetPwd },
  data() {
    return {
      user: {},
      roleGroup: {},
      postGroup: {},
      activeTab: "userinfo",
    };
  },
  created() {
    this.getUser();
  },
  methods: {
    async getUser() {
      const { userJobNumber } = getUserInfo();
      const res = await getUser(userJobNumber);
      const { data } = res.data;
      this.user = { ...data };
    },
  },
};
</script>
