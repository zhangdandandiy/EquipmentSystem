/*
 * @Author: Dandan
 * @Date: 2023-06-05 13:14:57
 */
import request from '@/utils/request'

// 上传用户头像
export function uploadUser(data) {
    return request({
        url: '/system/user/uploadAvatar',
        method: 'put',
        data: data,
        headers: { 'Content-Type': 'multipart/form-data' }
    })
}

// 重置用户密码
export function resetUser(userJobNumber) {
    return request({
        url: `/system/user/reset?userJobNumber=${userJobNumber}`,
        method: 'put'
    })
}

// 添加用户
export function addUser(params) {
    return request({
        url: '/system/user/addUser',
        method: 'post',
        params: params
    })
}

// 获取用户详细信息
export function getUser(userJobNumber) {
    return request({
        url: `/system/user/userInfo?userJobNumber=${userJobNumber}`,
        method: 'get'
    })
}

// 查询用户列表
export function listUser(data) {
    return request({
        url: '/system/user/searchList',
        method: 'post',
        data: data
    })
}

// 修改用户信息
export function alterUser(params) {
    return request({
        url: '/system/user/update',
        method: 'put',
        params: params
    })
}

// 删除用户
export function deleteUser(data) {
    return request({
        url: `/system/user/delete/${data}`,
        method: 'delete'
    })
}

// 登录方法
export function login(data) {
    return request({
        url: '/system/user/login',
        headers: {
            isToken: false
        },
        method: 'post',
        data: data
    })
}

// 注册方法
export function register(data) {
    return request({
        url: '/register',
        headers: {
            isToken: false
        },
        method: 'post',
        data: data
    })
}

// 退出方法
export function logout(data) {
    return request({
        url: `/system/user/logout/?userJobNumber=${data}`,
        method: 'post',
    })
}

// 获取验证码
export function getCodeImg() {
    return request({
        url: '/system/code/getCaptcha',
        headers: {
            isToken: false
        },
        method: 'get',
        timeout: 20000
    })
}