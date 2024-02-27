/*
 * @Author: Dandan
 * @Date: 2023-06-05 13:19:17
 */
import { login, logout, getUser } from '@/api/user'
import { Message } from 'element-ui'
import { getUserInfo, setUserInfo, removeUserInfo } from '@/utils/auth'
import { resetRouter } from '@/router'

const state = {
  token: "",
  jobNumber: "",
  avatar: "",
  roles: [],
  permissions: []
}

const mutations = {
  SET_TOKEN: (state, token) => {
    state.token = token
  },
  SET_JOBNUMBER: (state, jobNumber) => {
    state.jobNumber = jobNumber
  },
  SET_AVATAR: (state, avatar) => {
    state.avatar = avatar
  },
  SET_ROLES: (state, roles) => {
    state.roles = roles
  },
  SET_PERMISSIONS: (state, permissions) => {
    state.permissions = permissions
  }
}

const actions = {
  async Login({ commit }, userInfo) {
    try {
      const result = await login(userInfo);
      if (result.data.code !== 200) {
        throw new Error(result.data.msg);
      }

      const { userJobNumber } = userInfo;
      const res = await getUser(userJobNumber);
      if (res.data.code !== 200) {
        throw new Error(res.data.msg);
      }

      commit("SET_JOBNUMBER", userJobNumber);
      commit("SET_AVATAR", res.data.data.userPicture);
      commit("SET_ROLES", res.data.data.userRole);
      commit("SET_TOKEN", result.data.token);

      const userInfoLocal = Object.assign({}, userInfo, { token: result.data.token, avatar: res.data.data.userPicture });
      await setUserInfo(userInfoLocal);

      return;
    } catch (error) {
      Message.error(error.message || "登录失败");
      throw error;
    }
  },
  // 退出系统
  async LogOut({ commit }, userJobNumber) {
    let result = await logout(userJobNumber)
    if (result.data.code == 200) {
      removeUserInfo()
      Message.success(result.data.msg)
    } else if (result.data.code == 503) {
      Message.error(result.data.msg)
    } else {
      return Promise.reject(new Error("faile"))
    }
  },

  // 前端 登出
  FedLogOut({ commit }) {
    return new Promise(resolve => {
      commit('SET_TOKEN', '')
      removeUserInfo()
      resolve()
    })
  }
}

const getters = {}


export default {
  state,
  mutations,
  actions,
  getters
}