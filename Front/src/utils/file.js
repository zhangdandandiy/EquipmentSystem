/*
 * @Author: Dandan
 * @Date: 2023-06-16 09:12:09
 */


import * as XLSX from "xlsx";

/************************** XLSX *************************/

/**
 * 导出表格数据为 excel
 * @param {*} columns 
 * @param {*} title 
 */
export function exportExcel(columns, selectData, title) {

    const data = [];
    selectData.forEach((item) => {
        const rowData = {};
        columns.forEach((column) => {
            rowData[column.name] = column.convert ? column.convert(item[column.key]) : item[column.key];
        });
        data.push(rowData);
    });
    // 导出Excel表格
    const workSheet = XLSX.utils.json_to_sheet(data);
    const workBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(workBook, workSheet, "Sheet1");
    XLSX.writeFile(workBook, `${title}.xlsx`);
}

/**
 * 导出JSON数据为 excel
 * @param {*} data 
 * @param {*} title 
 */
export function exportDataExcel(data, title) {
    console.time('exportTime')
    // 创建工作簿
    const workbook = XLSX.utils.book_new();
    // 创建工作表
    const worksheet = XLSX.utils.json_to_sheet(data);
    // 将工作表添加到工作簿
    XLSX.utils.book_append_sheet(workbook, worksheet, 'Sheet1');
    XLSX.writeFile(workbook, `${title}.xlsx`);
    console.timeEnd('exportTime')
}


