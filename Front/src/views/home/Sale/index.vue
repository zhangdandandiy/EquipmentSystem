<template>
    <el-card class="box-card" style="margin: 10px 0px">
        <div slot="header" class="clearfix">
            <!-- 头部左侧内容 -->
            <el-tabs class="tab" v-model="activeName">
                <el-tab-pane label="销售额" name="sale"></el-tab-pane>
                <el-tab-pane label="访问量" name="visit"></el-tab-pane>
            </el-tabs>
            <!-- 头部右侧内容 -->
            <div class="right">
                <span @click="setDay">今日</span>
                <span @click="setWeek">本周</span>
                <span @click="setMonth">本月</span>
                <span @click="setYear">本年</span>
                <el-date-picker v-model="date" size="mini" class="date" type="daterange" range-separator="-"
                    start-placeholder="开始日期" end-placeholder="结束日期" value-format="yyyy-MM-dd">
                </el-date-picker>
            </div>
        </div>
        <div>
            <el-row :gutter="10">
                <el-col :span="18">
                    <!-- 容器 -->
                    <div class="charts" ref="charts"></div>
                </el-col>
                <el-col :span="6" class="right">
                    <h3>门店{{ title }}排名</h3>
                    <ul>
                        <li>
                            <span class="rindex">1</span>
                            <span>肯德基</span>
                            <span class="rvalue">121884</span>
                        </li>
                        <li>
                            <span class="rindex">2</span>
                            <span>麦当劳</span>
                            <span class="rvalue">111884</span>
                        </li>
                        <li>
                            <span class="rindex">3</span>
                            <span>海底捞</span>
                            <span class="rvalue">111804</span>
                        </li>
                        <li>
                            <span class="rindexbottom">4</span>
                            <span>周黑鸭</span>
                            <span class="rvalue">111704</span>
                        </li>
                        <li>
                            <span class="rindexbottom">5</span>
                            <span>煌上煌</span>
                            <span class="rvalue">102704</span>
                        </li>
                        <li>
                            <span class="rindexbottom">6</span>
                            <span>芝小官</span>
                            <span class="rvalue">101704</span>
                        </li>
                        <li>
                            <span class="rindexbottom">7</span>
                            <span>麻辣烫</span>
                            <span class="rvalue">100999</span>
                        </li>
                    </ul>
                </el-col>
            </el-row>
        </div>
    </el-card>
</template>
  
<script>
//引入echarts
import * as echarts from "echarts";
import * as dayjs from 'dayjs';
export default {
    name: "",
    data() {
        return {
            activeName: "sale",
            barCharts: null,
            date: [],
        };
    },
    //组件挂载完毕开始渲染柱状图
    mounted() {
        //初始化echarts实例
        this.barCharts = echarts.init(this.$refs.charts);
        //配置项数据
        this.barCharts.setOption({
            title: {
                text: '销售额趋势',
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [
                {
                    type: 'category',
                    data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
                    axisTick: {
                        alignWithLabel: true
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: [
                {
                    name: 'Direct',
                    type: 'bar',
                    barWidth: '60%',
                    data: [400, 91, 212, 334, 312, 432, 310, 298, 245, 561, 391, 509],
                    barWidth: '25px',
                }
            ],
        })
    },
    computed: {
        //计算属性--标题
        title() {
            return this.activeName == 'sale' ? '销售额趋势' : '访问量趋势';
        }
    },
    //监听属性
    watch: {
        title() {
            //重新修改图表的配置数据
            //图表的配置数据可以再次修改
            this.barCharts.setOption({
                title: {
                    text: this.title,
                },
            })
        }
    },
    methods: {
        //本天
        setDay() {
            const day = dayjs().format('YYYY-MM-DD');
            this.date = [day, day];
        },
        //本周
        setWeek() {
            const start = dayjs().day(1).format('YYYY-MM-DD');
            const end = dayjs().day(7).format('YYYY-MM-DD');
            this.date = [start, end];
        },
        //本月
        setMonth() {
            const start = dayjs().startOf('month').format('YYYY-MM-DD');
            const end = dayjs().endOf('month').format('YYYY-MM-DD');
            this.date = [start, end];
        },
        //本年
        setYear() {
            const start = dayjs().startOf('year').format('YYYY-MM-DD');
            const end = dayjs().endOf('year').format('YYYY-MM-DD');
            this.date = [start, end];
        }
    }
};
</script>
  
<style scoped>
.clearfix {
    position: relative;
    display: flex;
    justify-content: space-between;
}

.tab {
    width: 100%;
}

.right {
    position: absolute;
    right: 0px;
}

.date {
    width: 250px;
    margin: 0px 20px;
}

.right span {
    margin: 0px 10px;
}

.charts {
    width: 100%;
    height: 300px;
}

ul {
    list-style: none;
    width: 100%;
    height: 300px;
    padding: 0px;
}

ul li {
    height: 8%;
    margin: 10px 0px;
}

.rindex {
    float: left;
    width: 20px;
    height: 20px;
    border-radius: 50%;
    background: black;
    color: white;
    text-align: center;
}

.rvalue {
    float: right;
}

.rindexbottom {
    float: left;
    width: 20px;
    height: 20px;
    border-radius: 50%;
    background: white;
    color: black;
    text-align: center;
}
</style>
  