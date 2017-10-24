import Vue from 'vue'
import App from './App'
import VueRouter from 'vue-router'
import routes from './router.js'

// 全局安装路由功能
Vue.use(VueRouter)

// 创建路由对象
const router = new VueRouter({
  mode: 'history',
  routes
})

window.app = new Vue({
  el: '#app',
  template: '<App/>',
  components: { App },
  router
})
