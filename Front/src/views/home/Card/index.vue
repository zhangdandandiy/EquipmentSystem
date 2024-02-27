<template>
  <div>
    <el-row :gutter="10">
      <el-col :span="6">
        <el-card>
          <!-- 第一个Card -->
          <Detail title="总销售额" count="￥126560">
            <template slot="charts">
              <span>
                同周比 65.67%
                <svg t="1669440011964" class="icon" viewBox="0 0 1024 1024" version="1.1"
                  xmlns="http://www.w3.org/2000/svg" p-id="2671" width="16" height="16">
                  <path
                    d="M858.9 689L530.5 308.2c-9.4-10.9-27.5-10.9-37 0L165.1 689c-12.2 14.2-1.2 35 18.5 35h656.8c19.7 0 30.7-20.8 18.5-35z"
                    p-id="2672" fill="#d81e06"></path>
                </svg>
              </span>
              &nbsp;
              <span>
                日同比 19.16%
                <svg t="1669440131191" class="icon" viewBox="0 0 1024 1024" version="1.1"
                  xmlns="http://www.w3.org/2000/svg" p-id="3741" width="16" height="16">
                  <path
                    d="M840.4 300H183.6c-19.7 0-30.7 20.8-18.5 35l328.4 380.8c9.4 10.9 27.5 10.9 37 0L858.9 335c12.2-14.2 1.2-35-18.5-35z"
                    p-id="3742" fill="#1afa29"></path>
                </svg>
              </span>
            </template>
            <template slot="footer">
              <span>日销售额 ￥12412</span>
            </template>
          </Detail>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card>
          <!-- 第二个Card -->
          <Detail title="访问量" count="88460">
            <template slot="charts">
              <lineChart></lineChart>
            </template>
            <template slot="footer">日访问量 1234</template>
          </Detail>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card>
          <!-- 第三个Card -->
          <Detail title="支付笔数" count="88460">
            <template slot="charts">
              <barChart></barChart>
            </template>
            <template slot="footer">
              <span>转化率65%</span>
            </template>
          </Detail>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card>
          <!-- 第四个Card -->
          <Detail title="运营活动效果" count="70%">
            <template slot="charts">
              <progressChart></progressChart>
            </template>
            <template slot="footer">
              <span>
                同周比 12%
                <svg t="1669440011964" class="icon" viewBox="0 0 1024 1024" version="1.1"
                  xmlns="http://www.w3.org/2000/svg" p-id="2671" width="16" height="16">
                  <path
                    d="M858.9 689L530.5 308.2c-9.4-10.9-27.5-10.9-37 0L165.1 689c-12.2 14.2-1.2 35 18.5 35h656.8c19.7 0 30.7-20.8 18.5-35z"
                    p-id="2672" fill="#d81e06"></path>
                </svg>
              </span>
              <span>
                同日比 11
                <svg t="1669440131191" class="icon" viewBox="0 0 1024 1024" version="1.1"
                  xmlns="http://www.w3.org/2000/svg" p-id="3741" width="16" height="16">
                  <path
                    d="M840.4 300H183.6c-19.7 0-30.7 20.8-18.5 35l328.4 380.8c9.4 10.9 27.5 10.9 37 0L858.9 335c12.2-14.2 1.2-35-18.5-35z"
                    p-id="3742" fill="#1afa29"></path>
                </svg>
              </span>
            </template>
          </Detail>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import Detail from './Detail'
import lineChart from './lineChart'
import barChart from './barChart'
import progressChart from './progressChart'
export default {
  components: {
    Detail,
    lineChart,
    barChart,
    progressChart,
  }
}
</script>

<style>

</style>