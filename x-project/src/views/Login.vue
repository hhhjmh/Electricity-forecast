<!-- 登录页面 -->
<template>
  <!-- 屏幕 -->
  <div id="screen">
    <!-- 中间屏幕 -->
    <div id="screen_center">
      <router-link to='/home'><button>登录</button></router-link>
      <div id="screen_center_content">
        <p>智能能源综合服务平台</p>
        <input placeholder="账号" autofocus/>
        <input placeholder="密码"/>
      </div>
      <button>注册</button>
    </div>

    <!-- 右下角屏幕 -->
    <div id="screen_right_bottom"></div>

    <!-- 左下角屏幕 -->
    <div id="screen_left_bottom">
      <!-- 左右门 -->
      <div id="door">
        <!-- 左门 -->
        <div id="door_left">
          <img src="../assets/image/tiger_lock.png"/>
        </div>
        <!-- 太极图 -->
        <div id="taiChi">
          <div id="taiChi_round"></div>
          <img src="../assets/image/taiChi.gif" />
        </div>
        <!-- 右门 -->
        <div id="door_right">
          <img src="../assets/image/tiger_lock.png"/>
        </div>
      </div>
      <!-- 荧光楼梯 -->
      <div id="stair"></div>
    </div>
    <!-- 右上角屏幕 -->
    <div id="screen_right_top"></div>
    <!-- 左上角屏幕 -->
    <div id="screen_left_top"></div>

    <!-- 背景图片 -->
    <div id="login_back_img"></div>
    <!-- 粒子背景 -->
    <vue-particles
                color="#ffffff"
                :particleOpacity="0.7"
                :particlesNumber="50"
                shapeType="circle"
                :particleSize="6"
                linesColor="#ade6e6"
                :linesWidth="1"
                :lineLinked="true"
                :lineOpacity="0.6"
                :linesDistance="150"
                :moveSpeed="5"
                :hoverEffect="true"
                hoverMode="repulse"
                :clickEffect="true"
                clickMode="push">
    </vue-particles>
  </div>
</template>

<script>
</script>
<style src="../assets/css/login.css" scoped></style>

<style>

</style>
