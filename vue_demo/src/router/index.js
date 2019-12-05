/**
 * vue路由控制
 */
// 1、引入路由插件包
import Vue from 'vue'
import VueRouter from 'vue-router'
/**
 * 1. 定义 (路由) 组件
 * 可以从其他文件 import 进来
 */

import Home from "../components/Home/Home";
import Login from "../components/Login/Login";
import Error from "../components/Error/Error";

// 加载路由插件
Vue.use(VueRouter)

/**
 * 2. 定义路由
 * 每个路由应该映射一个组件。
 */
const routes = [
  {
    path: '/', components: {
      main: Login
    }
  },
  {
    path: '/home', components: {
      main: Home
    }
  },
  {
    path: '/error', components: {
      main: Error
    }
  }
]

const router = new VueRouter({
  routes
})

/**
 * 3. 配置路由过滤
 */
/* 路由全局前置守卫 */
router.beforeEach((to, from, next) => {
  if(to.path === '/' || window.localStorage['access-token'] != undefined) {
    next()
  } else {
    next('/')
  }
})

/**
 * 4. 向外暴露路由配置
 */
export default router
