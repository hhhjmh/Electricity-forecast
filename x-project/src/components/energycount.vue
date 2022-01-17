<!-- 电能分析APP-->
<template>
  <div>
    <!-- APP按钮 -->
    <div class="buttonBackground" id="btn_normal">
      <button type="text" @click="centerDialogVisible = true"></button>
      <p>电量统计</p>
    </div>
    <el-dialog
      title="电量统计"
      :visible.sync="centerDialogVisible"
      width="70%"

      :close-on-click-modal="false"
      :modal="false"
      center
      v-dialogDrag
    >
      <el-container>
        <el-aside width="240px" id="outaside">
          <h2 style="color: white; text-align: center">功能</h2>

          <router-link to="/monitor"><h2>监测点电量统计</h2></router-link>
          <router-link to="/unit"><h2>用电单元电量统计</h2></router-link>
          
        </el-aside>
          <el-main id="day">
            <router-view></router-view>
          </el-main>
      </el-container>
            <!-- <el-container>
              <el-aside width="200px">Aside</el-aside>
              </el-container> -->
    </el-dialog>
  </div>
</template>
<style src="../assets/css/button.css">
</style>
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
<style scoped>
.el-aside {
    height: 1050px;
  }
/* 弹窗 */
#btn_Dialog {
  position: fixed;
  left: 15rem;
  top: 13rem;
  animation: flicker-in-1 1s linear both;
  animation-delay: 0.5s;
}
/* 弹窗侧边栏 */
#sidebar {
  width: 10rem;
  height: 50rem;
  animation: slide-left 0.5s cubic-bezier(0.25, 0.46, 0.45, 0.94) both;
  animation-delay: 1s;
}
/* 侧边栏动画 */

/* 弹窗按钮 */
.buttonBackground button {
  background-image: url(../assets/icon/energycount.png);
}
.buttonBackground {
  left: 15rem;
  top: 1rem;
}

#outaside {
  background-color: cornflowerblue;
  font-size: 20px;
}
#inaside {
  background-color: rgb(232, 245, 207);
}
.active {
  background: #2c5dff;
  color: #fff;
}
</style>
<script >
//传给DAY文件做表格标题头部使用
let toDaynodeData = { data: "电能管理体验馆" };
import axios from "axios";
export default {
  data() {
    return {
      isRouterAlive: true,
      centerDialogVisible: false,
      activeName: "first",

    };
  },

  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
    handleNodeClick(data) {
      (this.nodeData = data.label),
        //toDaynodeData.data = data.label
        this.$set(toDaynodeData, "data", data.label);
      console.log(data.id);
    },

    jcdclick() {
      //{监察点}按钮显示树形结构并且让按钮改变颜色
      this.changeBackground1 = 1;
      this.changeBackground2 = 0;
      this.changeBackground3 = 0;
      this.msg1 = "";
      this.msg2 = "display:none";
      this.msg3 = "display:none";
    },
    yddyclick() {
      //{用电单元}按钮显示树形结构并且让按钮改变颜色
      this.changeBackground1 = 0;
      this.changeBackground2 = 1;
      this.changeBackground3 = 0;
      this.msg1 = "display:none";
      this.msg2 = "";
      this.msg3 = "display:none";
    },
    jzwclick() {
      //{建筑物}按钮显示树形结构并且让按钮改变颜色
      this.changeBackground1 = 0;
      this.changeBackground2 = 0;
      this.changeBackground3 = 1;
      this.msg1 = "display:none";
      this.msg2 = "display:none";
      this.msg3 = "";
    },
    //请求数据监察点
    convert() {
      let _this = this;
      axios
        .post("http://114.213.210.219/util/deviceRelationshipTree", {
          type: 1,
        })
        .then((response) => {
          this.treedata1 = response.data;
          console.log(response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  mounted() {
    this.convert();
    //toDaynodeData=this.nodeData
  },
};

export { toDaynodeData };
</script>
