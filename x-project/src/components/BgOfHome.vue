<!-- 主界面背景板 -->
<template>
  <div>
    <div class="bg"></div>
    <!-- 外层容器 -->
    <div id="container">
      <!-- 左侧容器 -->
      <div id="con_left">
        <div id="con_left_title"></div>
      </div>
      <!-- 中间容器 -->
      <div id="con_center">
        <div id="con_center_title"></div>
      </div>
      <!-- 右边容器 -->
      <div id="con_right">
        <div id="con_right_title"></div>
      </div>
    </div>
  </div>
</template>

<style>
  html, body {
    margin: 0;
    height: 100%;
    width: 100%;
    overflow: hidden;
  }
  #container{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
  }
  #con_left,#con_right,#con_center{
    margin-top: 1%;
    width: 25%;
    height: 70rem;
    border: 0.5rem double #d3cfff;
    background-color: rgba(139, 239, 240, 0.5);
  }
  #con_left_title,#con_right_title,#con_center_title{
    position: relative;
    border: 1rem ridge #ffffff;
    top: -1rem;
    background-color: rgba(141, 175, 177, 1.0);
  }
  #con_center_title{
    left: -1rem;
    width: 100%;
    height: 4rem;
    box-shadow: 0 -2.5rem 2rem -1rem rgba(90, 253, 255, 0.7),
    0 2rem 2rem -1rem rgba(255, 26, 26, 0.7);
    animation: con_center_title 1s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
  }
  #con_left_title{
    height: 70rem;
    width: 5rem;
    box-shadow: -2.5rem 0 2rem -0.5rem rgba(90, 253, 255, 0.7),
    2rem 0 2rem -1rem rgba(255, 26, 26, 0.7);
    animation: con_left_title 1s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
  }
  #con_right_title{
    height: 70rem;
    width: 5rem;
    left: 81.5%;
    box-shadow: -2rem 0 2rem -1rem rgba(255, 69, 69, 0.7),
    2.5rem 0 2rem -1rem rgba(94, 239, 255, 0.7);
    animation: con_right_title 1s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
  }
  @keyframes con_center_title {
    0% {
      top: -1rem;
    }
    50% {
      top: 90%;
    }
    100% {
      top: -1rem;
    }
  }
  @keyframes con_left_title {
    0% {
      left: 0;
    }
    50% {
      left: 90%;
    }
    100% {
      left: 0;
    }
  }
  @keyframes con_right_title {
    0% {
      left: 81.5%;
    }
    50% {
      left: 0;
    }
    100% {
      left: 81.5%;
    }
  }
  #left_app_container{
    width: 100%;
    display: flex;
    flex-direction: row;
    justify-content: center;
  }

  .bg{
    background-image:url('~@/assets/image/backImage.png');
    width:105%;
    height:105%;
    position:fixed;
    margin-left: -10px;
    margin-top: -10px;
    background-size:100% 100%;
    z-index: -2;
  }
</style>
