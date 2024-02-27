/*
 * @Author: Dandan
 * @Date: 2023-05-12 11:17:20
 */
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/home',
    component: Layout,
    children: [
      {
        path: 'home',
        name: 'Home',
        component: () => import('@/views/home/index'),
        meta: { title: '首页', icon: 'el-icon-s-home' }
      }
    ]
  },

  {
    path: '/system',
    component: Layout,
    redirect: 'system/user',
    name: 'System',
    meta: {
      title: '系统管理',
      icon: 'el-icon-s-tools'
    },
    children: [
      {
        path: 'user',
        name: 'User',
        component: () => import('@/views/system/user/index'),
        meta: { title: '用户管理', icon: 'el-icon-user-solid' }
      },
      {
        path: 'profile',
        name: 'Profile',
        component: () => import('@/views/system/user/profile/index'),
        meta: { title: '个人中心', icon: 'el-icon-s-promotion' }
      },
      {
        path: 'role',
        name: 'Role',
        component: () => import('@/views/system/role/index'),
        meta: { title: '角色管理', icon: 'el-icon-plus' }
      },
      {
        path: 'menu',
        name: 'Menu',
        component: () => import('@/views/system/menu/index'),
        meta: { title: '菜单管理', icon: 'el-icon-menu' }
      }
    ]
  },
  {
    path: '/tool',
    component: Layout,
    redirect: 'tool/form',
    name: 'Tool',
    meta: {
      title: '系统工具',
      icon: 'el-icon-s-grid'
    },
    children: [
      {
        path: 'form',
        name: 'Form',
        component: () => import('@/views/tool/form/index'),
        meta: { title: '表单构建', icon: 'el-icon-s-order' }
      },
      {
        path: 'code',
        name: 'Code',
        component: () => import('@/views/tool/code/index'),
        meta: { title: '代码生成', icon: 'el-icon-s-promotion' }
      },
      {
        path: 'interface',
        name: 'Interface',
        component: () => import('@/views/tool/interface/index'),
        meta: { title: '系统接口', icon: 'el-icon-plus' }
      },
      {
        path: 'station',
        name: 'Station',
        component: () => import('@/views/tool/station/index'),
        meta: { title: '站点创建', icon: 'el-icon-s-platform' }
      }
    ]
  },
  {
    path: '/upload',
    component: Layout,
    redirect: '/upload/record',
    name: 'Upload',
    meta: {
      title: '设备保养内容上传',
      icon: 'el-icon-upload'
    },
    children: [
      {
        path: 'record',
        name: 'Record',
        component: () => import('@/views/equipment/record/index'),
        meta: { title: '设备履历', icon: 'el-icon-reading' }
      },
      {
        path: 'standard',
        name: 'Standard',
        component: () => import('@/views/equipment/standard/index'),
        meta: { title: '设备操作规范', icon: 'el-icon-coordinate' }
      },
      {
        path: 'maintenance',
        name: 'Maintenance',
        component: () => import('@/views/equipment/maintenance/index'),
        meta: { title: '设备保养计划', icon: 'el-icon-date' }
      },
    ]
  },
  {
    path: '/search',
    component: Layout,
    redirect: '/search',
    children: [
      {
        path: '/search',
        name: 'Search',
        component: () => import('@/views/equipment/search/index'),
        meta: {
          title: '查询',
          icon: 'el-icon-search'
        },
      }
    ]
  },
  {
    path: '/test',
    component: Layout,
    redirect: '/test',
    children: [
      {
        path: '/test',
        name: 'Test',
        component: () => import('@/views/test/index'),
        meta: {
          title: '测试',
          icon: 'el-icon-search'
        },
      }
    ]
  },

  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
