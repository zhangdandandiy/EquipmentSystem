import request from '@/utils/request'

const targetUrl = 'http://localhost:8091'

// 设备操作规范
export const uploadStandardFile = (data) => request({
    url: targetUrl + '/standardfile/upload',
    method: 'post',
    data
})

export async function deleteStandardFile(id) {
    return await axios({
        url: targetUrl + `/standardfile/delete/${id}`,
        method: 'delete'
    })
}

export async function downloadStandardFile(id) {
    const url = targetUrl + `/standardfile/download/${id}`
    return await request.get(url, {
        responseType: 'blob',
    });
}

export async function previewStandardFile(id) {
    const url = targetUrl + `/standardfile/preview/${id}`
    return await axios.get(url, {
        responseType: 'blob',
    });
}