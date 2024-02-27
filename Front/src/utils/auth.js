/*
 * 用户信息(存至本地存储)
 *
 * @Author: Dandan
 * @Date: 2023-06-09 15:35:35
 */

const UserKey = 'userInfo'

export function getUserInfo() {
    return JSON.parse(localStorage.getItem(UserKey))
}

export function setUserInfo(userInfo) {
    return localStorage.setItem(UserKey, JSON.stringify(userInfo))
}

export function removeUserInfo() {
    return localStorage.removeItem(UserKey)
}
