<template>
  <div>
  <div class="block">
    <el-row>
      <span class="demonstration">年</span>
    <el-date-picker
      value-format="yyyy"
      v-model="yearValue"
      type="year"
      placeholder="选择年">
    </el-date-picker>


    <span class="demonstration"> 曲线:</span>
    <!-- 图表内容 label不设置则等同于value的值-->
    <el-select @change="changeLine()" v-model="lineValue" placeholder="选择曲线">
      <el-option
      v-for="item in yearOptions"
      :key="item.value"
      :value="item.value">
      </el-option>

    </el-select>


    <!-- 导出功能 -->
    <el-dropdown  @command="handleCommand">
      <el-button type="primary">
        导出<i class="el-icon-arrow-down el-icon--right"></i>
      </el-button>
      <el-dropdown-menu slot="dropdown">
      <el-dropdown-item v-print="'#monthChart'">打印图表</el-dropdown-item>
      <el-dropdown-item command ="a">导出PDF格式</el-dropdown-item>
      <el-dropdown-item>导出JPEG格式</el-dropdown-item>
      <el-dropdown-item>导出PNG格式</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>

    <!-- 选择显示线段 -->
    <el-checkbox-group @change="addLineMonth()" v-model="checkListYear">
      <el-checkbox label="A相"></el-checkbox>
      <el-checkbox label="B相"></el-checkbox>
      <el-checkbox label="C相"></el-checkbox>
      <el-checkbox :style="isshowYear0" label="总体"></el-checkbox>
      <el-checkbox :style="isshowYear1" label="需量负荷"></el-checkbox>
      <el-checkbox :style="isshowYear2" label="零线电流"></el-checkbox>
      <el-checkbox :style="isshowYear3" label="Uab"></el-checkbox>
      <el-checkbox :style="isshowYear3" label="Ubc"></el-checkbox>
      <el-checkbox :style="isshowYear3" label="Uca"></el-checkbox>
    </el-checkbox-group>

    </el-row>
  </div>
  <div class="Chart">
    <h2 style="text-align: center">{{content.data}}-{{lineValue}}曲线({{yearValue}})</h2>
  </div>

  <div id="myChartYear"
  :style="{ width: '1000px', height: '500px'}"
  ></div>
    

  <div>
    <el-table :data="tableData"  style="width: 1150px">
      <el-table-column prop="message" label="信息" width="150"></el-table-column>
      <el-table-column prop="average" label="平均值" width="200"></el-table-column>
      <el-table-column label="最大值" width="400">
        <el-table-column prop="maxValue" label="值" width="150"></el-table-column>
        <el-table-column prop="maxTime" label="时间" width="250"></el-table-column>
      </el-table-column>
      <el-table-column label="最小值" width="400">
        <el-table-column prop="minValue" label="值" width="150"></el-table-column>
        <el-table-column prop="minTime" label="时间" width="250"></el-table-column>
      </el-table-column>

    </el-table>
  </div>




  </div>
</template>


<script>

const echarts = require("echarts");
import {toDaynodeData} from'@/components/ElectricEnergyAnalysis.vue';
import axios from 'axios'

export default {
  name: 'Chart',
  data(){
    return{
      isshowYear0:'',
      isshowYear1:'display:none',
      isshowYear2:'display:none',
      isshowYear3:'display:none',
      
      content:toDaynodeData,
      //后端数据容器
      yearChartdata:[],

      //时间参数
      yearValue:'',
      //曲线参数
      lineValue:'平均负荷',
      //曲线选择
      yearOptions: [{
        value: '平均负荷',
      }, {
        value: '最大负荷',
      },{
        value: '无功功率',
      }, {
        value: '功率因数',
      }, {
        value: '电流',
      }, {
        value: '电压',
      }, {
        value: '温度',
      }, {
        value: '电流谐波畸变率',
      }, {
        value: '电压谐波畸变率',
      }, {
        value: '频率偏差',   
      }, {
        value: '电压偏差',   
      }, {
        value: '三相不平衡度',   
      }],
      checkListYear:['总体'],

      echartsOption:{
        legend: {
          data: ['总体']
        },
        xAxis:{
          type: 'category',
          data: ['腾讯', '阿里巴巴', '华为', '字节跳动'],   // x轴数据
          name: '年份',   // x轴名称
          nameTextStyle: {	// x轴名称样式
            fontWeight: 600,
            fontSize: 18
          }
        },
        yAxis:{
          type:'value',
            
          name: '电荷',   // x轴名称
          nameTextStyle: {	// x轴名称样式
            fontWeight: 600,
            fontSize: 18
          }
        },
        tooltip: {
          //鼠标放到图上的数据展示样式
          trigger: "axis",
        },
        series: [{
            //series中加入每个line的数据
            name: 'A相',
            data: [],
            type: 'bar'
            
          },{
            name: 'B相',
            data: [],
            type: 'bar'
          },{
            name: 'C相',
            data: [],
            type: 'bar'
          },{
            name: '总体',
            data: [],
            type: 'bar'
          },{
            name: '需量负荷',
            data: [],
            type: 'bar'
          },{
            name: '零线电流',
            data: [],
            type: 'bar'
          },{
            name: 'Uab',
            data: [],
            type: 'bar'
          },{
            name: 'Ubc',
            data: [],
            type: 'bar'
          },{
            name: 'Uca',
            data: [],
            type: 'bar'
          }

        ],

      },

      tableData: []
    }
  },
  


  created(){
    this.convert()
  },
  mounted() {
    
    let myChartYear = echarts.init(document.getElementById("myChartYear"), "light"); // 初始化echarts, theme为light
    myChartYear.setOption(this.echartsOption);
// echarts设置选项s
    
  },


  methods:{


    handleCommand(command) {
      if(command=="a"){        
        this.getPdf()
      }
    },
    //时间转化函数
    changeTime(A){
      var date = new Date(A*1000 + 8 * 3600 * 1000);
      var B = date.toJSON().substr(0, 19).replace('T', ' ').replace(/-/g, '.')
      return B
    },

    cleanLine(){
      // let i=0
      // for(i=0;i<9;i++){
      //   this.echartsOption.legend.data[i] = ''
      // }
      this.checkListYear=[]

      
    },
    changeLine(){
      //this.convert()
      
      if(this.lineValue == '负荷'){//负荷变量赋值
        //选择框赋值
        this.cleanLine()
        
        this.isshowYear0='',
        this.isshowYear1='display:none',
        this.isshowYear2='display:none',
        this.isshowYear3='display:none',


        this.echartsOption.yAxis.name = this.lineValue+'(kW)'

      }
      else if(this.lineValue == '无功功率'){//给无功功率赋值
        //选择框赋值
        this.cleanLine()
        this.isshowYear0='',
        this.isshowYear1='display:none',
        this.isshowYear2='display:none',
        this.isshowYear3='display:none'
        this.echartsOption.yAxis.name = this.lineValue+'(kVar)'
       
      }
      else if(this.lineValue == '功率因数'){//给功率因数赋值
        //选择框赋值
        this.cleanLine()
        this.isshowYear0='',
        this.isshowYear1='display:none',
        this.isshowYear2='display:none',
        this.isshowYear3='display:none',


        this.echartsOption.yAxis.name = this.lineValue
      }
      else if(this.lineValue == '电流'){//给电流赋值
        //选择框赋值
        this.cleanLine()
        this.isshowYear0='display:none',
        this.isshowYear1='display:none',
        this.isshowYear2='',
        this.isshowYear3='display:none',

        this.echartsOption.yAxis.name = this.lineValue+'(A)'
      }

      else if(this.lineValue == '电压'){//给电压赋值
        //选择框赋值
        this.cleanLine()
        this.isshowYear0='display:none',
        this.isshowYear1='display:none',
        this.isshowYear2='display:none',
        this.isshowYear3='',

        this.echartsOption.yAxis.name = this.lineValue+'(V)'
      }
      let myChartYear = echarts.init(document.getElementById("myChartYear"), "light"); // 初始化echarts, theme为light
      myChartYear.setOption(this.echartsOption);

    },
    convert(){
      //请求图表数据
      axios
      .post("http://114.213.210.219/powerRealtime/findPowerRealtimeByDataTime", {
	      deviceId:"1",
	      dataTime:"1640534400"
      })
      .then(response => {
        this.yearChartdata = response.data
        //console.log(this.totaldata.length)
        console.log(this.changeTime(1640679300))
        console.log(this.yearChartdata);
        this.changeLine()
      })
      .catch(error => {
        console.log(error);
      });
    },



  }
};
</script>

<style scoped>
#myChartYear {
  width: 100%;
  height: 500px;
  margin: 0 auto;
  margin-top: 5%;
}
</style>