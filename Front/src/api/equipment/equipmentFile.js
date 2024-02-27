/*
 * @Author: Dandan
 * @Date: 2023-06-05 11:18:42
 */
import request from '@/utils/request'
// 引入格式化时间的方法
import { formatDateTime } from "@/utils/index.js";

const targetUrl = 'http://localhost:8091'
// 文件查询
export async function searchRecordFile(params) {
    let url = targetUrl + `/recordfile/allFile`;
    var result = [];
    await request.get(url, {
        product: params.project,
        line: params.line,
        machine: params.machine,
    }).then(
        res => {
            res.data.forEach(item => {
                let uploadTime = formatDateTime(item.record_file_upload_time);
                let fileObj = {
                    id: item.id,
                    file: item.record_file_name,
                    path: item.record_file_path,
                    time: uploadTime
                }
                result.push(fileObj)
            })
        },
        err => {
            this.$message({
                showClose: true,
                message: '数据请求失败' + err,
                type: 'error'
            });
        })
    return result
}