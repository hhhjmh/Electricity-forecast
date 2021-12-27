import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'; // 导入element-ui包
import 'element-ui/lib/theme-chalk/index.css'; // 导入相关样式
import './assets/js/dialog-drag.js'
import './assets/js/rem.js'
import './assets/sass/element-reset.scss' //element样式修改

Vue.use(ElementUI); // 引用
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
