<template>
  <div>
  <div class="block">
    <el-row>
      <span class="demonstration">月:</span>
       <!-- 日期选择器 -->
      <el-date-picker
      value-format="yyyy-MM"
      v-model="monthValue"
      type="month"
      placeholder="选择月">
    </el-date-picker>


    <span class="demonstration"> 曲线:</span>
    <!-- 图表内容 label不设置则等同于value的值-->
    <el-select @change="changeLine()" v-model="lineValue" placeholder="选择曲线">
      <el-option
      v-for="item in monthOptions"
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
    <el-checkbox-group @change="addLineMonth()" v-model="checkListMonth">
      <el-checkbox label="A相"></el-checkbox>
      <el-checkbox label="B相"></el-checkbox>
      <el-checkbox label="C相"></el-checkbox>
      <el-checkbox :style="isshowMonth0" label="总体"></el-checkbox>
      <el-checkbox :style="isshowMonth1" label="需量负荷"></el-checkbox>
      <el-checkbox :style="isshowMonth2" label="零线电流"></el-checkbox>
      <el-checkbox :style="isshowMonth3" label="Uab"></el-checkbox>
      <el-checkbox :style="isshowMonth3" label="Ubc"></el-checkbox>
      <el-checkbox :style="isshowMonth3" label="Uca"></el-checkbox>
    </el-checkbox-group>

    </el-row>
  </div>
  <div class="Chart">
    <h2 style="text-align: center">{{content.data}}-{{lineValue}}曲线({{monthValue}})</h2>
  </div>

  <div id="myChartMonth"
  :style="{ width: '1000px', height: '500px'}"
  ></div>
    

  <div>
    <el-row>
      <el-button :class="{activedMonth:changeBG[0]}" size="mini" @click="fhclick()" >负荷</el-button>
      <el-button :class="{activedMonth:changeBG[1]}" size="mini" @click="wgglclick()" >无功功率</el-button>
      <el-button :class="{activedMonth:changeBG[2]}" size="mini" @click="glysclick()" >功率因数</el-button>
      <el-button :class="{activedMonth:changeBG[3]}" size="mini" @click="dlclick()" >电流</el-button>
      <el-button :class="{activedMonth:changeBG[4]}" size="mini" @click="dyclick()" >电压</el-button>
      <el-button :class="{activedMonth:changeBG[5]}" size="mini" @click="dlxbclick()" >电流谐波</el-button>
      <el-button :class="{activedMonth:changeBG[6]}" size="mini" @click="dyxbclick()" >电压谐波</el-button>
      <el-button :class="{activedMonth:changeBG[7]}" size="mini" @click="dypcclick()" >电压偏差</el-button>
      <el-button :class="{activedMonth:changeBG[8]}" size="mini" @click="sxclick()" >三相不平衡</el-button>

    </el-row>
  </div>

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

      isshowMonth0:'',
      isshowMonth1:'display:none',
      isshowMonth2:'display:none',
      isshowMonth3:'display:none',

      content:toDaynodeData,
      //后端数据容器
      monthChartdata:[],
      monthChartdataMax:[],
      tableAvgDataMonth:[],
      tableMaxDataMonth:[],
      tableMinDataMonth:[],


      //时间参数
      monthValue:'',
      //曲线参数
      lineValue:'平均负荷',
      //曲线选择
      monthOptions: [{
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
      checkListMonth:['总体'],

      echartsOption:{
        legend: {	//图表上方的图例
          y:'bottom',
          data:['总体'],
          selected:{'A相':false, 'B相':false, 'C相':false, '总体':true,'需量负荷':false,'零线电流':false,'Uab':false,'Ubc':false,'Uca':false,}
        },
        // echarts选项，所有绘图数据和样式都在这里设置
        xAxis: {
          type: "category",
          data: [], // x轴数据
          name: "日期", // x轴名称
          nameTextStyle: {
            // x轴名称样式
            fontWeight: 1000,
            fontSize: 18,
          },
          //间隔显示
          axisLabel: {
            interval: 1
          },
        },

        yAxis: {
          type: "value",
          

          min:0,
          name: '平均负荷', // y轴名称
          nameTextStyle: {
            // y轴名称样式
            fontWeight: 1000,
            fontSize: 18,
          },
        },
        tooltip: {
          //鼠标放到图上的数据展示样式
          trigger: "axis",
        },
        series: [{
            //series中加入每个line的数据
            name: 'A相',
            data: [],
            type: 'line'
            
          },{
            name: 'B相',
            data: [],
            type: 'line'
          },{
            name: 'C相',
            data: [],
            type: 'line'
          },{
            name: '总体',
            data: [],
            type: 'line'
          },{
            name: '需量负荷',
            data: [],
            type: 'line'
          },{
            name: '零线电流',
            data: [],
            type: 'line'
          },{
            name: 'Uab',
            data: [],
            type: 'line'
          },{
            name: 'Ubc',
            data: [],
            type: 'line'
          },{
            name: 'Uca',
            data: [],
            type: 'line'
          }

        ],
      },


      //表格选择

      changeBG : [1,0,0,0,0,0,0,0,0],
      //表格赋值
      tableData: []
    }
  },
  


  created(){
    this.convert()
  },
  mounted() {
    let myChartMonth = echarts.init(document.getElementById("myChartMonth"), "light"); // 初始化echarts, theme为light
    myChartMonth.setOption(this.echartsOption);
// echarts设置选项s
    
  },


  methods:{

    
    addLineMonth(){
      this.echartsOption.legend.data=this.checkListMonth
      //判断某些元素是否存在，如果存在就做出时间
      if(this.checkListMonth.indexOf('A相')!=-1){
        this.echartsOption.legend.selected['A相'] = true
        
      }else{
        this.echartsOption.legend.selected['A相'] = false
      
      }

      if(this.checkListMonth.indexOf('B相')!=-1){
        this.echartsOption.legend.selected['B相'] = true
      }else{
        this.echartsOption.legend.selected['B相'] = false
        
      }

      if(this.checkListMonth.indexOf('C相')!=-1){

        this.echartsOption.legend.selected['C相'] = true
       
      }else{

        this.echartsOption.legend.selected['C相'] = false
       
      }
      if(this.checkListMonth.indexOf('总体')!=-1){
        this.echartsOption.legend.selected['总体'] = true 
      }else{
  
        this.echartsOption.legend.selected['总体'] = false
      }
      if(this.checkListMonth.indexOf('需量负荷')!=-1){
        this.echartsOption.legend.selected['需量负荷'] = true
      }else{
        this.echartsOption.legend.selected['需量负荷'] = false  
      }
      if(this.checkListMonth.indexOf('零线电流')!=-1){
        this.echartsOption.legend.selected['零线电流'] = true
      }else{
        this.echartsOption.legend.selected['零线电流'] = false
      }
      if(this.checkListMonth.indexOf('Uab')!=-1){
        this.echartsOption.legend.selected['Uab'] = true
      }else{
        this.echartsOption.legend.selected['Uab'] = false 
      }
      if(this.checkListMonth.indexOf('Ubc')!=-1){
        this.echartsOption.legend.selected['Ubc'] = true
      }else{
        this.echartsOption.legend.selected['Ubc'] = false
      }
      if(this.checkListMonth.indexOf('Uca')!=-1){
        this.echartsOption.legend.selected['Uca'] = true
      }else{
        this.echartsOption.legend.selected['Uca'] = false
      }

      let myChartMonth = echarts.init(document.getElementById("myChartMonth"), "light"); // 初始化echarts, theme为light
      myChartMonth.setOption(this.echartsOption);
    },

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
      this.checkListMonth=[]
      this.echartsOption.yAxis.min=0
      this.echartsOption.legend.data=[]
      this.echartsOption.legend.selected['A相']=false
      this.echartsOption.legend.selected['B相']=false
      this.echartsOption.legend.selected['C相']=false
      this.echartsOption.legend.selected['总体']=false
      this.echartsOption.legend.selected['需量负荷']=false
      this.echartsOption.legend.selected['零线电流']=false
      this.echartsOption.legend.selected['Uab']=false
      this.echartsOption.legend.selected['Ubc']=false
      this.echartsOption.legend.selected['Uca']=false

      
    },
    changeLine(){
      //this.convert()
      
      if(this.lineValue == '平均负荷'){//平均负荷变量赋值
        //选择框赋值
        this.cleanLine()
        
        this.isshowMonth0='',
        this.isshowMonth1='display:none',
        this.isshowMonth2='display:none',
        this.isshowMonth3='display:none',
        this.checkListMonth=['总体']
        this.echartsOption.legend.data=['总体']
        this.echartsOption.legend.selected['总体']=true
        this.echartsOption.yAxis.min=400

        this.echartsOption.yAxis.name = this.lineValue+'(kW)'

        let i=0
        while(i<this.monthChartdata.length){
          //时间戳变量转化成时间变量
          var date = new Date(this.monthChartdata[i].dataTime*1000 + 8 * 3600 * 1000);
          var daytime = date.toJSON().substr(0, 19).replace('T', ' ').replace(/-/g, '.')
           
          this.echartsOption.xAxis.data[i] = daytime.substring(8,10)//给X轴赋值
          this.echartsOption.series[0].data[i]=this.monthChartdata[i].aLoad//给A相负荷赋值
          this.echartsOption.series[1].data[i]=this.monthChartdata[i].bLoad//给B相负荷赋值
          this.echartsOption.series[2].data[i]=this.monthChartdata[i].cLoad//给C相负荷赋值
          this.echartsOption.series[3].data[i]=this.monthChartdata[i].totalLoad//给总体负荷赋值
          
          i=i+1
        }
        
      }
      else if(this.lineValue == '最大负荷'){//给最大电荷赋值
        //选择框赋值
        this.cleanLine()
        this.isshowMonth0='',
        this.isshowMonth1='display:none',
        this.isshowMonth2='display:none',
        this.isshowMonth3='display:none'
        this.echartsOption.yAxis.name = this.lineValue+'(kVar)'
        this.checkListMonth=['总体']
        this.echartsOption.legend.data=['总体']
        this.echartsOption.legend.selected['总体']=true
        this.echartsOption.yAxis.min=800


        let i=0
        while(i<this.monthChartdataMax.length){
          //时间戳变量转化成时间变量
          var date = new Date(this.monthChartdata[i].dataTime*1000 + 8 * 3600 * 1000);
          var daytime = date.toJSON().substr(0, 19).replace('T', ' ').replace(/-/g, '.')
           
          this.echartsOption.xAxis.data[i] = daytime.substring(8,10)//给X轴赋值
          this.echartsOption.series[0].data[i]=this.monthChartdataMax[i].aLoad//给A相负荷赋值
          this.echartsOption.series[1].data[i]=this.monthChartdataMax[i].bLoad//给B相负荷赋值
          this.echartsOption.series[2].data[i]=this.monthChartdataMax[i].cLoad//给C相负荷赋值
          this.echartsOption.series[3].data[i]=this.monthChartdataMax[i].totalLoad//给总体负荷赋值
          
          i=i+1
        }
      }
      else if(this.lineValue == '无功功率'){//给无功功率赋值
        //选择框赋值
        this.cleanLine()
        this.isshowMonth0='',
        this.isshowMonth1='display:none',
        this.isshowMonth2='display:none',
        this.isshowMonth3='display:none'
        this.echartsOption.yAxis.name = this.lineValue+'(kVar)'
        this.checkListMonth=['总体']
        this.echartsOption.legend.data=['总体']
        this.echartsOption.legend.selected['总体']=true
        this.echartsOption.yAxis.min=150
        

        let i=0
        while(i<this.monthChartdata.length){
          //时间戳变量转化成时间变量
          var date = new Date(this.monthChartdata[i].dataTime*1000 + 8 * 3600 * 1000);
          var daytime = date.toJSON().substr(0, 19).replace('T', ' ').replace(/-/g, '.')
           
          this.echartsOption.xAxis.data[i] = daytime.substring(10,16)//给X轴赋值
          this.echartsOption.series[0].data[i]=this.monthChartdata[i].aReactivePower//给A相无功功率赋值
          this.echartsOption.series[1].data[i]=this.monthChartdata[i].bReactivePower//给B相无功功率赋值
          this.echartsOption.series[2].data[i]=this.monthChartdata[i].cReactivePower//给C相无功功率赋值
          this.echartsOption.series[3].data[i]=this.monthChartdata[i].totalReactivePower//给总体无功功率赋值
          i=i+1
        }
      }
      else if(this.lineValue == '功率因数'){//给功率因数赋值
        //选择框赋值
        this.cleanLine()
        this.isshowMonth0='',
        this.isshowMonth1='display:none',
        this.isshowMonth2='display:none',
        this.isshowMonth3='display:none',
        this.checkListMonth=['总体']
        this.echartsOption.legend.data=['总体']
        this.echartsOption.legend.selected['总体']=true

        this.echartsOption.yAxis.min=0.8

        this.echartsOption.yAxis.name = this.lineValue

        let i=0
        while(i<this.monthChartdata.length){
          //时间戳变量转化成时间变量
          var date = new Date(this.monthChartdata[i].dataTime*1000 + 8 * 3600 * 1000);
          var daytime = date.toJSON().substr(0, 19).replace('T', ' ').replace(/-/g, '.')
           
          this.echartsOption.xAxis.data[i] = daytime.substring(10,16)//给X轴赋值
          this.echartsOption.series[0].data[i]=this.monthChartdata[i].aPowerFactor//给A相功率因数赋值
          this.echartsOption.series[1].data[i]=this.monthChartdata[i].bPowerFactor//给B相功率因数赋值
          this.echartsOption.series[2].data[i]=this.monthChartdata[i].cPowerFactor//给C相功率因数赋值
          this.echartsOption.series[3].data[i]=this.monthChartdata[i].totalPowerFactor//给总体功率因数赋值
          i=i+1
        }
      }
      else if(this.lineValue == '电流'){//给电流赋值
        //选择框赋值
        this.cleanLine()
        this.isshowMonth0='display:none',
        this.isshowMonth1='display:none',
        this.isshowMonth2='',
        this.isshowMonth3='display:none',

        this.echartsOption.yAxis.name = this.lineValue+'(A)'
        

        let i=0
        while(i<this.monthChartdata.length){
          
          //时间戳变量转化成时间变量
          var date = new Date(this.monthChartdata[i].dataTime*1000 + 8 * 3600 * 1000);
          var daytime = date.toJSON().substr(0, 19).replace('T', ' ').replace(/-/g, '.')
           
          this.echartsOption.xAxis.data[i] = daytime.substring(10,16)//给X轴赋值
          this.echartsOption.series[0].data[i]=this.monthChartdata[i].ia//给A相电流赋值
          this.echartsOption.series[1].data[i]=this.monthChartdata[i].ib//给B相电流赋值
          this.echartsOption.series[2].data[i]=this.monthChartdata[i].ic//给C相电流赋值
          this.echartsOption.series[5].data[i]=this.monthChartdata[i].zeroi//给零线赋值
          i=i+1
        }
      }

      else if(this.lineValue == '电压'){//给电压赋值
        //选择框赋值
        this.cleanLine()
        this.isshowMonth0='display:none',
        this.isshowMonth1='display:none',
        this.isshowMonth2='display:none',
        this.isshowMonth3='',

        this.echartsOption.yAxis.name = this.lineValue+'(V)'

        let i=0
        while(i<this.monthChartdata.length){
          
          //时间戳变量转化成时间变量
          var date = new Date(this.monthChartdata[i].dataTime*1000 + 8 * 3600 * 1000);
          var daytime = date.toJSON().substr(0, 19).replace('T', ' ').replace(/-/g, '.')
           
          this.echartsOption.xAxis.data[i] = daytime.substring(10,16)//给X轴赋值
          this.echartsOption.series[0].data[i]=this.monthChartdata[i].ua//给A相电压赋值
          this.echartsOption.series[1].data[i]=this.monthChartdata[i].ub//给B相电压赋值
          this.echartsOption.series[2].data[i]=this.monthChartdata[i].uc//给C相电压赋值
          this.echartsOption.series[6].data[i]=this.monthChartdata[i].uab//给Uab赋值
          this.echartsOption.series[7].data[i]=this.monthChartdata[i].ubc//给Ubc赋值
          this.echartsOption.series[8].data[i]=this.monthChartdata[i].uca//给Uca赋值
          
          i=i+1
        }
      }
      let myChartMonth = echarts.init(document.getElementById("myChartMonth"), "light"); // 初始化echarts, theme为light
      myChartMonth.setOption(this.echartsOption);

    },
    
     //由于大部分表格是四组数据，所以初始化的时候暂定为四组数据
    cleanTable(){
      this.tableData=[{
          message: '',
          average: '',
          maxValue: '',
          maxTime: '',
          minValue: '',
          minTime: ''
        },{
          message: '',
          average: '',
          maxValue: '',
          maxTime: '',
          minValue: '',
          minTime: ''
        },{
          message: '',
          average: '',
          maxValue: '',
          maxTime: '',
          minValue: '',
          minTime: ''
        },{
          message: '',
          average: '',
          maxValue: '',
          maxTime: '',
          minValue: '',
          minTime: ''
        }
      ]
    },


    fhclick(){
      this.changeBG = [1,0,0,0,0,0,0,0,0]
      this.cleanTable()

      this.tableData[0].message = '总负荷(kW)'
      this.tableData[1].message = 'A相负荷(kW)'
      this.tableData[2].message = 'B相负荷(kW)'
      this.tableData[3].message = 'C相负荷(kW)'

      this.tableData[0].average = this.tableAvgDataMonth.totalLoad
      this.tableData[1].average = this.tableAvgDataMonth.aLoad
      this.tableData[2].average = this.tableAvgDataMonth.bLoad
      this.tableData[3].average = this.tableAvgDataMonth.cLoad

      this.tableData[0].maxValue = this.tableMaxDataMonth.totalLoad
      this.tableData[1].maxValue = this.tableMaxDataMonth.aLoad
      this.tableData[2].maxValue = this.tableMaxDataMonth.bLoad
      this.tableData[3].maxValue = this.tableMaxDataMonth.cLoad

      this.tableData[0].minValue = this.tableMinDataMonth.totalLoad
      this.tableData[1].minValue = this.tableMinDataMonth.aLoad
      this.tableData[2].minValue = this.tableMinDataMonth.bLoad
      this.tableData[3].minValue = this.tableMinDataMonth.cLoad

      this.tableData[0].maxTime = this.changeTime(this.tableMaxDataMonth.totalLoadTime)
      this.tableData[1].maxTime = this.changeTime(this.tableMaxDataMonth.aLoadTime)
      this.tableData[2].maxTime = this.changeTime(this.tableMaxDataMonth.bLoadTime)
      this.tableData[3].maxTime = this.changeTime(this.tableMaxDataMonth.cLoadTime)

      this.tableData[0].minTime = this.changeTime(this.tableMinDataMonth.totalLoadTime)
      this.tableData[1].minTime = this.changeTime(this.tableMinDataMonth.aLoadTime)
      this.tableData[2].minTime = this.changeTime(this.tableMinDataMonth.bLoadTime)
      this.tableData[3].minTime = this.changeTime(this.tableMinDataMonth.cLoadTime)
    },
    wgglclick(){
      this.changeBG = [0,1,0,0,0,0,0,0,0]
      this.cleanTable()
      this.tableData[0].message = '总无功(kVar)'
      this.tableData[1].message = 'A相无功(kVar)'
      this.tableData[2].message = 'B相无功(kVar)'
      this.tableData[3].message = 'C相无功(kVar)'

      this.tableData[0].average = this.tableAvgDataMonth.totalReactivePower
      this.tableData[1].average = this.tableAvgDataMonth.aReactivePower
      this.tableData[2].average = this.tableAvgDataMonth.bReactivePower
      this.tableData[3].average = this.tableAvgDataMonth.cReactivePower

      this.tableData[0].maxValue = this.tableMaxDataMonth.totalReactivePower
      this.tableData[1].maxValue = this.tableMaxDataMonth.aReactivePower
      this.tableData[2].maxValue = this.tableMaxDataMonth.bReactivePower
      this.tableData[3].maxValue = this.tableMaxDataMonth.cReactivePower

      this.tableData[0].minValue = this.tableMinDataMonth.totalReactivePower
      this.tableData[1].minValue = this.tableMinDataMonth.aReactivePower
      this.tableData[2].minValue = this.tableMinDataMonth.bReactivePower
      this.tableData[3].minValue = this.tableMinDataMonth.cReactivePower

      this.tableData[0].maxTime = this.changeTime(this.tableMaxDataMonth.totalReactivePowerTime)
      this.tableData[1].maxTime = this.changeTime(this.tableMaxDataMonth.aReactivePowerTime)
      this.tableData[2].maxTime = this.changeTime(this.tableMaxDataMonth.bReactivePowerTime)
      this.tableData[3].maxTime = this.changeTime(this.tableMaxDataMonth.cReactivePowerTime)

      this.tableData[0].minTime = this.changeTime(this.tableMinDataMonth.totalReactivePowerTime)
      this.tableData[1].minTime = this.changeTime(this.tableMinDataMonth.aReactivePowerTime)
      this.tableData[2].minTime = this.changeTime(this.tableMinDataMonth.bReactivePowerTime)
      this.tableData[3].minTime = this.changeTime(this.tableMinDataMonth.cReactivePowerTime)
    },
    glysclick(){
      this.changeBG = [0,0,1,0,0,0,0,0,0]
      this.cleanTable()
      this.tableData[0].message = '总功率因数'
      this.tableData[1].message = 'A相功率因数'
      this.tableData[2].message = 'B相功率因数'
      this.tableData[3].message = 'C相功率因数'

      this.tableData[0].average = this.tableAvgDataMonth.totalPowerFactor
      this.tableData[1].average = this.tableAvgDataMonth.aPowerFactor
      this.tableData[2].average = this.tableAvgDataMonth.bPowerFactor
      this.tableData[3].average = this.tableAvgDataMonth.cPowerFactor

      this.tableData[0].maxValue = this.tableMaxDataMonth.totalPowerFactor
      this.tableData[1].maxValue = this.tableMaxDataMonth.aPowerFactor
      this.tableData[2].maxValue = this.tableMaxDataMonth.bPowerFactor
      this.tableData[3].maxValue = this.tableMaxDataMonth.cPowerFactor

      this.tableData[0].minValue = this.tableMinDataMonth.totalPowerFactor
      this.tableData[1].minValue = this.tableMinDataMonth.aPowerFactor
      this.tableData[2].minValue = this.tableMinDataMonth.bPowerFactor
      this.tableData[3].minValue = this.tableMinDataMonth.cPowerFactor

      this.tableData[0].maxTime = this.changeTime(this.tableMaxDataMonth.totalPowerFactorTime)
      this.tableData[1].maxTime = this.changeTime(this.tableMaxDataMonth.aPowerFactorTime)
      this.tableData[2].maxTime = this.changeTime(this.tableMaxDataMonth.bPowerFactorTime)
      this.tableData[3].maxTime = this.changeTime(this.tableMaxDataMonth.cPowerFactorTime)

      this.tableData[0].minTime = this.changeTime(this.tableMinDataMonth.totalPowerFactorTime)
      this.tableData[1].minTime = this.changeTime(this.tableMinDataMonth.aPowerFactorTime)
      this.tableData[2].minTime = this.changeTime(this.tableMinDataMonth.bPowerFactorTime)
      this.tableData[3].minTime = this.changeTime(this.tableMinDataMonth.cPowerFactorTime)
    },
    dlclick(){
      this.changeBG = [0,0,0,1,0,0,0,0,0]
      this.cleanTable()
      this.tableData[0].message = 'A相电流(A)'
      this.tableData[1].message = 'B相电流(A)'
      this.tableData[2].message = 'C相电流(A)'
      this.tableData[3].message = '零线电流(A)'

      this.tableData[0].average = this.tableAvgDataMonth.ia
      this.tableData[1].average = this.tableAvgDataMonth.ib
      this.tableData[2].average = this.tableAvgDataMonth.ic
      this.tableData[3].average = this.tableAvgDataMonth.zeroi

      this.tableData[0].maxValue = this.tableMaxDataMonth.ia
      this.tableData[1].maxValue = this.tableMaxDataMonth.ib
      this.tableData[2].maxValue = this.tableMaxDataMonth.ic
      this.tableData[3].maxValue = this.tableMaxDataMonth.zeroi

      this.tableData[0].minValue = this.tableMinDataMonth.ia
      this.tableData[1].minValue = this.tableMinDataMonth.ib
      this.tableData[2].minValue = this.tableMinDataMonth.ic
      this.tableData[3].minValue = this.tableMinDataMonth.zeroi

      this.tableData[0].maxTime = this.changeTime(this.tableMaxDataMonth.iaTime)
      this.tableData[1].maxTime = this.changeTime(this.tableMaxDataMonth.ibTime)
      this.tableData[2].maxTime = this.changeTime(this.tableMaxDataMonth.icTime)
      this.tableData[3].maxTime = this.changeTime(this.tableMaxDataMonth.zeroiTime)

      this.tableData[0].minTime = this.changeTime(this.tableMinDataMonth.iaTime)
      this.tableData[1].minTime = this.changeTime(this.tableMinDataMonth.ibTime)
      this.tableData[2].minTime = this.changeTime(this.tableMinDataMonth.icTime)
      this.tableData[3].minTime = this.changeTime(this.tableMinDataMonth.zeroiTime)
    },
    dyclick(){
      this.changeBG = [0,0,0,0,1,0,0,0,0]
      //由于电压页面有6个所以需要重新定义表格
      this.tableData=[{
          message: '',
          average: '',
          maxValue: '',
          maxTime: '',
          minValue: '',
          minTime: ''
        },{
          message: '',
          average: '',
          maxValue: '',
          maxTime: '',
          minValue: '',
          minTime: ''
        },{
          message: '',
          average: '',
          maxValue: '',
          maxTime: '',
          minValue: '',
          minTime: ''
        },{
          message: '',
          average: '',
          maxValue: '',
          maxTime: '',
          minValue: '',
          minTime: ''
        },{
          message: '',
          average: '',
          maxValue: '',
          maxTime: '',
          minValue: '',
          minTime: ''
        },{
          message: '',
          average: '',
          maxValue: '',
          maxTime: '',
          minValue: '',
          minTime: ''
        }
      ]

      this.tableData[0].message = 'A相电压(V)'
      this.tableData[1].message = 'B相电压(V)'
      this.tableData[2].message = 'C相电压(V)'
      this.tableData[3].message = 'Uab线电压(V)'
      this.tableData[4].message = 'Ubc线电压(V)'
      this.tableData[5].message = 'Uca线电压(V)'


      this.tableData[0].average = this.tableAvgDataMonth.ua
      this.tableData[1].average = this.tableAvgDataMonth.ub
      this.tableData[2].average = this.tableAvgDataMonth.uc
      this.tableData[3].average = this.tableAvgDataMonth.uab
      this.tableData[4].average = this.tableAvgDataMonth.ubc
      this.tableData[5].average = this.tableAvgDataMonth.uca

      this.tableData[0].maxValue = this.tableMaxDataMonth.ua
      this.tableData[1].maxValue = this.tableMaxDataMonth.ub
      this.tableData[2].maxValue = this.tableMaxDataMonth.uc
      this.tableData[3].maxValue = this.tableMaxDataMonth.uab
      this.tableData[4].maxValue = this.tableMaxDataMonth.ubc
      this.tableData[5].maxValue = this.tableMaxDataMonth.uca
       
      this.tableData[0].minValue = this.tableMinDataMonth.ua
      this.tableData[1].minValue = this.tableMinDataMonth.ub
      this.tableData[2].minValue = this.tableMinDataMonth.uc
      this.tableData[3].minValue = this.tableMinDataMonth.uab
      this.tableData[4].minValue = this.tableMinDataMonth.ubc
      this.tableData[5].minValue = this.tableMinDataMonth.uca

      this.tableData[0].maxTime = this.changeTime(this.tableMaxDataMonth.uaTime)
      this.tableData[1].maxTime = this.changeTime(this.tableMaxDataMonth.ubTime)
      this.tableData[2].maxTime = this.changeTime(this.tableMaxDataMonth.ucTime)
      this.tableData[3].maxTime = this.changeTime(this.tableMaxDataMonth.uabTime)
      this.tableData[4].maxTime = this.changeTime(this.tableMaxDataMonth.ubcTime)
      this.tableData[5].maxTime = this.changeTime(this.tableMaxDataMonth.ucaTime)

      this.tableData[0].minTime = this.changeTime(this.tableMinDataMonth.uaTime)
      this.tableData[1].minTime = this.changeTime(this.tableMinDataMonth.ubTime)
      this.tableData[2].minTime = this.changeTime(this.tableMinDataMonth.ucTime)
      this.tableData[3].minTime = this.changeTime(this.tableMinDataMonth.uabTime)
      this.tableData[4].minTime = this.changeTime(this.tableMinDataMonth.ubcTime)
      this.tableData[5].minTime = this.changeTime(this.tableMinDataMonth.ucaTime)

    },
    dlxbclick(){
      this.changeBG = [0,0,0,0,0,1,0,0,0]
    },
    dyxbclick(){
      this.changeBG = [0,0,0,0,0,0,1,0,0]
    },
    dypcclick(){
      this.changeBG = [0,0,0,0,0,0,0,1,0]
    },
    sxclick(){
      this.changeBG = [0,0,0,0,0,0,0,0,1]
    },

    convert(){
      //请求图表数据
      axios
      .post("http://114.213.211.241/PowerAnalyse/findPowerAnalyseDayAvgByDataTime", {
	      deviceId:"1",
	      dataTime:"1638288000"
      })
      .then(response => {
        this.monthChartdata = response.data
        console.log(this.monthChartdata.length)
        console.log(this.changeTime(1638288000))
        console.log(this.monthChartdata[0]);
        this.changeLine()
        
      })
      .catch(error => {
        console.log(error);
      });

      axios
      .post("http://114.213.211.241/PowerAnalyse/findPowerAnalyseDayMaxByDataTime", {
	      deviceId:"1",
	      dataTime:"1638288000"
      })
      .then(response => {
        this.monthChartdataMax = response.data
        console.log(this.monthChartdataMax.length)
        console.log(this.changeTime(1638288000))
        console.log(this.monthChartdataMax);
        
      })
      .catch(error => {
        console.log(error);
      });

      //请求表格数据
      axios
      .post("http://114.213.211.241/PowerAnalyse/DayAvg", {
	      deviceId: "1",
        dataTime: "1638288000"
      })
      .then(response => {
        this.tableAvgDataMonth = response.data
        console.log(this.tableAvgDataMonth)
        this.fhclick()
      })
      .catch(error => {
        console.log(error);
      });

      axios
      .post("http://114.213.211.241/PowerAnalyse/DayMax", {
	      deviceId: "1",
        dataTime: "1638288000"
      })
      .then(response => {
        this.tableMaxDataMonth = response.data
        console.log(this.tableMaxDataMonth)
        this.fhclick()
      })
      .catch(error => {
        console.log(error);
      });

      axios
      .post("http://114.213.211.241/PowerAnalyse/DayMin", {
	      deviceId: "1",
        dataTime: "1638288000"
      })
      .then(response => {
        this.tableMinDataMonth = response.data
        console.log(this.tableMinDataMonth)
        this.fhclick()
      })
      .catch(error => {
        console.log(error);
      });
    },



  }
};
</script>

<style scoped>
#myChartMonth {
  width: 100%;
  height: 500px;
  margin: 0 auto;
  margin-top: 5%;
}

.activedMonth {
  background: #2c5dff;
  color: #fff;
}
</style>