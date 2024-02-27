<!--
 * @Author: Dandan
 * @Date: 2023-06-12 13:53:20
-->
<template>
  <div class="app-container">
    <el-form
      :model="roleQueryParams"
      ref="queryForm"
      size="small"
      :inline="true"
      v-show="showSearch"
    >
      <el-form-item label="角色名称" prop="roleName">
        <el-input
          v-model="roleQueryParams.roleName"
          placeholder="请输入角色名称"
          clearable
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="权限字符" prop="roleCharacter">
        <el-input
          v-model="roleQueryParams.roleCharacter"
          placeholder="请输入权限字符"
          clearable
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="roleStatusCollect">
        <el-select
          v-model="roleStatusCollect"
          placeholder="角色状态"
          clearable
          style="width: 240px"
        >
          <el-option
            v-for="(item, index) in roleAllStatus"
            :key="index"
            :value="item"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="创建时间">
        <el-date-picker
          v-model="dateRange"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button
          type="primary"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
          >搜索</el-button
        >
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
          >重置</el-button
        >
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          >新增</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          >修改</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          >删除</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          >导出</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="roleList"
      :header-cell-style="{ 'text-align': 'center' }"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column
        label="角色编号"
        prop="roleID"
        width="120"
        align="center"
      />
      <el-table-column
        label="角色名称"
        prop="roleName"
        :show-overflow-tooltip="true"
        width="150"
        align="center"
      />
      <el-table-column
        label="权限字符"
        prop="roleCharacter"
        :show-overflow-tooltip="true"
        width="150"
        align="center"
      />
      <el-table-column
        label="显示顺序"
        prop="roleOrder"
        width="100"
        align="center"
      />
      <el-table-column label="状态" align="center" width="100">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.roleStatus"
            active-value="1"
            inactive-value="0"
            @change="handleStatusChange(scope.row)"
          ></el-switch>
        </template>
      </el-table-column>
      <el-table-column
        label="创建时间"
        align="center"
        prop="roleCreateTime"
        width="280"
      >
      </el-table-column>
      <el-table-column label="角色描述" prop="roleRemark" width="280">
      </el-table-column>
      <el-table-column
        label="操作"
        align="center"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope" v-if="scope.row.roleID !== 1">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            >删除</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-circle-check"
            @click="handleDataScope"
            >数据权限</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-user"
            @click="handleAuthUser"
            >分配用户</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="roleQueryParams.pageNum"
      :limit.sync="roleQueryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改角色配置对话框 -->
    <!-- <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="用户工号" prop="userJobNumber">
              <el-input
                v-model="form.userJobNumber"
                placeholder="请输入用户工号"
                maxlength="30"
                :disabled="disabled"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="用户名称" prop="userName">
              <el-input
                v-model="form.userName"
                placeholder="请输入用户名称"
                maxlength="11"
              />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="用户角色" prop="userRole">
              <el-input
                v-model="form.userRole"
                placeholder="请输入用户角色"
                maxlength="11"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="手机号码" prop="userPhoneNumber">
              <el-input
                v-model="form.userPhoneNumber"
                placeholder="请输入手机号码"
                maxlength="11"
              />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="用户状态">
              <el-radio-group v-model="form.userStatus">
                <el-radio
                  v-for="(item, index) in userAllStatus"
                  :key="index"
                  :label="item"
                  >{{ item }}</el-radio
                >
              </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col :span="12"> </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog> -->
  </div>
</template>
<script>
import { searchRoleList } from "@/api/role/index";
import { Message } from "element-ui";
export default {
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 查询角色参数
      roleQueryParams: {
        pageNum: 1,
        pageSize: 10,
        roleCharacter: "",
        roleCompetence: "",
        roleEndTime: "",
        roleName: "",
        roleRemark: "",
        roleStartTime: "",
        roleStatus: "",
      },
      // 角色状态下拉框
      roleAllStatus: ["正常", "停用"],
      // 收集角色状态
      roleStatusCollect: "",
      // 日期范围
      dateRange: [],
      // 角色列表
      roleList: [],
      // 总条数
      total: 0,
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /* 查询角色列表 */
    async getList() {
      const { dateRange, roleQueryParams, roleStatusCollect } = this;
      if (dateRange != null) {
        roleQueryParams.roleStartTime = dateRange[0];
        roleQueryParams.roleEndTime = dateRange[1];
      }
      const roleStatusMap = {
        正常: "1",
        停用: "0",
      };
      roleQueryParams.roleStatus = roleStatusMap[roleStatusCollect] || null;
      try {
        const {
          data: { data },
        } = await searchRoleList(roleQueryParams);
        this.roleList = data.list;
        this.total = data.totalCount;
        this.loading = false;
      } catch (error) {
        Message.error(error);
      }
    },
    /* 搜索按钮操作 */
    handleQuery() {
      this.roleQueryParams.pageNum = 1;
      this.getList();
    },
    /* 重置按钮操作 */
    resetQuery() {
      this.dateRange = [];
      this.resetForm();
      this.handleQuery();
    },
    /* 重置表单操作 */
    resetForm() {
      this.roleQueryParams = {
        pageNum: 1,
        pageSize: 10,
        roleCharacter: "",
        roleCompetence: "",
        roleEndTime: "",
        roleName: "",
        roleRemark: "",
        roleStartTime: "",
        roleStatus: "",
      };
      this.roleStatusCollect = undefined;
    },
    /* 新增按钮操作 */
    handleAdd() {},
    /* 修改按钮操作 */
    handleUpdate() {},
    /* 删除按钮操作 */
    handleDelete() {},
    /* 导出按钮操作 */
    handleExport() {},
    /* 多选框选中数据 */
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => item.roleID);
      this.single = selection.length != 1;
      this.multiple = !selection.length;
    },
    /* 数据权限按钮 */
    handleDataScope() {},
    /* 分配用户按钮 */
    handleAuthUser() {},
  },
};
</script>

