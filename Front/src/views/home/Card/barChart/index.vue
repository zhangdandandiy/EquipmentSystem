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
                //均分
                type: 'category',
            },
            yAxis: {
                //隐藏y轴
                show: false,
            },
            //系列
            series: [
                {
                    type: 'bar',
                    data: [32, 10, 27, 56, 15, 49, 31, 12, 37, 44, 25, 34],
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
            }
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