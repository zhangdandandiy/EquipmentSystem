/*
 * @Author: Dandan
 * @Date: 2023-06-05 11:13:10
 */
import request from '@/utils/request'

const targetUrl = 'http://localhost:8091'

export const uploadMaintenanceFile = (data) => request({
    url: targetUrl + '/maintenancefile/upload',
    data,
    method: 'post'
})

export function deleteMaintenanceFile(id) {
    return axios({
        url: targetUrl + `/maintenancefile/delete/${id}`,
        method: 'delete'
    })
}


export async function downloadMaintenanceFile(id) {
    const url = targetUrl + `/maintenancefile/download/${id}`
    return await request.get(url, {
        responseType: 'blob',
    });
}

export async function previewMaintenanceFile(id) {
    const url = targetUrl + `/maintenancefile/preview/${id}`
    return await axios.get(url, {
        responseType: 'blob',
    });
}