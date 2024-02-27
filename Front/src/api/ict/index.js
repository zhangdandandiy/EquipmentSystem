/*
 * @Author: Dandan
 * @Date: 2023-06-05 11:18:42
 */
import request from '@/utils/request'

export function test1() {
    return request({
        url: 'http://10.52.5.83:8090/api/get_d8x_optimization_data?ModuleID=M5&date_s=2023-10-23%2011:00:00&date_e=2023-10-23%2012:00:00&LineID=WZ-A87-02',
        method: 'get'
    })
}

export function test2() {
    return request({
        url: 'http://10.52.5.83:8090/api/get_d8x_optimization_data?ModuleID=M5&date_s=2023-10-23%2008:00:00&date_e=2023-10-23%2009:00:00&LineID=WZ-A87-02',
        method: 'get'
    })
}

export function test3() {
    return request({
        url: '/report/WZBU8/universal/GetJson/D8X_Main_Line3_01_M9?limit=1000&noPage=true&ymd=2023-10-30%2000:00:00%20-%202023-10-30%2002:00:00',
        method: 'get'
    })
}

export function savaNewFile(data) {
    return request({
        url: 'http://10.52.6.32:8091/temperature/saveNew',
        method: 'post',
        data
    })
}

export function savaOldFile(tableName) {
    return request({
        url: `http://10.52.6.32:8091/temperature/saveOld?tableName=${tableName}`,
        method: 'post',
        responseType: 'blob'
    })
}