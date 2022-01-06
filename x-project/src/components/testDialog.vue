<!-- 电能在线APP-->
<template>
  <div>
    <!-- APP按钮 -->
    <div id="btn_Dialog">
      <button type="text" @click="centerDialogVisible = true"></button>
      <p>电能在线</p>
    </div>
    <el-dialog
      title="电能在线"
      :visible.sync="centerDialogVisible"
      width="70%"
      :close-on-click-modal="false"
      :modal="false"
      center
      v-dialogDrag
    >
      <!-- 侧边栏 -->
      <div id="sidebar">
        <!-- 主侧边栏 -->
        <div id="main_sidebar">
          <div class="tabBox">
            <el-tabs
              v-model="activeName"
              @tab-click="handleClick"
              tab-position="left"
            >
              <el-tab-pane label="用户管理" name="first">用户管理</el-tab-pane>
              <el-tab-pane label="配置管理" name="second">配置管理</el-tab-pane>
              <el-tab-pane label="角色管理" name="third">角色管理</el-tab-pane>
              <el-tab-pane label="定时任务补偿" name="fourth"
                >定时任务补偿</el-tab-pane
              >
            </el-tabs>
          </div>
        </div>
        <!-- 子侧边栏 -->
        <div id="child_sidebar"></div>
      </div>
    </el-dialog>
  </div>
</template>
<style lang="scss">
.tabBox {
  color: #ffffff;
  margin-top: 2rem;
  .el-tabs--left {
    height: auto !important;
    .el-tabs__item {
      font-size: 1.5rem;
      color: #ffffff;
      width: 8rem;
      line-height: 24px;
      height: auto;
      white-space: pre-line;
      margin-bottom: 5rem;
    }
  }
}
</style>
<style>
/* 弹窗 */
#btn_Dialog {
  position: fixed;
  left: 15rem;
  top: 3rem;
  animation: flicker-in-1 1s linear both;
  animation-delay: 0.5s;
}
/* 弹窗侧边栏 */
#sidebar {
  width: 20rem;
  height: 50rem;
  animation: slide-left 0.5s cubic-bezier(0.25, 0.46, 0.45, 0.94) both;
  animation-delay: 1s;
}
/* 侧边栏动画 */
@keyframes slide-left {
  0% {
    -webkit-transform: translateX(0);
    transform: translateX(0);
  }
  100% {
    -webkit-transform: translateX(-18rem);
    transform: translateX(-18rem);
  }
}
/* 主侧边栏 */
#main_sidebar {
  width: 20rem;
  height: 49rem;
  background-color: #3660d3;
  border: 0.5rem double #70bec6;
  box-shadow: 1.5rem 0 2rem -1rem rgba(43, 82, 255, 1);
}

/* 子侧边栏 */
#child_sidebar {
  position: absolute;
  z-index: -1;
  left: 0;
  top: 0;
  width: 15rem;
  height: 49rem;
  border: 0.5rem double #3660d3;
  border-left: transparent;
  animation: slide-right 0.5s cubic-bezier(0.25, 0.46, 0.45, 0.94) both;
  animation-delay: 1.5s;
}
@keyframes slide-right {
  0% {
    -webkit-transform: translateX(0);
    transform: translateX(0);
    background-color: #3660d3;
  }
  100% {
    -webkit-transform: translateX(20.5rem);
    transform: translateX(20.5rem);
    box-shadow: 1.5rem 0 2rem -1rem rgba(76, 143, 143, 1);
    background-color: #72d3c8;
  }
}
/* 弹窗按钮 */
#btn_bao {
  position: fixed;
  left: 120rem;
  top: 13rem;
  animation: flicker-in-1 1s linear both;
  animation-delay: 0.5s;
}
#btn_Dialog button {
  margin: 0.5rem;
  border-radius: 1.5rem;
  border: 0.5rem double #80ffea;
  width: 6rem;
  height: 6rem;
  background-image: url(../assets/icon/one.png);
  background-size: 100% 100%;
  color: #ffffff;
}
#btn_Dialog p {
  margin: 0.5rem;
  color: #ffffff;
  font-weight: bold;
  font-size: 1.5rem;
  margin-top: 0;
  text-shadow: 0 0 30px rgba(255, 255, 255, 0.25);
}
/* 按钮动画  */
@keyframes flicker-in-1 {
  0% {
    opacity: 0;
  }
  10% {
    opacity: 0;
  }
  10.1% {
    opacity: 1;
  }
  10.2% {
    opacity: 0;
  }
  20% {
    opacity: 0;
  }
  20.1% {
    opacity: 1;
  }
  20.6% {
    opacity: 0;
  }
  30% {
    opacity: 0;
  }
  30.1% {
    opacity: 1;
  }
  30.5% {
    opacity: 1;
  }
  30.6% {
    opacity: 0;
  }
  45% {
    opacity: 0;
  }
  45.1% {
    opacity: 1;
  }
  50% {
    opacity: 1;
  }
  55% {
    opacity: 1;
  }
  55.1% {
    opacity: 0;
  }
  57% {
    opacity: 0;
  }
  57.1% {
    opacity: 1;
  }
  60% {
    opacity: 1;
  }
  60.1% {
    opacity: 0;
  }
  65% {
    opacity: 0;
  }
  65.1% {
    opacity: 1;
  }
  75% {
    opacity: 1;
  }
  75.1% {
    opacity: 0;
  }
  77% {
    opacity: 0;
  }
  77.1% {
    opacity: 1;
  }
  85% {
    opacity: 1;
  }
  85.1% {
    opacity: 0;
  }
  86% {
    opacity: 0;
  }
  86.1% {
    opacity: 1;
  }
  100% {
    opacity: 1;
  }
}
#btn_Dialog:hover {
  border-radius: 1rem;
  border: 0.1rem solid rgba(220, 220, 220, 0.5);
  background-color: #71a3b0;
  box-shadow: 0 0 40px 0px rgba(255, 255, 255, 0.8);
}
</style>
<script >
export default {
  data() {
    return {
      centerDialogVisible: false,
      activeName: "first",
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
  },
};
</script>
