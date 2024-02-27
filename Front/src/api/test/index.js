/*
 * @Author: Dandan
 * @Date: 2023-07-04 14:13:35
 */
import request from "@/utils/request"

// 测试导出接口
export function getTestData() {
    return request({
        url: '/test/testExport',
        method: 'get'
    })
}