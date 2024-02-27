/*
 * @Author: Dandan
 * @Date: 2023-08-24 12:54:00
 */
let chart = echarts.init(document.getElementById('yourChartId')/*, myEchartsTheme */); /** 选择你的chartId 也可以设置主题(功能待开发,暂时注释掉) **/
let GO = function (__data) {
    data = __data || [];
    let key = data[0];

    console.log('data', data);
    let cols = [];
    for (m in key) {
        cols.push({ field: m, title: m });
    }
    table.render({
        elem: '#tableReport',
        data: data,
        page: true,
        limits: [10, 100, 500, 2000, 5000, 10000, 20000, 500000, 1000000],
        cellMinWidth: 100,
        cols: [cols],
    });
    // 导出excel
    $('#btnExp').click(function () {
        table.exportFile('tableReport', table.cache['tableReport'], 'xls');
    });

}


// 移除按钮
var button = document.getElementById("btnSearch");
button.parentNode.removeChild(button);

// 父结点
var buttonParentNode = $('.layui-col-lg-offset').get(0);


var newbutton = document.createElement("button");
// 给按钮添加样式和文本
newbutton.classList.add("layui-btn", "icon-btn");
newbutton.innerHTML = '查询';
// 添加id属性
newbutton.setAttribute('id', 'newbutton');
buttonParentNode.appendChild(newbutton);

$('#newbutton').click(function(){
    let __param = { _a__a:"a"  , temaid: formSelects.value('temaid','valStr') , startime: $('#startime').val()  , endtime: $('#endtime').val() }
    __param.limit=200000;
    $.req({type:'get',url:"/report/WZBU8/universal/GetJSON/m_Assysn_tBU14_20230621_TEST", data:__param,
        success:function(res){
            if(res.code!==200){layer.msg(res.msg); return false;}
            GO(res.data.data);
        }
    });
});