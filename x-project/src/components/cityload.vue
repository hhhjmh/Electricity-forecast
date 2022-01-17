<!-- 月报分析APP-->
<template>
  <div>
    <div>
      <!-- APP按钮 -->
      <div class="buttonBackground" id="btn_normal">
        <button type="text" @click="clickRect(1)"></button>
        <p>负荷分布</p>
      </div>
    </div>
    <!-- 动态渲染弹出框 -->

    <div
      v-for="devOne in devDialogs"
      :key="devOne.devCode"
      class="multi-dialog"
      :id="devOne.box"
      :style="{ left: devOne.left, top: devOne.top }"
    >
      <div class="multi-dialog-title" :id="devOne.title">
        <span>{{ devOne.devCode }}</span>
        <button
          type="button"
          aria-label="Close"
          class="el-dialog__headerbtn"
          @click="closeDialog(devOne)"
        >
          <i class="el-dialog__close el-icon el-icon-close"></i>
        </button>
      </div>
      <div class="multi-dialog-content">
        <!-- <bpg-kzmb></bpg-kzmb> -->
        假设此处有内容
      </div>
    </div>
  </div>
</template>
<style src="../assets/css/button.css">
</style>
<script>
export default {
  data() {
    return {
      devDialogs: [],
    };
  },
  methods: {
    // 点击设备按钮弹出弹框
    clickRect(val) {
      // 动态展示设备弹框
      let exist = false;
      this.devDialogs.forEach((element) => {
        if (val === element.devCode) {
          exist = true;
        }
      });
      if (!exist) {
        let devOne = {
          devCode: val,
          box: "box" + val,
          title: "title" + val,
          left: "20px",
          top: "20px",
        };
        this.devDialogs.push(devOne);
        this.$nextTick(() => {
          this.divMove(devOne.title, devOne.box);
        });
      }
    },
    // 关闭设备弹框
    closeDialog(devOne) {
      this.devDialogs.forEach(function (item, index, arr) {
        if (item.devCode === devOne.devCode) {
          arr.splice(index, 1);
        }
      });
    },
    // 移动设备弹框
    divMove(titleId, boxId) {
      let title = document.getElementById(titleId); // 获取点击元素（可选中拖动的部分）
      let box = document.getElementById(boxId); // 获取盒子元素（需要移动的整体）
      let divX = 0; // div的x坐标
      let divY = 0; // div的y坐标
      let isDrop = false; // 是否可拖动 按下鼠标置为true 松开鼠标置为false
      let self = this;
      // 将鼠标点击事件绑定在顶部title元素上
      title.onmousedown = function (e) {
        let el = e || window.event; // 获取鼠标位置
        divX = el.clientX - box.offsetLeft; // 鼠标相对盒子内部的坐标x
        divY = el.clientY - box.offsetTop; // 鼠标相对盒子顶部的坐标y
        isDrop = true; // 设为true表示可以移动
        document.onmousemove = function (e) {
          // 是否为可移动状态
          if (isDrop) {
            let el = e || window.event;
            let leftX = el.clientX - divX; // 盒子距窗口左边的距离
            let leftY = el.clientY - divY; // 盒子距窗口顶部的距离
            // 盒子不超出窗口的最大移动位置 即拖动置右下角时
            let maxX = document.documentElement.clientWidth - box.offsetWidth; // 窗口宽度-盒子宽度
            let maxY = document.documentElement.clientHeight - box.offsetHeight; // 窗口高度-盒子高度
            // 当移动到最左最上时，leftX < 0、leftY < 0，盒子左边距、上边距取最大值0
            // 当移动到最右最下时，leftX > maxX、leftY > maxY、已超出边界，盒子左边距、上边距取maxX、maxY
            leftX = Math.min(maxX, Math.max(0, leftX));
            leftY = Math.min(maxY, Math.max(0, leftY));
            box.style.left = leftX + "px";
            box.style.top = leftY + "px";
          }
        };
        document.onmouseup = function () {
          // 防止删除上一个div，下一个div挪位到上一个，需要在停止移动时给div赋位置
          self.devDialogs.forEach(function (item) {
            if (item.box === boxId) {
              item.left = box.style.left;
              item.top = box.style.top;
            }
          });
          isDrop = false;
          document.onmousemove = null;
          document.onmouseup = null;
        };
      };
    },
  },
};
</script>
<style scoped>
.just-click {
  cursor: pointer;
  width: 100px;
  height: 40px;
  position: fixed;
  background: white;
  color: black;
  line-height: 40px;
  text-align: center;
}
.multi-dialog {
  position: fixed;
  width: 580px;
  background: rgba(0, 93, 172, 0.75);
  box-shadow: 0px 0px 12px rgba(0, 186, 255, 0.5);
  top: 20px;
  left: 20px;
  z-index: 10;
  font-size: 14px;
}
.multi-dialog-title {
  padding: 20px;
  border: 1px solid rgba(0, 93, 172, 0.75);
  border-top: 2px solid rgba(127, 255, 255);
  cursor: move;
  font-size: 18px;
}
.multi-dialog-content {
  padding: 10px;
}
.buttonBackground button {
  background-image: url(../assets/icon/cityload.png);
}
.buttonBackground {
  left: 21rem;
  top: 8rem;
}
</style>

