<!-- 跳转登录页面 -->
<template>
    <div id="electric_tower">
      <!-- 电缆 -->
      <div id="cable_top"></div>
      <!-- 电塔图片 -->
      <img src="../assets/image/powerTower.png" >
      <div id="cable_bottom"></div>
      <button id="goto_login" @click="toLoginPage()">进入</button>
    </div>
</template>

<script>
  export default {
    methods:{
      toLoginPage(){
        this.$router.push('/login')
      }
    }
  }

</script>

<style>
  html{
    font-size: 62.5%;
  }
  /* 换算：1rem——10px */
  /* 电塔 */
  #electric_tower{
    margin-top: 20rem;
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  #electric_tower img{
    border: 0.15rem solid white;
    border-radius: 0.5rem;
    width:20rem;
    height:30rem;
  }
  /* 按钮 */
  #goto_login{
    font-family: "新宋体";
    font-size: 2rem;
    font-weight: bold;
    border-radius: 1rem;
    width: 14rem;
    height: 6rem;
    margin-top: 2rem;
    color: lightblue;
    background-color: transparent;
    border: 0.3rem solid skyblue;
  }
  #goto_login:hover{
    transform: translateY(-0.3rem );
    color: #ffffff;
    background-image: linear-gradient(30deg, #def6f0 0%, #98d1fd 51%, #436df6 100%);
    box-shadow: 1rem 1rem 10rem 0.6rem rgba(135, 231, 231, 1.0);
  }
  #cable_top{
    position: absolute;
    top: 20%;
    background-color: white;
    width: 0;
    height: 0.2rem;
    animation: cable_aniamtion 2s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
  }
  #cable_bottom{
    position: absolute;
    bottom: 20%;
    background-color: white;
    width: 0;
    height: 0.2rem;
    animation: cable_aniamtion 2s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
  }
  /*电缆 动画 */
  @keyframes cable_aniamtion{
    0% {
      width: 0;
      opacity: 0;
      height: 5rem;
      background-color: #00f3ff;
    }
    100% {
      width: 100%;
      opacity: 1;
      height: 0.2rem;
      background-color: #ffffff;
    }
  }
  /* 黑色背景 */
  body{
    background-color: #060d19;
  }
  /* 链接去除下划线 */
  a {
    text-decoration: none;
  }
</style>
