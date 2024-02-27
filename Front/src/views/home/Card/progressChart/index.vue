<template>
    <!-- 容器 -->
    <div class="charts" ref="charts">
    </div>
</template>

<script>
import * as echarts from 'echarts';
export default {
    mounted() {
        //初始化echarts实例
        let lineCharts = echarts.init(this.$refs.charts);
        //配置数据
        lineCharts.setOption({
            xAxis: {
                //隐藏x轴
                show: false,
                //最小值与最大值的设置
                max: 100,
                min: 0,
            },
            yAxis: {
                //隐藏y轴
                show: false,
                //均分
                type: 'category',
            },
            //系列
            series: [
                {
                    type: 'bar',
                    data: [78],
                    //柱状图的宽度
                    barWidth: 10,
                    color: 'yellowgreen',
                    //背景颜色设置
                    showBackground: true,
                    backgroundstyle: {
                        color: '#eee',
                    },
                    //文本显示
                    label: {
                        show: true,
                        formatter: '|',
                        position: 'right',
                    }
                }
            ],
            //折线图的布局调试
            grid: {
                left: 0,
                right: 0,
                top: 0,
                bottom: 0,
            },
            tooltip: {
                show: true,
            },
        })
    }
}
</script>

<style>
.charts {
    height: 100%;
    width: 100%;
}
</style>