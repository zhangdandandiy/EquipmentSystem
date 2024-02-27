<template>
  <div class="app-container">
    <el-row :gutter="20">
      <!-- 角色数据 -->
      <el-col :span="4" :xs="24">
        <div class="head-container">
          <el-select
            size="mini"
            v-model="userParams.userRole"
            clearable
            placeholder="请选择角色名称"
          >
            <el-option
              v-for="(item, index) in allSystemRoles"
              :key="index"
              :value="item.roleName"
            >
            </el-option>
          </el-select>
        </div>
        <div class="head-container"></div>
      </el-col>
      <!-- 用户数据 -->
      <el-col :span="20" :xs="24">
        <el-form
          :model="userParams"
          ref="queryForm"
          size="small"
          :inline="true"
          v-show="showSearch"
          label-width="68px"
        >
          <el-form-item label="用户工号" prop="userJobNumber">
            <el-input
              v-model="userParams.userJobNumber"
              placeholder="请输入工号"
              clearable
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="手机号码" prop="userPhoneNumber">
            <el-input
              v-model="userParams.userPhoneNumber"
              placeholder="请输入手机号码"
              clearable
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="状态" prop="userStatusCollect">
            <el-select
              v-model="userStatusCollect"
              placeholder="用户状态"
              clearable
              style="width: 240px"
            >
              <el-option
                v-for="(item, index) in userAllStatus"
                :key="index"
                :label="item"
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
              type="info"
              plain
              icon="el-icon-upload2"
              size="mini"
              @click="handleImport"
              >导入</el-button
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
            :columns="columns"
          ></right-toolbar>
        </el-row>

        <el-table
          ref="table"
          :data="userList"
          @selection-change="handleSelectionChange"
        >
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column
            label="用户编号"
            align="center"
            key="userID"
            prop="userID"
            v-if="columns[0].visible"
          />
          <el-table-column
            label="用户工号"
            align="center"
            key="userJobNumber"
            prop="userJobNumber"
            v-if="columns[1].visible"
            :show-overflow-tooltip="true"
          />
          <el-table-column
            label="用户名称"
            align="center"
            key="userName"
            prop="userName"
            v-if="columns[2].visible"
            :show-overflow-tooltip="true"
          />
          <el-table-column
            label="用户角色"
            align="center"
            key="userRole"
            prop="userRole"
            v-if="columns[3].visible"
            :show-overflow-tooltip="true"
          />
          <el-table-column
            label="手机号码"
            align="center"
            key="userPhoneNumber"
            prop="userPhoneNumber"
            v-if="columns[4].visible"
            width="120"
          />
          <el-table-column
            label="状态"
            align="center"
            key="userStatus"
            v-if="columns[5].visible"
          >
            <template slot-scope="scope">
              <el-switch
                v-model="scope.row.userStatus"
                active-value="1"
                inactive-value="0"
                @change="handleStatusChange(scope.row)"
              ></el-switch>
            </template>
          </el-table-column>
          <el-table-column
            label="创建时间"
            align="center"
            key="userCreateTime"
            prop="userCreateTime"
            v-if="columns[6].visible"
            width="160"
          >
          </el-table-column>
          <el-table-column
            label="操作"
            align="center"
            width="160"
            class-name="small-padding fixed-width"
          >
            <template slot-scope="scope" v-if="scope.row.userID !== 1">
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
                icon="el-icon-key"
                @click="handleResetPassword(scope.row)"
                >重置密码</el-button
              >
            </template>
          </el-table-column>
        </el-table>

        <pagination
          v-show="total > 0"
          :total="total"
          :page.sync="userParams.pageNum"
          :limit.sync="userParams.pageSize"
          @pagination="getList"
        />
      </el-col>
    </el-row>

    <!-- 添加或修改用户配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
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
    </el-dialog>
  </div>
</template>
<script>
import {
  listUser,
  alterUser,
  deleteUser,
  getUser,
  addUser,
  resetUser,
} from "@/api/user";
import { getAllRole } from "@/api/role";
import { Message } from "element-ui";
import { exportExcel } from "@/utils/file";
export default {
  data() {
    return {
      // 显示搜索条件
      showSearch: true,
      // 日期范围
      dateRange: [],
      // 角色名
      roleName: "",
      // 列信息
      columns: [
        { key: "userID", name: `用户编号`, visible: true },
        { key: "userJobNumber", name: `用户工号`, visible: true },
        { key: "userName", name: `用户名称`, visible: true },
        { key: "userRole", name: `用户角色`, visible: true },
        { key: "userPhoneNumber", name: `手机号码`, visible: true },
        { key: "userStatus", name: `状态`, visible: true },
        { key: "userCreateTime", name: `创建时间`, visible: true },
      ],
      // 表单数据
      userParams: {
        pageNum: 1,
        pageSize: 5,
        userCreateStartTime: "",
        userCreateEndTime: "",
        userJobNumber: "",
        userPhoneNumber: "",
        userStatus: "",
        userRole: "",
      },
      // 用户状态下拉框
      userAllStatus: ["正常", "停用"],
      // 用户状态收集
      userStatusCollect: undefined,
      // 用户表格数据
      userList: null,
      // 总条数
      total: 0,
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 选中数组
      ids: [],
      // 选中工号
      userJobNumbers: [],
      // 是否显示弹出层
      open: false,
      // 弹出层标题
      title: "",
      // 表单参数
      form: {
        userJobNumber: "",
        userName: "",
        userRole: "",
        userPhoneNumber: "",
        userStatus: "",
      },
      // 表单校验
      rules: {
        userJobNumber: [
          { required: true, message: "用户工号不能为空", trigger: "blur" },
          {
            min: 2,
            max: 20,
            message: "用户名称长度必须介于 2 和 20 之间",
            trigger: "blur",
          },
        ],
        userPhoneNumber: [
          {
            pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
            message: "请输入正确的手机号码",
            trigger: "blur",
          },
        ],
      },
      // 工号是否禁用
      disabled: true,
      // 所有用户角色
      allSystemRoles: [],
    };
  },
  created() {
    this.getList();
    this.getAllRole();
  },
  methods: {
    /* 查询用户列表 */
    async getList() {
      const { dateRange, userParams, userStatusCollect } = this;
      if (dateRange != null) {
        userParams.userCreateStartTime = dateRange[0];
        userParams.userCreateEndTime = dateRange[1];
      }
      const userStatusMap = {
        正常: "1",
        停用: "0",
      };
      userParams.userStatus = userStatusMap[userStatusCollect] || null;
      try {
        const {
          data: { data },
        } = await listUser(userParams);
        this.userList = data.list;
        this.total = data.totalCount;
      } catch (error) {
        Message.error(error);
      }
    },
    /* 查询角色列表 */
    async getAllRole() {
      try {
        const {
          data: { data },
        } = await getAllRole();
        this.allSystemRoles = data;
      } catch (error) {
        Message.error(error);
      }
    },
    /* 用户状态修改 */
    handleStatusChange(row) {
      let text = row.userStatus === "1" ? " 启用 " : " 停用 ";
      let params = {};
      this.$confirm(`确认要 ${text} ${row.userName} 吗？`)
        .then(() => {
          params.userJobNumber = row.userJobNumber;
          if (row.userStatus == "1") {
            params.userStatus = "1";
          } else {
            params.userStatus = "0";
          }
          return alterUser(params);
        })
        .then(() => {
          Message.success(text + "成功");
        })
        .catch(function () {
          row.userStatus = row.userStatus === "0" ? "1" : "0";
        });
    },
    /* 多选框选中数据 */
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => item.userID);
      this.userJobNumbers = selection.map((item) => item.userJobNumber);
      this.single = selection.length != 1;
      this.multiple = !selection.length;
    },
    /* 搜索按钮操作 */
    handleQuery() {
      this.userParams.pageNum = 1;
      this.getList();
    },
    /* 添加按钮操作 */
    handleAdd() {
      this.form = {};
      this.disabled = false;
      this.open = true;
      this.title = "添加用户";
    },
    /* 导入按钮操作 */
    handleImport() {},
    /* 导出按钮操作 */
    handleExport() {
      const selectData = this.$refs.table.selection;
      exportExcel(this.columns, selectData, "用户信息");
    },
    /* 修改按钮操作 */
    handleUpdate(row) {
      this.resetForm();
      this.open = true;
      this.disabled = true;
      const userJobNumber = row.userJobNumber || this.userJobNumbers;
      getUser(userJobNumber).then((res) => {
        const userInfo = res.data.data;
        this.form = {
          userName: userInfo.userName,
          userJobNumber: userInfo.userJobNumber,
          userRole: userInfo.userRole,
          userPhoneNumber: userInfo.userPhoneNumber,
          userStatus: userInfo.userStatus,
        };
        this.title = "修改用户";
      });
    },
    /* 删除按钮操作 */
    handleDelete(row) {
      const userID = row.userID || this.ids;
      const userJobNumber = row.userJobNumber || this.userJobNumbers;
      this.$confirm(`确认要删除 ${userJobNumber} 吗？`)
        .then(() => {
          return deleteUser(userID);
        })
        .then((res) => {
          Message.success(res.data.msg);
          this.getList();
        })
        .catch(() => {});
    },
    /* 重置密码按钮操作 */
    handleResetPassword(row) {
      resetUser(row.userJobNumber).then((res) => {
        const message = res.data.code === 200 ? Message.success : Message.error;
        message(res.data.msg);
      });
    },
    /* 重置按钮操作 */
    resetQuery() {
      this.dateRange = [];
      this.resetForm();
      this.handleQuery();
    },
    /* 清除表单数据 */
    resetForm() {
      this.userParams = {
        pageNum: 1,
        pageSize: 5,
        userCreateStartTime: "",
        userCreateEndTime: "",
        userJobNumber: "",
        userPhoneNumber: "",
        userStatus: "",
      };
      this.userStatusCollect = undefined;
    },
    /* 提交按钮 */
    submitForm() {
      const userStatus = this.form.userStatus === "停用" ? "0" : "1";

      const params = {
        userName: this.form.userName,
        userJobNumber: this.form.userJobNumber,
        userRole: this.form.userRole,
        userPhoneNumber: this.form.userPhoneNumber,
        userStatus,
      };

      let request = null;

      if (this.title == "添加用户") {
        request = addUser(params);
      } else if (this.title == "修改用户") {
        request = alterUser(params);
      }

      request.then((res) => {
        const message = res.data.code === 200 ? Message.success : Message.error;
        message(res.data.msg);
        this.getList();
        this.open = false;
      });
    },
    /* 取消按钮 */
    cancel() {},
  },
};
</script>
