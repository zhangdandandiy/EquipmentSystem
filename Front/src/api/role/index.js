/*
 * @Author: Dandan
 * @Date: 2023-06-24 10:31:13
 */
import request from "@/utils/request"

// 获取所有用户角色
export function getAllRole() {
    return request({
        url: '/system/role/searchAllRole',
        method: 'get'
    })
}

// 根据搜索条件查找角色
export function searchRoleList(data) {
    return request({
        url: '/system/role/searchList',
        method: 'post',
        data: data
    })
}