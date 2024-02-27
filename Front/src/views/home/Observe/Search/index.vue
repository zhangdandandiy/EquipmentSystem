<template>
    <el-card>
        <div slot="header" class="header">
            <div class="header-search">
                <span>线上热门搜索</span>
                <el-dropdown>
                    <span class="el-dropdown-link">
                        <i class="el-icon-more"></i>
                    </span>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>黄金糕</el-dropdown-item>
                        <el-dropdown-item>狮子头</el-dropdown-item>
                        <el-dropdown-item>螺蛳粉</el-dropdown-item>
                        <el-dropdown-item>双皮奶</el-dropdown-item>
                        <el-dropdown-item>蚵仔煎</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
            </div>
        </div>
        <div>
            <el-row :gutter="10">
                <el-col :span="12">
                    <left />
                </el-col>
                <el-col :span="12">
                    <right />
                </el-col>
            </el-row>
            <!-- Table表格 -->
            <el-table :data="tableData" style="width: 100% ;margin:20px 0px" border
                :header-cell-style="{ 'text-align': 'center' }">
                <el-table-column label="排名">
                </el-table-column>
                <el-table-column label="搜索关键字">
                </el-table-column>
                <el-table-column label="用户数" sortable>
                </el-table-column>
                <el-table-column label="周涨幅" sortable>
                </el-table-column>
            </el-table>
            <!-- 分页器 -->
            <el-pagination class="pagination" layout="prev,pager,next" :total="100"></el-pagination>
        </div>
    </el-card>
</template>

<script>
import left from './lineCharts/left.vue'
import right from './lineCharts/right.vue'
export default {
    data() {
        return {
            tableData: [],
        }
    },
    components: {
        left,
        right
    }
}
</script>

<style>
.header {
    border-bottom: 1px solid #eee;
    padding: 10px 0px;
}

.header-search {
    display: flex;
    justify-content: space-between;
}

.el-dropdown-link {
    cursor: pointer;
    color: #000;
}

.el-icon-arrow-down {
    font-size: 12px;
}

.pagination {
    display: flex;
    justify-content: space-between;
}
</style>