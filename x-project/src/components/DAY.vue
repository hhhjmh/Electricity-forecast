<template>
  <div>
  <div class="block">
    
    <el-row>
      
      <span class="demonstration">时间:</span>
      <!-- 日期选择器 -->
      <el-date-picker
        value-format="yyyy-MM-dd"
        v-model="value1"
        type="date"
        placeholder="选择日期">
      </el-date-picker>
     
      
      <span class="demonstration"> 曲线:</span>
      <!-- 图表内容 label不设置则等同于value的值-->
      <el-select @change="changeLine()" v-model="value2" placeholder="选择曲线">
        <el-option
        v-for="item in options"
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
        <el-dropdown-item v-print="'#myChart'">打印图表</el-dropdown-item>
        <el-dropdown-item command ="a">导出PDF格式</el-dropdown-item>
        <el-dropdown-item>导出JPEG格式</el-dropdown-item>
        <el-dropdown-item>导出PNG格式</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      
      <!-- 选择显示线段 -->
      <el-checkbox-group @change="addLine()" v-model="checkList">
        <el-checkbox label="A相"></el-checkbox>
        <el-checkbox label="B相"></el-checkbox>
        <el-checkbox label="C相"></el-checkbox>
        <el-checkbox :style="isshow0" label="总体"></el-checkbox>
        <el-checkbox :style="isshow1" label="需量负荷"></el-checkbox>
        <el-checkbox :style="isshow2" label="零线电流"></el-checkbox>
        <el-checkbox :style="isshow3" label="Uab"></el-checkbox>
        <el-checkbox :style="isshow3" label="Ubc"></el-checkbox>
        <el-checkbox :style="isshow3" label="Uca"></el-checkbox>
      </el-checkbox-group>



    </el-row>


  </div>

  <div class="LineChart">
    <h2 style="text-align: center">{{content.data}}-{{value2}}曲线({{value1}})</h2>
  </div>
  <div id="myChart"
  :style="{ width: '1000px', height: '500px'}"
  ></div>

  
  <div>
    <el-row>
      <el-button :class="{actived:changeBG[0]}" size="mini" @click="fhclick()" >负荷</el-button>
      <el-button :class="{actived:changeBG[1]}" size="mini" @click="wgglclick()" >无功功率</el-button>
      <el-button :class="{actived:changeBG[2]}" size="mini" @click="glysclick()" >功率因数</el-button>
      <el-button :class="{actived:changeBG[3]}" size="mini" @click="dlclick()" >电流</el-button>
      <el-button :class="{actived:changeBG[4]}" size="mini" @click="dyclick()" >电压</el-button>
      <el-button :class="{actived:changeBG[5]}" size="mini" @click="dlxbclick()" >电流谐波</el-button>
      <el-button :class="{actived:changeBG[6]}" size="mini" @click="dyxbclick()" >电压谐波</el-button>
      <el-button :class="{actived:changeBG[7]}" size="mini" @click="dypcclick()" >电压偏差</el-button>
      <el-button :class="{actived:changeBG[8]}" size="mini" @click="sxclick()" >三相不平衡</el-button>

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
const echarts = require("echarts"); // 引入echarts

//获取点击结点的值
import {toDaynodeData} from'@/components/ElectricEnergyAnalysis.vue';
import axios from 'axios'

export default {
  name: "LineChart",
  data() {
    return {
      content:toDaynodeData,
      //后端数据容器
      totaldata:[],//图表
      tableAvgData:[],//表格
      tableMaxData:[],
      tableMinData:[],
      //选择框定义
      isshow0:'',
      isshow1:'',
      isshow2:'display:none',
      isshow3:'display:none',




      //曲线选择
      options: [{
        value: '负荷',
      }, {
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
      //曲线参数
      value2:'负荷',


      //A相B相选择池
      checkList: [],

      //打印图表名称
      htmlTitle: 'myChart',

      //表格选择

      changeBG : [0,0,0,0,0,0,0,0,0],
      
      //时间参数
      value1:'',
      disabledDate(time) {
        return time.getTime() > Date.now();
      },

      echartsOption: {
        legend: {	//图表上方的图例
          data: ['', '', '', '总体','','','','',''],
          selected:{'A相':false, 'B相':false, 'C相':false, '总体':true,'需量负荷':false,'零线电流':false,'Uab':false,'Ubc':false,'Uca':false,}
        },
        // echarts选项，所有绘图数据和样式都在这里设置
        xAxis: {
          type: "category",
          data: [], // x轴数据
          interval :6,
          name: "时间", // x轴名称
          nameTextStyle: {
            // x轴名称样式
            fontWeight: 1000,
            fontSize: 18,
          },
          //间隔显示
          axisLabel: {
            interval: 23
          },
        },
        

        yAxis: {
          type: "value",
          
          name: '负荷', // y轴名称
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

      tableData: []
        
    };
  },


  created(){
     this.convert()
  },
  mounted() {
   
// echarts设置选项

    
  },

  methods:{
    addLine(){
      //判断某些元素是否存在，如果存在就做出时间
      if(this.checkList.indexOf('A相')!=-1){
        this.echartsOption.legend.data[0] = 'A相'
        this.echartsOption.legend.selected['A相'] = true
        
      }else{
        this.echartsOption.legend.data[0] = ''
        this.echartsOption.legend.selected['A相'] = false
      
      }

      if(this.checkList.indexOf('B相')!=-1){
        this.echartsOption.legend.data[1] = 'B相'
        this.echartsOption.legend.selected['B相'] = true
      
      }else{
        this.echartsOption.legend.data[1] = ''
        this.echartsOption.legend.selected['B相'] = false
        
      }

      if(this.checkList.indexOf('C相')!=-1){
        this.echartsOption.legend.data[2] = 'C相'
        this.echartsOption.legend.selected['C相'] = true
       
      }else{
        this.echartsOption.legend.data[2] = ''
        this.echartsOption.legend.selected['C相'] = false
       
      }

      if(this.checkList.indexOf('总体')!=-1){
        this.echartsOption.legend.data[3] = '总体'
        this.echartsOption.legend.selected['总体'] = true
        
      }else{
        this.echartsOption.legend.data[3] = ''
        this.echartsOption.legend.selected['总体'] = false
       
      }

      if(this.checkList.indexOf('需量负荷')!=-1){
        this.echartsOption.legend.data[4] = '需量负荷'
        this.echartsOption.legend.selected['需量负荷'] = true
        
      }else{
        this.echartsOption.legend.data[4] = ''
        this.echartsOption.legend.selected['需量负荷'] = false
        
      }
      if(this.checkList.indexOf('零线电流')!=-1){
        this.echartsOption.legend.data[5] = '零线电流'
        this.echartsOption.legend.selected['零线电流'] = true
      
      }else{
        this.echartsOption.legend.data[5] = ''
        this.echartsOption.legend.selected['零线电流'] = false
        
      }
      if(this.checkList.indexOf('Uab')!=-1){
        this.echartsOption.legend.data[6] = 'Uab'
        this.echartsOption.legend.selected['Uab'] = true
      
      }else{
        this.echartsOption.legend.data[6] = ''
        this.echartsOption.legend.selected['Uab'] = false
        
      }
      if(this.checkList.indexOf('Ubc')!=-1){
        this.echartsOption.legend.data[7] = 'Ubc'
        this.echartsOption.legend.selected['Ubc'] = true
      
      }else{
        this.echartsOption.legend.data[7] = ''
        this.echartsOption.legend.selected['Ubc'] = false
        
      }
      if(this.checkList.indexOf('Uca')!=-1){
        this.echartsOption.legend.data[8] = 'Uca'
        this.echartsOption.legend.selected['Uca'] = true
      
      }else{
        this.echartsOption.legend.data[8] = ''
        this.echartsOption.legend.selected['Uca'] = false
        
      }


      let myChart = echarts.init(document.getElementById("myChart"), "light"); // 初始化echarts, theme为light
        myChart.setOption(this.echartsOption); // echarts设置选项


    },
    //将所有的线条都不显示
    cleanLine(){
      let i=0
      for(i=0;i<9;i++){
        this.echartsOption.legend.data[i] = ''
      }
      this.checkList=[]
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
   
    //打印PDF
    handleCommand(command) {
      if(command=="a"){        
        this.getPdf()
      }

    },
    //下拉框选择
    changeLine(){
      //this.convert()
      
      if(this.value2 == '负荷'){//负荷变量赋值
        //选择框赋值
        this.cleanLine()
        this.isshow0='',
        this.isshow1='display:none',
        this.isshow2='display:none',
        this.isshow3='display:none',


        this.echartsOption.yAxis.name = this.value2+'(kW)'
        let i=0
        while(i<this.totaldata.length){
          //时间戳变量转化成时间变量
          var date = new Date(this.totaldata[i].dataTime*1000 + 8 * 3600 * 1000);
          var daytime = date.toJSON().substr(0, 19).replace('T', ' ').replace(/-/g, '.')
           
          this.echartsOption.xAxis.data[i] = daytime.substring(10,16)//给X轴赋值
          this.echartsOption.series[0].data[i]=this.totaldata[i].aLoad//给A相负荷赋值
          this.echartsOption.series[1].data[i]=this.totaldata[i].bLoad//给B相负荷赋值
          this.echartsOption.series[2].data[i]=this.totaldata[i].cLoad//给C相负荷赋值
          this.echartsOption.series[3].data[i]=this.totaldata[i].totalLoad//给总体负荷赋值
          i=i+1
        }
      }
      else if(this.value2 == '无功功率'){//给无功功率赋值
        //选择框赋值
        this.cleanLine()
        this.isshow0='',
        this.isshow1='display:none',
        this.isshow2='display:none',
        this.isshow3='display:none',

        this.echartsOption.yAxis.name = this.value2+'(kVar)'
        let i=0
        while(i<this.totaldata.length){
          //时间戳变量转化成时间变量
          var date = new Date(this.totaldata[i].dataTime*1000 + 8 * 3600 * 1000);
          var daytime = date.toJSON().substr(0, 19).replace('T', ' ').replace(/-/g, '.')
           
          this.echartsOption.xAxis.data[i] = daytime.substring(10,16)//给X轴赋值
          this.echartsOption.series[0].data[i]=this.totaldata[i].aReactivePower//给A相无功功率赋值
          this.echartsOption.series[1].data[i]=this.totaldata[i].bReactivePower//给B相无功功率赋值
          this.echartsOption.series[2].data[i]=this.totaldata[i].cReactivePower//给C相无功功率赋值
          this.echartsOption.series[3].data[i]=this.totaldata[i].totalReactivePower//给总体无功功率赋值
          i=i+1
        }
      }
      else if(this.value2 == '功率因数'){//给功率因数赋值
        //选择框赋值
        this.cleanLine()
        this.isshow0='',
        this.isshow1='display:none',
        this.isshow2='display:none',
        this.isshow3='display:none',

        this.echartsOption.yAxis.name = this.value2
        let i=0
        while(i<this.totaldata.length){
          //时间戳变量转化成时间变量
          var date = new Date(this.totaldata[i].dataTime*1000 + 8 * 3600 * 1000);
          var daytime = date.toJSON().substr(0, 19).replace('T', ' ').replace(/-/g, '.')
           
          this.echartsOption.xAxis.data[i] = daytime.substring(10,16)//给X轴赋值
          this.echartsOption.series[0].data[i]=this.totaldata[i].aPowerFactor//给A相功率因数赋值
          this.echartsOption.series[1].data[i]=this.totaldata[i].bPowerFactor//给B相功率因数赋值
          this.echartsOption.series[2].data[i]=this.totaldata[i].cPowerFactor//给C相功率因数赋值
          this.echartsOption.series[3].data[i]=this.totaldata[i].totalPowerFactor//给总体功率因数赋值
          i=i+1
        }
      }
      else if(this.value2 == '电流'){//给电流赋值
        //选择框赋值
        this.cleanLine()
        this.isshow0='display:none',
        this.isshow1='display:none',
        this.isshow2='',
        this.isshow3='display:none',

        this.echartsOption.yAxis.name = this.value2+'(A)'
        let i=0
        while(i<this.totaldata.length){
          
          //时间戳变量转化成时间变量
          var date = new Date(this.totaldata[i].dataTime*1000 + 8 * 3600 * 1000);
          var daytime = date.toJSON().substr(0, 19).replace('T', ' ').replace(/-/g, '.')
           
          this.echartsOption.xAxis.data[i] = daytime.substring(10,16)//给X轴赋值
          this.echartsOption.series[0].data[i]=this.totaldata[i].ia//给A相电流赋值
          this.echartsOption.series[1].data[i]=this.totaldata[i].ib//给B相电流赋值
          this.echartsOption.series[2].data[i]=this.totaldata[i].ic//给C相电流赋值
          this.echartsOption.series[5].data[i]=this.totaldata[i].zeroi//给零线赋值
          i=i+1
        }
      }

      else if(this.value2 == '电压'){//给电压赋值
        //选择框赋值
        this.cleanLine()
        this.isshow0='display:none',
        this.isshow1='display:none',
        this.isshow2='display:none',
        this.isshow3='',

        this.echartsOption.yAxis.name = this.value2+'(V)'
        let i=0
        while(i<this.totaldata.length){
          
          //时间戳变量转化成时间变量
          var date = new Date(this.totaldata[i].dataTime*1000 + 8 * 3600 * 1000);
          var daytime = date.toJSON().substr(0, 19).replace('T', ' ').replace(/-/g, '.')
           
          this.echartsOption.xAxis.data[i] = daytime.substring(10,16)//给X轴赋值
          this.echartsOption.series[0].data[i]=this.totaldata[i].ua//给A相电压赋值
          this.echartsOption.series[1].data[i]=this.totaldata[i].ub//给B相电压赋值
          this.echartsOption.series[2].data[i]=this.totaldata[i].uc//给C相电压赋值
          this.echartsOption.series[6].data[i]=this.totaldata[i].uab//给Uab赋值
          this.echartsOption.series[7].data[i]=this.totaldata[i].ubc//给Ubc赋值
          this.echartsOption.series[8].data[i]=this.totaldata[i].uca//给Uca赋值
          
          i=i+1
        }
      }

      //需要重新渲染
      let myChart = echarts.init(document.getElementById("myChart"), "light"); // 初始化echarts, theme为light
      myChart.setOption(this.echartsOption); 
    },

    //将输入时间戳转化为年月日时分秒的字符串（2022.01.05 03:35:00）中间的空格为/t是两位
    changeTime(A){
      var date = new Date(A*1000 + 8 * 3600 * 1000);
      var B = date.toJSON().substr(0, 19).replace('T', ' ').replace(/-/g, '.')
      return B
    },

    //按钮组的显示定义
    fhclick(){
      this.changeBG = [1,0,0,0,0,0,0,0,0]
      this.cleanTable()
      this.tableData[0].message = '总负荷(kW)'
      this.tableData[1].message = 'A相负荷(kW)'
      this.tableData[2].message = 'B相负荷(kW)'
      this.tableData[3].message = 'C相负荷(kW)'

      this.tableData[0].average = this.tableAvgData.totalLoad
      this.tableData[1].average = this.tableAvgData.aLoad
      this.tableData[2].average = this.tableAvgData.bLoad
      this.tableData[3].average = this.tableAvgData.cLoad

      this.tableData[0].maxValue = this.tableMaxData.totalLoad
      this.tableData[1].maxValue = this.tableMaxData.aLoad
      this.tableData[2].maxValue = this.tableMaxData.bLoad
      this.tableData[3].maxValue = this.tableMaxData.cLoad

      this.tableData[0].minValue = this.tableMinData.totalLoad
      this.tableData[1].minValue = this.tableMinData.aLoad
      this.tableData[2].minValue = this.tableMinData.bLoad
      this.tableData[3].minValue = this.tableMinData.cLoad

      this.tableData[0].maxTime = this.changeTime(this.tableMaxData.totalLoadTime)
      this.tableData[1].maxTime = this.changeTime(this.tableMaxData.aLoadTime)
      this.tableData[2].maxTime = this.changeTime(this.tableMaxData.bLoadTime)
      this.tableData[3].maxTime = this.changeTime(this.tableMaxData.cLoadTime)

      this.tableData[0].minTime = this.changeTime(this.tableMinData.totalLoadTime)
      this.tableData[1].minTime = this.changeTime(this.tableMinData.aLoadTime)
      this.tableData[2].minTime = this.changeTime(this.tableMinData.bLoadTime)
      this.tableData[3].minTime = this.changeTime(this.tableMinData.cLoadTime)
    },
    wgglclick(){
      this.changeBG = [0,1,0,0,0,0,0,0,0]
      this.cleanTable()
      this.tableData[0].message = '总无功(kVar)'
      this.tableData[1].message = 'A相无功(kVar)'
      this.tableData[2].message = 'B相无功(kVar)'
      this.tableData[3].message = 'C相无功(kVar)'

      this.tableData[0].average = this.tableAvgData.totalReactivePower
      this.tableData[1].average = this.tableAvgData.aReactivePower
      this.tableData[2].average = this.tableAvgData.bReactivePower
      this.tableData[3].average = this.tableAvgData.cReactivePower

      this.tableData[0].maxValue = this.tableMaxData.totalReactivePower
      this.tableData[1].maxValue = this.tableMaxData.aReactivePower
      this.tableData[2].maxValue = this.tableMaxData.bReactivePower
      this.tableData[3].maxValue = this.tableMaxData.cReactivePower

      this.tableData[0].minValue = this.tableMinData.totalReactivePower
      this.tableData[1].minValue = this.tableMinData.aReactivePower
      this.tableData[2].minValue = this.tableMinData.bReactivePower
      this.tableData[3].minValue = this.tableMinData.cReactivePower

      this.tableData[0].maxTime = this.changeTime(this.tableMaxData.totalReactivePowerTime)
      this.tableData[1].maxTime = this.changeTime(this.tableMaxData.aReactivePowerTime)
      this.tableData[2].maxTime = this.changeTime(this.tableMaxData.bReactivePowerTime)
      this.tableData[3].maxTime = this.changeTime(this.tableMaxData.cReactivePowerTime)

      this.tableData[0].minTime = this.changeTime(this.tableMinData.totalReactivePowerTime)
      this.tableData[1].minTime = this.changeTime(this.tableMinData.aReactivePowerTime)
      this.tableData[2].minTime = this.changeTime(this.tableMinData.bReactivePowerTime)
      this.tableData[3].minTime = this.changeTime(this.tableMinData.cReactivePowerTime)
    },
    glysclick(){
      this.changeBG = [0,0,1,0,0,0,0,0,0]
      this.cleanTable()
      this.tableData[0].message = '总功率因数'
      this.tableData[1].message = 'A相功率因数'
      this.tableData[2].message = 'B相功率因数'
      this.tableData[3].message = 'C相功率因数'

      this.tableData[0].average = this.tableAvgData.totalPowerFactor
      this.tableData[1].average = this.tableAvgData.aPowerFactor
      this.tableData[2].average = this.tableAvgData.bPowerFactor
      this.tableData[3].average = this.tableAvgData.cPowerFactor

      this.tableData[0].maxValue = this.tableMaxData.totalPowerFactor
      this.tableData[1].maxValue = this.tableMaxData.aPowerFactor
      this.tableData[2].maxValue = this.tableMaxData.bPowerFactor
      this.tableData[3].maxValue = this.tableMaxData.cPowerFactor

      this.tableData[0].minValue = this.tableMinData.totalPowerFactor
      this.tableData[1].minValue = this.tableMinData.aPowerFactor
      this.tableData[2].minValue = this.tableMinData.bPowerFactor
      this.tableData[3].minValue = this.tableMinData.cPowerFactor

      this.tableData[0].maxTime = this.changeTime(this.tableMaxData.totalPowerFactorTime)
      this.tableData[1].maxTime = this.changeTime(this.tableMaxData.aPowerFactorTime)
      this.tableData[2].maxTime = this.changeTime(this.tableMaxData.bPowerFactorTime)
      this.tableData[3].maxTime = this.changeTime(this.tableMaxData.cPowerFactorTime)

      this.tableData[0].minTime = this.changeTime(this.tableMinData.totalPowerFactorTime)
      this.tableData[1].minTime = this.changeTime(this.tableMinData.aPowerFactorTime)
      this.tableData[2].minTime = this.changeTime(this.tableMinData.bPowerFactorTime)
      this.tableData[3].minTime = this.changeTime(this.tableMinData.cPowerFactorTime)
    },
    dlclick(){
      this.changeBG = [0,0,0,1,0,0,0,0,0]
      this.cleanTable()
      this.tableData[0].message = 'A相电流(A)'
      this.tableData[1].message = 'B相电流(A)'
      this.tableData[2].message = 'C相电流(A)'
      this.tableData[3].message = '零线电流(A)'

      this.tableData[0].average = this.tableAvgData.ia
      this.tableData[1].average = this.tableAvgData.ib
      this.tableData[2].average = this.tableAvgData.ic
      this.tableData[3].average = this.tableAvgData.zeroi

      this.tableData[0].maxValue = this.tableMaxData.ia
      this.tableData[1].maxValue = this.tableMaxData.ib
      this.tableData[2].maxValue = this.tableMaxData.ic
      this.tableData[3].maxValue = this.tableMaxData.zeroi

      this.tableData[0].minValue = this.tableMinData.ia
      this.tableData[1].minValue = this.tableMinData.ib
      this.tableData[2].minValue = this.tableMinData.ic
      this.tableData[3].minValue = this.tableMinData.zeroi

      this.tableData[0].maxTime = this.changeTime(this.tableMaxData.iaTime)
      this.tableData[1].maxTime = this.changeTime(this.tableMaxData.ibTime)
      this.tableData[2].maxTime = this.changeTime(this.tableMaxData.icTime)
      this.tableData[3].maxTime = this.changeTime(this.tableMaxData.zeroiTime)

      this.tableData[0].minTime = this.changeTime(this.tableMinData.iaTime)
      this.tableData[1].minTime = this.changeTime(this.tableMinData.ibTime)
      this.tableData[2].minTime = this.changeTime(this.tableMinData.icTime)
      this.tableData[3].minTime = this.changeTime(this.tableMinData.zeroiTime)
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


      this.tableData[0].average = this.tableAvgData.ua
      this.tableData[1].average = this.tableAvgData.ub
      this.tableData[2].average = this.tableAvgData.uc
      this.tableData[3].average = this.tableAvgData.uab
      this.tableData[4].average = this.tableAvgData.ubc
      this.tableData[5].average = this.tableAvgData.uca

      this.tableData[0].maxValue = this.tableMaxData.ua
      this.tableData[1].maxValue = this.tableMaxData.ub
      this.tableData[2].maxValue = this.tableMaxData.uc
      this.tableData[3].maxValue = this.tableMaxData.uab
      this.tableData[4].maxValue = this.tableMaxData.ubc
      this.tableData[5].maxValue = this.tableMaxData.uca
       
      this.tableData[0].minValue = this.tableMinData.ua
      this.tableData[1].minValue = this.tableMinData.ub
      this.tableData[2].minValue = this.tableMinData.uc
      this.tableData[3].minValue = this.tableMinData.uab
      this.tableData[4].minValue = this.tableMinData.ubc
      this.tableData[5].minValue = this.tableMinData.uca

      this.tableData[0].maxTime = this.changeTime(this.tableMaxData.uaTime)
      this.tableData[1].maxTime = this.changeTime(this.tableMaxData.ubTime)
      this.tableData[2].maxTime = this.changeTime(this.tableMaxData.ucTime)
      this.tableData[3].maxTime = this.changeTime(this.tableMaxData.uabTime)
      this.tableData[4].maxTime = this.changeTime(this.tableMaxData.ubcTime)
      this.tableData[5].maxTime = this.changeTime(this.tableMaxData.ucaTime)

      this.tableData[0].minTime = this.changeTime(this.tableMinData.uaTime)
      this.tableData[1].minTime = this.changeTime(this.tableMinData.ubTime)
      this.tableData[2].minTime = this.changeTime(this.tableMinData.ucTime)
      this.tableData[3].minTime = this.changeTime(this.tableMinData.uabTime)
      this.tableData[4].minTime = this.changeTime(this.tableMinData.ubcTime)
      this.tableData[5].minTime = this.changeTime(this.tableMinData.ucaTime)

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
      .post("http://114.213.210.219/powerRealtime/findPowerRealtimeByDataTime", {
	      deviceId:"1",
	      dataTime:"1640534400"
      })
      .then(response => {
        this.totaldata = response.data
        //console.log(this.totaldata.length)
        console.log(this.changeTime(1640679300))
        console.log(this.totaldata);
        this.changeLine()
      })
      .catch(error => {
        console.log(error);
      });

      //请求表格数据
      axios
      .post("http://114.213.211.241/PowerAnalyse/DayAvg", {
	      deviceId: "1",
        dataTime: "1641312000"
      })
      .then(response => {
        this.tableAvgData = response.data
        console.log(this.tableAvgData)
        this.fhclick()
      })
      .catch(error => {
        console.log(error);
      });

      axios
      .post("http://114.213.211.241/PowerAnalyse/DayMax", {
	      deviceId: "1",
        dataTime: "1641312000"
      })
      .then(response => {
        this.tableMaxData = response.data
        console.log(this.tableMaxData)
        this.fhclick()
      })
      .catch(error => {
        console.log(error);
      });

      axios
      .post("http://114.213.211.241/PowerAnalyse/DayMin", {
	      deviceId: "1",
        dataTime: "1641312000"
      })
      .then(response => {
        this.tableMinData = response.data
        console.log(this.tableMinData)
        this.fhclick()
      })
      .catch(error => {
        console.log(error);
      });
    }
  },  
};

</script>


<style scoped>

#myChart {
  width: 100%;
  height: 500px;
  margin: 0 auto;
  margin-top: 5%;
}

.actived {
  background: #2c5dff;
  color: #fff;
}

</style>
