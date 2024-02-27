<template>
  <el-card>
    <div slot="header">
      <div class="header-category">
        <span>销售额类别占比</span>
        <span>
          <el-radio-group size="small" v-model="value">
            <el-radio-button label="全部渠道"></el-radio-button>
            <el-radio-button label="线上"></el-radio-button>
            <el-radio-button label="门店"></el-radio-button>
          </el-radio-group>
        </span>
      </div>
    </div>
    <div>
      <div class="charts" ref="charts"></div>
    </div>
  </el-card>
</template>

<script>
import * as echarts from 'echarts'
export default {
  data() {
    return {
      value: '全部渠道',
    }
  },
  mounted() {
    let mycharts = echarts.init(this.$refs.charts);
    mycharts.setOption({
      title: {
        text: 'Search Engine',
        subtext: 1048,
        left: 'center',
        top: 'center',
      },
      tooltip: {
        trigger: 'item'
      },
      series: [
        {
          name: 'Access From',
          type: 'pie',
          radius: ['40%', '70%'],
          avoidLabelOverlap: false,
          data: [
            { value: 1048, name: 'Search Engine' },
            { value: 735, name: 'Direct' },
            { value: 580, name: 'Email' },
            { value: 484, name: 'Union Ads' },
            { value: 300, name: 'Video Ads' }
          ],
          itemStyle: {
            borderRadius: 10,
            borderColor: '#fff',
            borderWidth: 2
          },
        }
      ]
    });
    //绑定事件
    mycharts.on('mouseover', (params) => {
      const { name, value } = params.data;
      mycharts.setOption({
        title: {
          text: name,
          subtext: value,
        }
      })
    })
  }
}
</script>

<style scoped>
.header-category {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.charts {
  width: 100%;
  height: 327px;
}
</style>