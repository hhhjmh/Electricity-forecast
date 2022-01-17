<!-- 电能分析APP-->
<template>
  <div>
    <!-- APP按钮 -->
    <div class="buttonBackground"id="btn_normal">
       <button type="text" @click="centerDialogVisible = true"></button>
       <p>电能分析</p>
    </div>
    <el-dialog title="电能分析" :visible.sync="centerDialogVisible" width="70%"
    :close-on-click-modal="false" :modal="false" center v-dialogDrag>
    <el-container>
        <el-aside id ='outaside'>
            <h2 style="color: white;text-align:center" >功能</h2>
            
            <router-link to="/day"><h2>日电能分析</h2></router-link>
            <router-link to="/month"><h2>月电能分析</h2></router-link>
            <router-link to="/year" ><h2>年电能分析</h2></router-link>
            
        </el-aside>
        
    
        <el-container>
        <el-aside id = 'inaside' width="240px">
            
            <el-row type="flex" class="row-bg" justify="space-between" >
                <el-button :class="{active:changeBackground1}" size="mini" @click="jcdclick()" >监测点</el-button>
                <el-button :class="{active:changeBackground2}" size="mini" @click="yddyclick()" >用电单元</el-button>
                <el-button :class="{active:changeBackground3}" size="mini" @click="jzwclick()" >建筑物</el-button>
            </el-row>
            <el-tree :style="msg1" :data="treedata1" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
            <el-tree :style="msg2" :data="treeData2" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
            <el-tree :style="msg3" :data="treeData3" :props="defaultProps" @node-click="handleNodeClick"></el-tree>

        </el-aside>

        <el-main id="day">
          
          <router-view></router-view>
          

        </el-main>
        </el-container>
    </el-container>
    </el-dialog>
    
  </div>
</template>
<style src="../assets/css/button.css">


</style>
<style lang="scss">
.tabBox{
  color: #ffffff;
  margin-top: 2rem;
  .el-tabs--left{
    height: auto !important;
    .el-tabs__item{
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
  /* 弹窗 */
#btn_Dialog{
    position: fixed;
    left: 15rem;
    top: 13rem;
    animation: flicker-in-1 1s linear both;
    animation-delay: 0.5s;
}
/* 弹窗侧边栏 */
#sidebar{
  width: 20rem;
  height: 50rem;
  animation: slide-left 0.5s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
  animation-delay: 1s;
}
/* 侧边栏动画 */

/* 弹窗按钮 */
 .buttonBackground button {
   
     background-image: url(../assets/icon/powerAnalyse.png);
  }
  .buttonBackground {
    left: 15rem;
    top: 16rem;
  }

#outaside {
  background-color: cornflowerblue;
  font-size :20px
}
#inaside{
  background-color:rgb(232, 245, 207);
}
.active {
  background: #2c5dff;
  color: #fff;
}
</style>
<script >
//传给DAY文件做表格标题头部使用
let toDaynodeData = {data:'电能管理体验馆'}
import axios from 'axios'
export default {
  data () {
    return {
      isRouterAlive:true,
      centerDialogVisible: false,
      activeName: 'first',
      treedata1:'',
      //初始显示监测点树形结构
      msg1:'',
      msg2:'display:none',
      msg3:'display:none',
      //初始默认监测点的按钮是被点击的
      changeBackground1:1,
      changeBackground2:0,
      changeBackground3:0,



      //用于记录点击的结点
      nodeData:'',
      
      //给{监察点}树形结构赋值
      // treeData1:[{
      //   label: '电能管理体验馆',
      //   children:[{
      //     label: '主变',
      //     children:[{
      //       label:'1#空调柜2'
      //     },{
      //       label:'3#动力柜'
      //     },{
      //       label:'水处理系统'
      //     },{
      //       label:'风机系统'
      //     },{
      //       label:'冷却水塔'
      //     },{
      //       label:'锅炉房'
      //     },{
      //       label:'空调用水泵'
      //     },{
      //       label:'2#冰水机'
      //     },{
      //       label:'高压空压机'
      //     },{
      //       label:'2#空调柜'
      //     },{
      //       label:'低压空压机'
      //     },{
      //       label:'1#冰水机'
      //     },{
      //       label:'传输系统'
      //     },{
      //       label:'1#动力柜',
      //       children:[{
      //         label:'1#插座电源'
      //         },{
      //         label:'2#插座电源'
      //       }]
      //     }]
      //   }],
      // }],
      //给{用电单元}树形结构赋值
      
      treeData2:[{
        label: '电能管理体验馆',
        children:[{
          label: '车间总',
          children:[{
            label: '产线2',
            children:[{
              label: '3#动力柜'
            },{
              label: '风机系统'
            }]

          }]
          },{
          label: '公共设施',
          children:[{
            label:'冰机',
            children:[{
              label: '1#空调柜2'
            },{
              label: '空调用水泵'
            },{
              label: '2#冰水机'
            },{
              label: '2#空调柜'
            },{
              label: '1#冰水机'
            }]
          },{
            label:'高压机',
            children:[{
              label:'高压空压机'
            },{
              label:'低压空压机'
            }]
          }]
          },{
          label: '变压器',
          children:[{
            label:'主变'
          }]
        }]
      }],
      //给{建筑物}树形结构赋值
      treeData3:[{
        label: '电能管理体验馆',
        children:[{
          label: '空调室',
          children:[{
            label: '1#空调柜2'
          },{
            label: '3#动力柜'
          },{
            label: '空调用水泵'
          },{
            label: '高压空压机'
          },{
            label: '2#空调柜'
          },{
            label: '低压空压机'
          }]
        },{
          label:'1#车间',
          children:[{
            label: '2#冰水机'
          },{
            label: '传输系统'
          },{
            label: '1#插座电源'
          }]
        }]
      }],

      defaultProps: {
        children: 'children',
        label: 'label'
      },
      
    }
    
    
  },


  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
    handleNodeClick(data) {
      
      this.nodeData = data.label,
      //toDaynodeData.data = data.label
      this.$set(toDaynodeData,"data",data.label)
      console.log(data.id);
    },

    
    jcdclick(){
      //{监察点}按钮显示树形结构并且让按钮改变颜色
      this.changeBackground1=1
      this.changeBackground2=0
      this.changeBackground3=0
      this.msg1=''
      this.msg2='display:none'
      this.msg3='display:none'
      
    },
    yddyclick(){
      //{用电单元}按钮显示树形结构并且让按钮改变颜色
      this.changeBackground1=0
      this.changeBackground2=1
      this.changeBackground3=0
      this.msg1='display:none'
      this.msg2=''
      this.msg3='display:none'
      
    },
    jzwclick(){
      //{建筑物}按钮显示树形结构并且让按钮改变颜色
      this.changeBackground1=0
      this.changeBackground2=0
      this.changeBackground3=1
      this.msg1='display:none'
      this.msg2='display:none'
      this.msg3=''
      
    },
    //请求数据监察点
    convert() {
      let _this = this;
      axios
        .post("http://114.213.210.219/util/deviceRelationshipTree", {
          type: 1
        })
        .then(response => {
          this.treedata1 = response.data
          console.log(response.data);
        })
        .catch(error => {
        console.log(error);
      });

      
    },
    
  },
  mounted(){
    this.convert()
    //toDaynodeData=this.nodeData
  }
  
}

export{
  toDaynodeData,
}


</script>
