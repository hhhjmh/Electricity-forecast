import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'JumpToLogin',
    component: () => import('../views/JumpToLogin.vue')
  },
  {
    path: '/about',
    name: 'About',
    component: () => import('../views/About.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/home',
    name: 'Home',
    component: () => import('../views/Home.vue'),
    children:[ 
    {
      path: '/day',
      component:()=>import('../components/DAY')
    },
    {
      path: '/month',
      component: ()=>import('../components/MONTH.vue')
    },
    {
      path: '/year',
      component: ()=>import('../components/YEAR.vue')
    },]
  },
  {
    path: '/test',
    name: 'Test',
    component: () => import('../components/testDialog.vue')
  },
  {
    path: '/bghome',
    name: 'BgOfHome',
    component: () => import('../components/BgOfHome.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
