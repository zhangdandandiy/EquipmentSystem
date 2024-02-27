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
                type: 'category',
            },
            yAxis: {
                //隐藏y轴
                show: false,
            },
            //系列
            series: [
                {
                    smooth: true,   //折线图变平滑
                    type: 'line',
                    data: [32, 10, 27, 56, 15, 49, 31, 12, 37, 44, 25, 34],
                    //拐点样式设置
                    itemStyle: {
                        opacity: 0,
                    },
                    lineStyle: {
                        color: '#339933',
                    },
                    //区域填充颜色
                    areaStyle: {
                        opacity: 0.2,
                        color: {
                            type: 'linear',
                            x: 0,
                            y: 0,
                            x2: 0,
                            y2: 1,
                            colorStops: [
                                {
                                    offset: 0,
                                    color: '#339933',
                                },
                                {
                                    offset: 1,
                                    color: 'white',
                                }
                            ],
                            global: false,
                        }
                    }
                }
            ],
            //折线图的布局调试
            grid: {
                left: 0,
                right: 0,
                top: 0,
                bottom: 0,
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