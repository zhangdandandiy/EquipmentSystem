import request from '@/utils/request'

const targetUrl = 'http://localhost:8091'

// 文件上传
export const uploadRecordFile = (params) => request({
    url: targetUrl + `/recordfile/upload`,
    method: 'post',
    data: params
})

//  文件删除  
export async function deleteRecordFile(id) {
    return await axios({
        url: targetUrl + `/recordfile/delete/${id}`,
        method: 'delete'
    })
}

// 文件下载 
export async function downloadRecordFile(id) {
    const url = targetUrl + `/recordfile/download/${id}`
    return await request.get(url, {
        responseType: 'blob',
    });
}

// 文件预览
export async function previewRecordFile(id) {
    const url = targetUrl + `/recordfile/preview/${id}`
    return await axios.get(url, {
        responseType: 'blob',
    });
}

