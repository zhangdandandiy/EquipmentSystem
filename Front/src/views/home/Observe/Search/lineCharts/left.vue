<template>
    <div>
        <div class="header">
            <span class="header-search">搜索用户数</span>
            <svg t="1669770397536" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
                p-id="3609" width="16" height="16">
                <path
                    d="M512 0C229.23 0 0 229.23 0 512s229.23 512 512 512 512-229.23 512-512S794.77 0 512 0zM512 928c-229.75 0-416-186.25-416-416S282.25 96 512 96s416 186.25 416 416S741.75 928 512 928z"
                    p-id="3610" fill="#707070"></path>
                <path
                    d="M537.64 343.452c47.074 0 83.266-37.528 83.266-78.072 0-32.46-20.832-60.878-62.496-60.878-54.816 0-82.178 44.618-82.178 77.11C475.144 320.132 498.152 343.452 537.64 343.452z"
                    p-id="3611" fill="#707070"></path>
                <path
                    d="M533.162 728.934c-7.648 0-10.914-10.136-3.264-39.55l43.25-166.406c16.386-60.848 10.944-100.398-21.92-100.398-39.456 0-131.458 39.83-211.458 107.798l16.416 27.392c25.246-17.256 67.906-34.762 77.792-34.762 7.648 0 6.56 10.168 0 35.508l-37.746 158.292c-23.008 89.266 1.088 109.538 33.984 109.538 32.864 0 117.808-30.47 195.57-109.632l-18.656-25.34C575.354 716.714 543.05 728.934 533.162 728.934z"
                    p-id="3612" fill="#707070"></path>
            </svg>
        </div>
        <div class="body">
            <span class="body-title">12318</span>
            <span class="body-content">17.1</span>
            <svg t="1669440011964" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
                p-id="2671" width="16" height="16">
                <path
                    d="M858.9 689L530.5 308.2c-9.4-10.9-27.5-10.9-37 0L165.1 689c-12.2 14.2-1.2 35 18.5 35h656.8c19.7 0 30.7-20.8 18.5-35z"
                    p-id="2672" fill="#d81e06"></path>
            </svg>
            <svg t="1669440131191" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
                p-id="3741" width="16" height="16">
                <path
                    d="M840.4 300H183.6c-19.7 0-30.7 20.8-18.5 35l328.4 380.8c9.4 10.9 27.5 10.9 37 0L858.9 335c12.2-14.2 1.2-35-18.5-35z"
                    p-id="3742" fill="#1afa29"></path>
            </svg>
        </div>
        <div class="footer">
            <div class="charts" ref="charts"></div>
        </div>
    </div>
</template>

<script>
import * as echarts from 'echarts';
export default {
    mounted() {
        //初始化echarts实例
        let mycharts = echarts.init(this.$refs.charts);
        //配置数据
        mycharts.setOption({
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
                    data: [12, 29, 27, 46, 9, 49, 11, 12, 37, 64, 25, 34],
                    //拐点样式设置
                    itemStyle: {
                        opacity: 0,
                    },
                    lineStyle: {
                        color: '#6666CC',
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
                                    color: '#6666CC',
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

<style scoped>
.header {
    display: flex;
    align-items: center;
    border-bottom: none;
    /* justify-content: space-between; */
}

.header-search {
    margin-right: 20px;
}

.body {
    margin: 10px 0px;
}

.body-title {
    margin-right: 30px;
}

.body-content {
    margin-right: 30px;
}

.charts {
    width: 100%;
    height: 50px;
}
</style>