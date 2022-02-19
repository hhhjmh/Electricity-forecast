<!-- 耗电时比分析APP-->
<template>
  <div>
    <!-- APP按钮 -->
    <div class="buttonBackground"id="btn_normal">
      <button   type="text" @click="OPEN()"></button>
      <p>耗电时比分析</p>
    </div>
    <el-dialog title="耗电时比分析" :visible.sync="timeCompareVisible" width="70%"
    :close-on-click-modal="false" :modal="false" center v-dialogDrag>
    <el-container>
      <el-aside id ='timeConpareaside' width="240px">
        <div >
          <el-row  type="flex" class="row-bg" justify="space-between" >
                
            <el-button :class="{active:changeBackground1}" size="mini" @click="jcdclick()" >监测点</el-button>
            <el-button :class="{active:changeBackground2}" size="mini" @click="yddyclick()" >用电单元</el-button>
            <el-button :class="{active:changeBackground3}" size="mini" @click="jzwclick()" >建筑物</el-button>
             
          </el-row>
        </div>
          <div>
            <el-tree :style="msg1" :data="treeData1" :props="defaultProps" default-expand-all @node-click="handleNodeClick"></el-tree>
            <el-tree :style="msg2" :data="treeData2" :props="defaultProps" default-expand-all @node-click="handleNodeClick"></el-tree>
            <el-tree :style="msg3" :data="treeData3" :props="defaultProps" default-expand-all @node-click="handleNodeClick"></el-tree>
          </div>

      </el-aside>
      <el-main>

        
        <span class="demonstration"> 周期:</span>
        <!-- 图表内容 label不设置则等同于value的值-->
        <el-select @change="changeCycle()" v-model="cycleValue" placeholder="选择曲线" >
          <el-option
          v-for="item in cycleOptions"
          :key="item.value"
         :value="item.value">
          </el-option>
        </el-select>


        <span class="demonstration"> 曲线:</span>
        <!-- 图表内容 label不设置则等同于value的值-->
        <el-select @change="changeLine()" v-model="lineValue" placeholder="选择曲线">
          <el-option
          v-for="item in timeCompareOptions"
          :key="item.value"
         :value="item.value">
          </el-option>
        </el-select>

        <el-button type="primary" @click="showline()">确定</el-button>
        <!-- 选择显示线段 -->
        
        <div>
        <span class="demonstration">第一时间:</span>
        <!-- 日期选择器 -->
        <el-date-picker
        value-format="yyyy-MM-dd"
        v-model="firstTimeValue"
        type="date"
        placeholder="选择日期">
        </el-date-picker>

        <span class="demonstration">第二时间:</span>
        <!-- 日期选择器 -->
        <el-date-picker
        value-format="yyyy-MM-dd"
        v-model="secondTimeValue"
        type="date"
        placeholder="选择日期">
        </el-date-picker>
        </div>
        <div>



        <el-checkbox-group @change="addLineCompare()" v-model="checkListCompare">
          <el-checkbox label="A相"></el-checkbox>
          <el-checkbox label="B相"></el-checkbox>
          <el-checkbox label="C相"></el-checkbox>
          <el-checkbox :style="isshowCompare0" label="总体"></el-checkbox>
          <el-checkbox :style="isshowCompare1" label="需量负荷"></el-checkbox>
          <el-checkbox :style="isshowCompare2" label="零线电流"></el-checkbox>
          <el-checkbox :style="isshowCompare3" label="Uab"></el-checkbox>
          <el-checkbox :style="isshowCompare3" label="Ubc"></el-checkbox>
          <el-checkbox :style="isshowCompare3" label="Uca"></el-checkbox>
        </el-checkbox-group>
        </div>

        <!-- 图显示 -->
        <div class="Chart">
          <h2 style="text-align: center">{{this.nodeData}}-{{lineValue}}曲线({{this.firstTimeValue}}VS{{this.secondTimeValue}})</h2>
        </div>
        <div id="myChartCompare"
        :style="{ width: '1000px', height: '500px'}"
        ></div>
        

        <!-- 表格显示按钮 -->
        <div>
          <el-row>
            <el-button :class="{activedCompare:changeBG[0]}" size="mini" @click="powerclick()" >电力</el-button>
            <el-button :class="{activedCompare:changeBG[1]}" size="mini" @click="dnzlclick()" >电能质量</el-button>
            <el-button :class="{activedCompare:changeBG[2]}" size="mini" @click="dlclick()" >电量</el-button>
          </el-row>

        </div>


        <!-- 表格 -->
        <div>
          <el-table :data="tableDataPower" :style="isshowTable1" :header-cell-style="{textAlign: 'center'}">
            <el-table-column prop="tbzq" label="同比周期" width="150"></el-table-column>
            <el-table-column label="总负荷(kW)" width="">
              <el-table-column prop="averageTotalfh" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueTotalfh" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeTotalfh" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueTotalfh" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeTotalfh" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>


            <el-table-column label="A相负荷(kW)" width="">
              <el-table-column prop="averageAfh" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueAfh" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeAfh" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueAfh" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeAfh" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>


            <el-table-column label="B相负荷(kW)" width="">
              <el-table-column prop="averageBfh" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueBfh" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeBfh" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueBfh" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeBfh" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="C相负荷(kW)" width="">
              <el-table-column prop="averageCfh" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueCfh" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeCfh" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueCfh" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeCfh" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="总功率因数" width="">
              <el-table-column prop="averageTotalglys" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueTotalglys" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeTotalglys" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueTotalglys" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeTotalglys" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="A相功率因数" width="">
              <el-table-column prop="averageAglys" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueAglys" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeAglys" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueAglys" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeAglys" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="B相功率因数" width="">
              <el-table-column prop="averageBglys" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueBglys" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeBglys" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueBglys" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeBglys" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="C相功率因数" width="">
              <el-table-column prop="averageCglys" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueCglys" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeCglys" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueCglys" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeCglys" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="Uab" width="">
              <el-table-column prop="averageUab" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueUab" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeUab" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueUab" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeUab" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="Ubc" width="">
              <el-table-column prop="averageUbc" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueUbc" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeUbc" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueUbc" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeUbc" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="Uca" width="">
              <el-table-column prop="averageUca" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueUca" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeUca" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueUca" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeUca" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="A相电压(V)" width="">
              <el-table-column prop="averageUA" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueUA" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeUA" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueUA" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeUA" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="B相电压(V)" width="">
              <el-table-column prop="averageUB" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueUB" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeUB" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueUB" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeUB" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="C相电压(V)" width="">
              <el-table-column prop="averageUC" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueUC" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeUC" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueUC" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeUC" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="A相电流(A)" width="">
              <el-table-column prop="averageIA" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueIA" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeIA" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueIA" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeIA" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="B相电流(A)" width="">
              <el-table-column prop="averageIB" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueIB" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeIB" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueIB" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeIB" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="C相电流(A)" width="">
              <el-table-column prop="averageIC" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueIC" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeIC" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueIC" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeIC" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="零线电流(A)" width="">
              <el-table-column prop="averageIzero" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueIzero" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeIzero" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueIzero" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeIzero" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>




          </el-table>

          <el-table :data="tableDataDnzl" :style="isshowTable2" :header-cell-style="{textAlign: 'center'}">
            <el-table-column prop="tbzq" label="同比周期" width="150"></el-table-column>
            
            <el-table-column label="A相谐波电流畸变率(%)" width="">
              <el-table-column prop="averageAxb" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueAxb" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeAxb" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueAxb" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeAxb" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>
            
            <el-table-column label="B相谐波电流畸变率(%)" width="">
              <el-table-column prop="averageBxb" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueBxb" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeBxb" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueBxb" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeBxb" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="C相谐波电流畸变率(%)" width="">
              <el-table-column prop="averageCxb" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueCxb" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeCxb" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueCxb" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeCxb" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="A相谐波电流畸变率(%)" width="">
              <el-table-column prop="averageAIxb" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueAIxb" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeAIxb" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueAIxb" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeAIxb" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>
            
            <el-table-column label="B相谐波电流畸变率(%)" width="">
              <el-table-column prop="averageBIxb" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueBIxb" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeBIxb" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueBIxb" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeBIxb" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="C相谐波电流畸变率(%)" width="">
              <el-table-column prop="averageCIxb" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueCIxb" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeCIxb" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueCIxb" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeCIxb" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="A相谐波电压畸变率(%)" width="">
              <el-table-column prop="averageAUxb" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueAUxb" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeAUxb" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueAUxb" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeAUxb" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="B相谐波电压畸变率(%)" width="">
              <el-table-column prop="averageBUxb" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueBUxb" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeBUxb" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueBUxb" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeBUxb" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="C相谐波电压畸变率(%)" width="">
              <el-table-column prop="averageCUxb" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueCUxb" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeCUxb" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueCUxb" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeCUxb" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="Uab偏差(%)" width="">
              <el-table-column prop="averageUabpx" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueUabpx" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeUabpx" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueUabpx" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeUabpx" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="Ubc偏差(%)" width="">
              <el-table-column prop="averageUbcpx" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueUbcpx" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeUbcpx" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueUbcpx" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeUbcpx" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="Uca偏差(%)" width="">
              <el-table-column prop="averageUcapx" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueUcapx" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeUcapx" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueUcapx" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeUcapx" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="A相电压偏差(%)" width="">
              <el-table-column prop="averageAUpx" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueAUpx" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeAUpx" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueAUpx" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeAUpx" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="B相电压偏差(%)" width="">
              <el-table-column prop="averageBUpx" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueBUpx" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeBUpx" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueBUpx" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeBUpx" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="C相电压偏差(%)" width="">
              <el-table-column prop="averageCUpx" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueCUpx" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeCUpx" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueCUpx" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeCUpx" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="频率偏差(Hz)" width="">
              <el-table-column prop="averagePlpx" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValuePlpx" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimePlpx" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValuePlpx" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimePlpx" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="三相电流不平衡度(%)" width="">
              <el-table-column prop="averageSxI" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueSxI" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeSxI" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueSxI" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeSxI" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>

            <el-table-column label="三相电压不平衡度(%)" width="">
              <el-table-column prop="averageSxU" label="平均值" width="100"></el-table-column>
              <el-table-column label="最大值" width="300">
                <el-table-column prop="maxValueSxU" label="值" width="100"></el-table-column>
                <el-table-column prop="maxTimeSxU" label="时间" width="200"></el-table-column>
              </el-table-column>
              <el-table-column label="最小值" width="300">
                <el-table-column prop="minValueSxU" label="值" width="100"></el-table-column>
                <el-table-column prop="minTimeSxU" label="时间" width="200"></el-table-column>
              </el-table-column>
            </el-table-column>








            





          </el-table>





        </div>

      </el-main>
    </el-container>

    </el-dialog>



    </div>
</template>
<script>
const echarts = require("echarts");
import axios from 'axios'
export default {
  name: 'CompareChart',
  data(){
    
    return{

      firstTimedata:[],
      secondTimedata:[],

      firstDay:[],
      secondDay:[],
      firstMonth:[],
      secondMonth:[],
      firstYear:[],
      secondYear:[],
      

      timeCompareVisible: false,
      //选择框定义
      
      //初始默认监测点的按钮是被点击的
      changeBackground1:1,
      changeBackground2:0,
      changeBackground3:0,
      //初始显示监测点树形结构
      msg1:'',
      msg2:'display:none',
      msg3:'display:none',

      //用于记录点击的结点
      nodeData:'主变',

    //给{监察点}树形结构赋值
      treeData1:[{
        label: '电能管理体验馆',
        children:[{
          label: '主变',
          children:[{
            label:'1#空调柜2'
          },{
            label:'3#动力柜'
          },{
            label:'水处理系统'
          },{
            label:'风机系统'
          },{
            label:'冷却水塔'
          },{
            label:'锅炉房'
          },{
            label:'空调用水泵'
          },{
            label:'2#冰水机'
          },{
            label:'高压空压机'
          },{
            label:'2#空调柜'
          },{
            label:'低压空压机'
          },{
            label:'1#冰水机'
          },{
            label:'传输系统'
          },{
            label:'1#动力柜',
            children:[{
              label:'1#插座电源'
              },{
              label:'2#插座电源'
            }]
          }]
        }],
      }],
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

      timeCompareOptions: [{
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
        value: '电量',
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
      lineValue:'负荷',
      cycleOptions:[{
        value:'按日'
      },{
        value:'按月'
      },{
        value:'按年'
      }],
      cycleValue:'按日',

      checkListCompare:['总体'],
      isshowCompare0:'',
      isshowCompare1:'display:none',
      isshowCompare2:'display:none',
      isshowCompare3:'display:none',


      //时间选择器时间赋值
      firstTimeValue:'',
      secondTimeValue:'',

      echartsOption: {
        legend: {	//图表上方的图例
          y:'bottom',
          
          data: ['总体'],//后面会被checklist赋值
          selected:{'A相':false, 'B相':false, 'C相':false, '总体':true,'需量负荷':false,'零线电流':false,'Uab':false,'Ubc':false,'Uca':false,}
        },
        
        // echarts选项，所有绘图数据和样式都在这里设置
        xAxis: {
          type: "category",
          data: [], // x轴数据
          
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
          min:1000,
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
      
      //按钮颜色显示
      changeBG:[1,0,0],

      //表格显示
      isshowTable1:'',
      isshowTable2:'display:none',
      isshowTable3:'display:none',

      //表格数据
      tableDataPower:[],
      tableDataDnzl:[],
      tableDataDl:[],

      //表格请求数据
      //放入表格
      tableMinDataCompare:[],
      tableMaxDataCompare:[],
      tableAvgDataCompare:[],

      //请求日
      tabledataDayAvg:[],
      tabledataDayMax:[],
      tabledataDayMin:[],

      //请求月
      tabledataMonthAvg:[],
      tabledataMonthMax:[],
      tabledataMonthMin:[],

      //请求年
      tabledataYearAvg:[],
      tabledataYearMax:[],
      tabledataYearMin:[],


    }
  },

  created(){
    this.convertCompare()
  },
  mounted(){
    
  },
  
  

  methods:{
     
    OPEN(){
      this.timeCompareVisible = true
      this.initEcharts()
      

    },
    
    handleNodeClick(data) {
      
      this.nodeData = data.label,
      //toDaynodeData.data = data.label
      
      console.log(this.nodeData);
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

    

  //------------------------------------------图数据处理----------------------------------------
    //在打开时显示
    initEcharts(){
      let newPromise = new Promise((resolve) => {
        resolve()
      })
    //然后异步执行echarts的初始化函数
      newPromise.then(() => {
        //  此dom为echarts图标展示dom
        let myChartCompare = echarts.init(document.getElementById("myChartCompare"), "light"); // 初始化echarts, theme为light
        myChartCompare.setOption(this.echartsOption);
    })
    },

    addLineCompare(){
      this.echartsOption.legend.data=this.checkListCompare
      //判断某些元素是否存在，如果存在就做出时间
      if(this.checkListCompare.indexOf('A相')!=-1){
        this.echartsOption.legend.selected['A相'] = true
        
      }else{
        this.echartsOption.legend.selected['A相'] = false
      
      }

      if(this.checkListCompare.indexOf('B相')!=-1){
        this.echartsOption.legend.selected['B相'] = true
      }else{
        this.echartsOption.legend.selected['B相'] = false
        
      }

      if(this.checkListCompare.indexOf('C相')!=-1){

        this.echartsOption.legend.selected['C相'] = true
       
      }else{

        this.echartsOption.legend.selected['C相'] = false
       
      }
      if(this.checkListCompare.indexOf('总体')!=-1){
        this.echartsOption.legend.selected['总体'] = true 
      }else{
  
        this.echartsOption.legend.selected['总体'] = false
      }
      if(this.checkListCompare.indexOf('需量负荷')!=-1){
        this.echartsOption.legend.selected['需量负荷'] = true
      }else{
        this.echartsOption.legend.selected['需量负荷'] = false  
      }
      if(this.checkListCompare.indexOf('零线电流')!=-1){
        this.echartsOption.legend.selected['零线电流'] = true
      }else{
        this.echartsOption.legend.selected['零线电流'] = false
      }
      if(this.checkListCompare.indexOf('Uab')!=-1){
        this.echartsOption.legend.selected['Uab'] = true
      }else{
        this.echartsOption.legend.selected['Uab'] = false 
      }
      if(this.checkListCompare.indexOf('Ubc')!=-1){
        this.echartsOption.legend.selected['Ubc'] = true
      }else{
        this.echartsOption.legend.selected['Ubc'] = false
      }
      if(this.checkListCompare.indexOf('Uca')!=-1){
        this.echartsOption.legend.selected['Uca'] = true
      }else{
        this.echartsOption.legend.selected['Uca'] = false
      }
      console.log(this.echartsOption.legend.data)

      let myChartCompare = echarts.init(document.getElementById("myChartCompare"), "light"); // 初始化echarts, theme为light
      myChartCompare.setOption(this.echartsOption);
    } ,
    cleanLine(){
      // let i=0
      // for(i=0;i<9;i++){
      //   this.echartsOption.legend.data[i] = ''
      // }
      this.checkListCompare=[]
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
      if(this.lineValue == '负荷'){//负荷变量赋值
        //选择框赋值
        this.cleanLine()
        
        this.isshowCompare0='',
        this.isshowCompare1='display:none',
        this.isshowCompare2='display:none',
        this.isshowCompare3='display:none'
        this.checkListCompare=['总体']
        this.echartsOption.legend.data=['总体']
        this.echartsOption.legend.selected['总体']=true
        
        this.echartsOption.yAxis.name = this.lineValue+'(kW)'
        
        let i=0
        while(i<this.firstTimedata.length){
          //时间戳变量转化成时间变量
          var date = new Date(this.firstTimedata[i].dataTime*1000 + 8 * 3600 * 1000);
          var daytime = date.toJSON().substr(0, 19).replace('T', ' ').replace(/-/g, '.')
           
          this.echartsOption.xAxis.data[i] = daytime.substring(10,16)//给X轴赋值
          this.echartsOption.series[0].data[i]=this.firstTimedata[i].aLoad//给A相负荷赋值
          this.echartsOption.series[1].data[i]=this.firstTimedata[i].bLoad//给B相负荷赋值
          this.echartsOption.series[2].data[i]=this.firstTimedata[i].cLoad//给C相负荷赋值
          this.echartsOption.series[3].data[i]=this.firstTimedata[i].totalLoad//给总体负荷赋值
          
          i=i+1
        }

      }
      else if(this.lineValue == '无功功率'){//给无功功率赋值
        //选择框赋值
        this.cleanLine()
        this.isshowCompare0='',
        this.isshowCompare1='display:none',
        this.isshowCompare2='display:none',
        this.isshowCompare3='display:none'
        this.echartsOption.yAxis.name = this.lineValue+'(kVar)'
        this.checkListCompare=['总体']
        this.echartsOption.legend.data=['总体']
        this.echartsOption.legend.selected['总体']=true
        
        let i=0
        while(i<this.firstTimedata.length){
          //时间戳变量转化成时间变量
          var date = new Date(this.firstTimedata[i].dataTime*1000 + 8 * 3600 * 1000);
          var daytime = date.toJSON().substr(0, 19).replace('T', ' ').replace(/-/g, '.')
           
          this.echartsOption.xAxis.data[i] = daytime.substring(10,16)//给X轴赋值
          this.echartsOption.series[0].data[i]=this.firstTimedata[i].aReactivePower//给A相无功功率赋值
          this.echartsOption.series[1].data[i]=this.firstTimedata[i].bReactivePower//给B相无功功率赋值
          this.echartsOption.series[2].data[i]=this.firstTimedata[i].cReactivePower//给C相无功功率赋值
          this.echartsOption.series[3].data[i]=this.firstTimedata[i].totalReactivePower//给总体无功功率赋值
          i=i+1
        }
      }
      else if(this.lineValue == '功率因数'){//给功率因数赋值
        //选择框赋值
        this.cleanLine()  
        this.isshowCompare0=''
        this.isshowCompare1='display:none'
        this.isshowCompare2='display:none'
        this.isshowCompare3='display:none'
        this.checkListCompare=['总体']
        this.echartsOption.legend.data=['总体']
        this.echartsOption.legend.selected['总体']=true

        this.echartsOption.yAxis.name = this.lineValue

        let i=0
        while(i<this.firstTimedata.length){
          //时间戳变量转化成时间变量
          var date = new Date(this.firstTimedata[i].dataTime*1000 + 8 * 3600 * 1000);
          var daytime = date.toJSON().substr(0, 19).replace('T', ' ').replace(/-/g, '.')
           
          this.echartsOption.xAxis.data[i] = daytime.substring(10,16)//给X轴赋值
          this.echartsOption.series[0].data[i]=this.firstTimedata[i].aPowerFactor//给A相功率因数赋值
          this.echartsOption.series[1].data[i]=this.firstTimedata[i].bPowerFactor//给B相功率因数赋值
          this.echartsOption.series[2].data[i]=this.firstTimedata[i].cPowerFactor//给C相功率因数赋值
          this.echartsOption.series[3].data[i]=this.firstTimedata[i].totalPowerFactor//给总体功率因数赋值
          i=i+1
        }
        
      }
      else if(this.lineValue == '电流'){//给电流赋值
        //选择框赋值
        this.cleanLine()
        this.isshowCompare0='display:none',
        this.isshowCompare1='display:none',
        this.isshowCompare2='',
        this.isshowCompare3='display:none'
        this.echartsOption.yAxis.name = this.lineValue+'(A)'

        let i=0
        while(i<this.firstTimedata.length){
          
          //时间戳变量转化成时间变量
          var date = new Date(this.firstTimedata[i].dataTime*1000 + 8 * 3600 * 1000);
          var daytime = date.toJSON().substr(0, 19).replace('T', ' ').replace(/-/g, '.')
           
          this.echartsOption.xAxis.data[i] = daytime.substring(10,16)//给X轴赋值
          this.echartsOption.series[0].data[i]=this.firstTimedata[i].ia//给A相电流赋值
          this.echartsOption.series[1].data[i]=this.firstTimedata[i].ib//给B相电流赋值
          this.echartsOption.series[2].data[i]=this.firstTimedata[i].ic//给C相电流赋值
          this.echartsOption.series[5].data[i]=this.firstTimedata[i].zeroi//给零线赋值
          i=i+1
        }
        
      }

      else if(this.lineValue == '电压'){//给电压赋值
        //选择框赋值
        this.cleanLine()
        this.isshowCompare0='display:none',
        this.isshowCompare1='display:none',
        this.isshowCompare2='display:none',
        this.isshowCompare3=''
        this.echartsOption.yAxis.name = this.lineValue+'(V)'

        let i=0
        while(i<this.firstTimedata.length){
          
          //时间戳变量转化成时间变量
          var date = new Date(this.firstTimedata[i].dataTime*1000 + 8 * 3600 * 1000);
          var daytime = date.toJSON().substr(0, 19).replace('T', ' ').replace(/-/g, '.')
           
          this.echartsOption.xAxis.data[i] = daytime.substring(10,16)//给X轴赋值
          this.echartsOption.series[0].data[i]=this.firstTimedata[i].ua//给A相电压赋值
          this.echartsOption.series[1].data[i]=this.firstTimedata[i].ub//给B相电压赋值
          this.echartsOption.series[2].data[i]=this.firstTimedata[i].uc//给C相电压赋值
          this.echartsOption.series[6].data[i]=this.firstTimedata[i].uab//给Uab赋值
          this.echartsOption.series[7].data[i]=this.firstTimedata[i].ubc//给Ubc赋值
          this.echartsOption.series[8].data[i]=this.firstTimedata[i].uca//给Uca赋值
          
          i=i+1
        }
        
        
      }
      let myChartCompare = echarts.init(document.getElementById("myChartCompare"), "light"); // 初始化echarts, theme为light
      myChartCompare.setOption(this.echartsOption);
      console.log(this.lineValue)
    },
    changeCycle(){
      if(this.cycleValue=='按日'){
        this.firstTimedata=this.firstDay
        this.secondTimedata=this.secondDay

        this.tableAvgDataCompare = this.tabledataDayAvg
        this.tableMaxDataCompare = this.tabledataDayMax
        this.tableMinDataCompare = this.tabledataDayMin

      }
      this.changeLine()
      
      console.log(this.cycleValue)
    },
    
    showline(){
      this.powerclick()
      let myChartCompare = echarts.init(document.getElementById("myChartCompare"), "light"); // 初始化echarts, theme为light
      myChartCompare.setOption(this.echartsOption);
      
    },

    //------------------------------------------图表显示----------------------------------------
    initPowerTable(){
      this.tableDataPower=[]
      let i=0
      while(i<=1){
        this.tableDataPower.push({
        tbzq:'',

        averageTotalfh:'',
        maxValueTotalfh:'',
        maxTimeTotalfh:'',
        minValueTotalfh:'',
        minTimeTotalfh:'',

        averageAfh:'',
        maxValueAfh:'',
        maxTimeAfh:'',
        minValueAfh:'',
        minTimeAfh:'',

        averageBfh:'',
        maxValueBfh:'',
        maxTimeBfh:'',
        minValueBfh:'',
        minTimeBfh:'',

        averageCfh:'',
        maxValueCfh:'',
        maxTimeCfh:'',
        minValueCfh:'',
        minTimeCfh:'',

        averageTotalglys:'',
        maxValueTotalglys:'',
        maxTimeTotalglys:'',
        minValueTotalglys:'',
        minTimeTotalglys:'',
        

        averageAglys:'',
        maxValueAglys:'',
        maxTimeAglys:'',
        minValueAglys:'',
        minTimeAglys:'',
        

        averageBglys:'',
        maxValueBglys:'',
        maxTimeBglys:'',
        minValueBglys:'',
        minTimeBglys:'',

        averageCglys:'',
        maxValueCglys:'',
        maxTimeCglys:'',
        minValueCglys:'',
        minTimeCglys:'',

        averageUab:'',
        maxValueUab:'',
        maxTimeUab:'',
        minValueUab:'',
        minTimeUab:'',

        averageUbc:'',
        maxValueUbc:'',
        maxTimeUbc:'',
        minValueUbc:'',
        minTimeUbc:'',

        averageUca:'',
        maxValueUca:'',
        maxTimeUca:'',
        minValueUca:'',
        minTimeUca:'',
        
        averageUA:'',
        maxValueUA:'',
        maxTimeUA:'',
        minValueUA:'',
        minTimeUA:'',

        averageUB:'',
        maxValueUB:'',
        maxTimeUB:'',
        minValueUB:'',
        minTimeUB:'',

        averageUC:'',
        maxValueUC:'',
        maxTimeUC:'',
        minValueUC:'',
        minTimeUC:'',

        averageIA:'',
        maxValueIA:'',
        maxTimeIA:'',
        minValueIA:'',
        minTimeIA:'',

        averageIB:'',
        maxValueIB:'',
        maxTimeIB:'',
        minValueIB:'',
        minTimeIB:'',

        averageIC:'',
        maxValueIC:'',
        maxTimeIC:'',
        minValueIC:'',
        minTimeIC:'',


        averageIzero:'',
        maxValueIzero:'',
        maxTimeIzero:'',
        minValueIzero:'',
        minTimeIzero:'',





        })
        i=i+1
      }
    },
    
    
    powerclick(){
      this.changeBG=[1,0,0]
      this.isshowTable1 = ''
      this.isshowTable2 = 'display:none'
      this.isshowTable3 = 'display:none'
      this.initPowerTable()

      this.tableDataPower[0].tbzq=this.firstTimeValue
      this.tableDataPower[0].averageTotalfh = this.tableAvgDataCompare.totalLoad
      this.tableDataPower[0].maxValueTotalfh = this.tableMaxDataCompare.totalLoad
      this.tableDataPower[0].maxTimeTotalfh = this.tableMaxDataCompare.totalLoadTime
      this.tableDataPower[0].minValueTotalfh = this.tableMinDataCompare.totalLoad
      this.tableDataPower[0].minTimeTotalfh = this.tableMinDataCompare.totalLoadTime


    },
    dnzlclick(){
      this.changeBG=[0,1,0]
      this.isshowTable1 = 'display:none'
      this.isshowTable2 = ''
      this.isshowTable3 = 'display:none'
    },
    dlclick(){
      this.changeBG=[0,0,1]
      this.isshowTable1 = 'display:none'
      this.isshowTable2 = 'display:none'
      this.isshowTable3 = ''
    },



    //------------------------------------------请求数据----------------------------------------

    convertCompare(){
      //请求日图表数据
      axios
      .post("http://121.43.111.195/powerRealtime/findPowerRealtimeByDataTime", {
	      deviceId:"1",
	      dataTime:"1638288000"
      })
      .then(response => {
        this.firstDay = response.data
        console.log(this.firstDay);
        this.changeCycle()
        
      })
      .catch(error => {
        console.log(error);
      });

      axios
      .post("http://121.43.111.195/powerRealtime/findPowerRealtimeByDataTime", {
	      deviceId:"1",
	      dataTime:"1638374400"
      })
      .then(response => {
        this.secondDay = response.data
        console.log(this.secondDay);
        
      })
      .catch(error => {
        console.log(error);
      });

      //请求表格数据
      axios
      .post("http://121.43.111.195/PowerAnalyse/DayAvg", {
	      deviceId: "1",
        dataTime: "1638288000"
      })
      .then(response => {
        this.tabledataDayAvg = response.data
        console.log(this.tabledataDayAvg)
        
      })
      .catch(error => {
        console.log(error);
      });

      axios
      .post("http://121.43.111.195/PowerAnalyse/DayMax", {
	      deviceId: "1",
        dataTime: "1638288000"
      })
      .then(response => {
        this.tabledataDayMax = response.data
        console.log(this.tabledataDayMax)
        
      })
      .catch(error => {
        console.log(error);
      });

      axios
      .post("http://121.43.111.195/PowerAnalyse/DayMin", {
	      deviceId: "1",
        dataTime: "1638288000"
      })
      .then(response => {
        this.tabledataDayMin = response.data
        console.log(this.tabledataDayMin)
        
      })
      .catch(error => {
        console.log(error);
      });
    }
  },

}
</script>







<style src="../assets/css/button.css">


</style>
<style scoped>
.active {
  background: #2c5dff;
  color: #fff;
}
#myChartCompare {
  width: 100%;
  height: 500px;
  margin: 0 auto;
  margin-top: 5%;
}
#timeConpareaside {
  background-color: cornflowerblue;
  font-size :20px;
  
}
 .buttonBackground button {
   
     background-image: url(../assets/icon/timeCompare.png);
  }
  .buttonBackground {

    left: 21rem;
    top: 0rem;
  }
.activedCompare{
  background: #2c5dff;
  color: #fff;
}
</style>

