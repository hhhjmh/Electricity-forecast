<template>
  <div>
    <el-container>
      <el-aside id="inaside" width="240px">
        <el-tree
        @check-change="handleCheckChange"
          :data="data"
          show-checkbox
          node-key="id"
          :default-expanded-keys="[1]"
          :props="defaultProps"
        >
        </el-tree>
      </el-aside>

      <el-main id="day">
        <el-row id="title">
          <span class="demonstration"> 报表类型:</span>
          <!-- 图表内容 label不设置则等同于value的值-->
          <el-select v-model="value2" placeholder="选择报表">
            <el-option
              v-for="item in options"
              :key="item.value"
              :value="item.value"
            >
            </el-option>
          </el-select>
          <!-- 峰谷平尖日期选择器 -->
          <el-date-picker
            :style="areshow0"
            v-model="value3"
            type="daterange"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
          >
          </el-date-picker>
          <!-- 日电量日期选择器 -->
          <el-date-picker
            :style="areshow1"
            value-format="yyyy-MM-dd"
            v-model="value4"
            type="date"
            placeholder="选择日期"
          >
          </el-date-picker>
          <!-- 月选择器 -->
          <el-date-picker
            :style="areshow2"
            v-model="value5"
            type="month"
            placeholder="选择月"
          >
          </el-date-picker>
          <!-- 时刻表日期选择器 -->
          <el-date-picker
            :style="areshow3"
            v-model="value6"
            type="datetimerange"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
          >
          </el-date-picker>
          <!-- 月选择器 -->
          <el-date-picker
            :style="areshow4"
            v-model="value7"
            type="month"
            placeholder="选择月"
          >
          </el-date-picker>

          <el-button type="primary" plain size="medium" @click="convert()"
            >确定</el-button
          >
          <!-- 导出功能 -->
          <el-dropdown @command="handleCommand">
            <el-button type="primary" plain size="medium">
              导出<i class="el-icon-arrow-down el-icon--right"></i>
            </el-button>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item v-print="'#myChart'">打印图表</el-dropdown-item>
              <el-dropdown-item command="a">导出PDF格式</el-dropdown-item>
              <el-dropdown-item>导出JPEG格式</el-dropdown-item>
              <el-dropdown-item>导出PNG格式</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-row>

        <!-- <div>
          <el-row>
            <el-button
              :class="{ actived: changeBG[0] }"
              size="mini"
              @click="fhclick()"
              >峰谷平尖电量统计</el-button
            >
            <el-button
              :class="{ actived: changeBG[1] }"
              size="mini"
              @click="wgglclick()"
              >无功功率</el-button
            >
            <el-button
              :class="{ actived: changeBG[2] }"
              size="mini"
              @click="glysclick()"
              >功率因数</el-button
            >
            <el-button
              :class="{ actived: changeBG[3] }"
              size="mini"
              @click="dlclick()"
              >电流</el-button
            >
            <el-button
              :class="{ actived: changeBG[4] }"
              size="mini"
              @click="dyclick()"
              >电压</el-button
            >
            <el-button
              :class="{ actived: changeBG[5] }"
              size="mini"
              @click="dlxbclick()"
              >电流谐波</el-button
            >
            <el-button
              :class="{ actived: changeBG[6] }"
              size="mini"
              @click="dyxbclick()"
              >电压谐波</el-button
            >
            <el-button
              :class="{ actived: changeBG[7] }"
              size="mini"
              @click="dypcclick()"
              >电压偏差</el-button
            >
            <el-button
              :class="{ actived: changeBG[8] }"
              size="mini"
              @click="sxclick()"
              >三相不平衡</el-button
            >
          </el-row>
        </div> -->

        <div>
          <!-- 峰谷平尖电量表 -->
          <el-table
            :style="areshow0"
            :data="tableData0"
            border
            show-summary
            class="kuan"
            :cell-style="{ textAlign: 'center' }"
            :header-cell-style="{ textAlign: 'center' }"
          >
            <el-table-column fixed prop="deviceId" label="监测点名称" width="100">
            </el-table-column>
            <el-table-column prop="totalkWh" label="总电量(kW.h)">
            </el-table-column>
            <el-table-column prop="totalCharge" label="总电费(元)"> </el-table-column>
            <el-table-column prop="amount1" label="峰">
              <el-table-column prop="highKWh" label="峰电量(kW.h)">
              </el-table-column>
              <el-table-column prop="highCharge" label="峰电费(元)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="amount0" label="谷">
              <el-table-column prop="lowKWh" label="谷电量(kW.h)">
              </el-table-column>
              <el-table-column prop="lowCharge" label="谷电费(元)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="amount0" label="平">
              <el-table-column prop="midKWh" label="平电量(kW.h)">
              </el-table-column>
              <el-table-column prop="midCharge" label="平电费(元)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="amount0" label="尖">
              <el-table-column prop="topKWh" label="尖电量(kW.h)">
              </el-table-column>
              <el-table-column prop="topCharge" label="尖电费(元)">
              </el-table-column>
            </el-table-column>
          </el-table>
          <!-- 日电量表 -->
          <el-table
            :style="areshow1"
            :data="tableData1"
            border
            class="kuan"
            :cell-style="{ textAlign: 'center' }"
            :header-cell-style="{ textAlign: 'center' }"
          >
            <el-table-column fixed prop="deviceId" label="监测点名称" width="100">
            </el-table-column>
            <el-table-column
              prop="0"
              label="0:00-1:00电量(kW·h)"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="1"
              label="1:00-2:00电量（kW·h）"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="2"
              label="2:00-3:00电量（kW·h）"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="3"
              label="3:00-4:00电量（kW·h）"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="4"
              label="4:00-5:00电量（kW·h）"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="5"
              label="5:00-6:00电量（kW·h）"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="6"
              label="6:00-7:00电量（kW·h）"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="7"
              label="7:00-8:00电量（kW·h）"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="8"
              label="8:00-9:00电量（kW·h）"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="9"
              label="9:00-10:00电量（kW·h）"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="10"
              label="10:00-11:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="11"
              label="11:00-12:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="12"
              label="12:00-13:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="13"
              label="13:00-14:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="14"
              label="14:00-15:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="15"
              label="15:00-16:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="16"
              label="16:00-17:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="17"
              label="17:00-18:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="18"
              label="18:00-19:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="19"
              label="19:00-20:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="20"
              label="20:00-21:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="21"
              label="21:00-22:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="22"
              label="22:00-23:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="23"
              label="23:00-24:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
          </el-table>
          <!-- 月峰谷平尖表 -->
          <el-table
            :style="areshow2"
            :data="tableData2"
            border
            show-summary
            class="kuan"
            :cell-style="{ textAlign: 'center' }"
            :header-cell-style="{ textAlign: 'center' }"
          >
            <el-table-column fixed prop="deviceId" label="监测点名称" width="100">
            </el-table-column>
            <el-table-column prop="name1" label="总电量(kW.h)">
            </el-table-column>
            </el-table-column>
            <el-table-column prop="1hao" label="1日电量">
              <el-table-column prop="1haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="1haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="1haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="1haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="1haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="2hao" label="2日电量">
              <el-table-column prop="2haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="2haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="2haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="2haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="2haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="3hao" label="3日电量">
              <el-table-column prop="3haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="3haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="3haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="3haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="3haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="4hao" label="4日电量">
              <el-table-column prop="4haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="4haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="4haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="4haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="4haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="5hao" label="5日电量">
              <el-table-column prop="5haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="5haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="5haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="5haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="5haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="6hao" label="6日电量">
              <el-table-column prop="6haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="6haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="6haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="6haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="6haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="7hao" label="7日电量">
              <el-table-column prop="7haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="7haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="7haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="7haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="7haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="8hao" label="8日电量">
              <el-table-column prop="8haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="8haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="8haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="8haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="8haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="9hao" label="9日电量">
              <el-table-column prop="9haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="9haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="9haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="9haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="9haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="10hao" label="10日电量">
              <el-table-column prop="10haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="10haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="10haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="10haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="10haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="11hao" label="11日电量">
              <el-table-column prop="11haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="11haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="11haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="11haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="11haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="12hao" label="12日电量">
              <el-table-column prop="12haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="12haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="12haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="12haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="12haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="13hao" label="13日电量">
              <el-table-column prop="13haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="13haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="13haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="13haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="13haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="14hao" label="14日电量">
              <el-table-column prop="14haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="14haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="14haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="14haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="14haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="15hao" label="15日电量">
              <el-table-column prop="15haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="15haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="15haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="15haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="15haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="16hao" label="16日电量">
              <el-table-column prop="16haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="16haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="16haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="16haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="16haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="17hao" label="17日电量">
              <el-table-column prop="17haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="17haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="17haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="17haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="17haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="18hao" label="18日电量">
              <el-table-column prop="18haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="18haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="18haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="18haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="18haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="19hao" label="19日电量">
              <el-table-column prop="19haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="19haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="19haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="19haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="19haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="20hao" label="20日电量">
              <el-table-column prop="20haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="20haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="20haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="20haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="20haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="21hao" label="21日电量">
              <el-table-column prop="21haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="21haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="21haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="21haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="21haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="22hao" label="22日电量">
              <el-table-column prop="22haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="22haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="22haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="22haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="22haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="23hao" label="23日电量">
              <el-table-column prop="23haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="23haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="23haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="23haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="23haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="24hao" label="24日电量">
              <el-table-column prop="24haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="24haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="24haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="24haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="24haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="25hao" label="25日电量">
              <el-table-column prop="25haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="25haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="25haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="25haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="25haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="26hao" label="26日电量">
              <el-table-column prop="26haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="26haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="26haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="26haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="26haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="27hao" label="27日电量">
              <el-table-column prop="27haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="27haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="27haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="27haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="27haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="28hao" label="28日电量">
              <el-table-column prop="28haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="28haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="28haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="28haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="28haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="29hao" label="29日电量">
              <el-table-column prop="29haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="29haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="29haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="29haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="29haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="30hao" label="30日电量">
              <el-table-column prop="30haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="30haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="30haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="30haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="30haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
            <el-table-column prop="31hao" label="31日电量">
              <el-table-column prop="31haof" label="峰(kW·h)"> </el-table-column>
              <el-table-column prop="31haog" label="谷(kW·h)"> </el-table-column>
              <el-table-column prop="31haop" label="平(kW·h)"> </el-table-column>
              <el-table-column prop="31haoj" label="尖(kW·h)"> </el-table-column>
              <el-table-column prop="31haototal" label="小计(kW·h)">
              </el-table-column>
            </el-table-column>
          </el-table>
          <!-- 时刻电表 -->
          <el-table
            :style="areshow3"
            :data="tableData3"
            border
            class="kuan"
            :cell-style="{ textAlign: 'center' }"
            :header-cell-style="{ textAlign: 'center' }"
          >
            <el-table-column fixed prop="deviceId" label="监测点名称" width="100">
            </el-table-column>
            <el-table-column prop="Quantity3" label="电量(kW·h)">
            </el-table-column>
          </el-table>
          <!-- 月电量明细表 -->
          <el-table
            class="kuan"
            :style="areshow4"
            :data="tableData4"
            border
            :cell-style="{ textAlign: 'center' }"
            :header-cell-style="{ textAlign: 'center' }"
          >
            <el-table-column fixed prop="deviceId" label="监测点名称" width="100">
            </el-table-column>
            <el-table-column prop="1haoQuantity" label="1日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="2haoQuantity" label="2日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="3haoQuantity" label="3日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="4haoQuantity" label="4日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="5haoQuantity" label="5日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="6haoQuantity" label="6日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="7haoQuantity" label="7日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="8haoQuantity" label="8日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="9haoQuantity" label="9日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="10haoQuantity" label="10日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="11haoQuantity" label="11日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="12haoQuantity" label="12日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="13haoQuantity" label="13日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="14haoQuantity" label="14日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="15haoQuantity" label="15日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="16haoQuantity" label="16日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="17haoQuantity" label="17日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="18haoQuantity" label="18日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="19haoQuantity" label="19日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="20haoQuantity" label="20日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="21haoQuantity" label="21日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="22haoQuantity" label="22日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="23haoQuantity" label="23日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="24haoQuantity" label="24日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="25haoQuantity" label="25日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="26haoQuantity" label="26日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="27haoQuantity" label="27日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="28haoQuantity" label="28日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="29haoQuantity" label="29日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="30haoQuantity" label="30日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="31haoQuantity" label="31日电量(kW·h)">
            </el-table-column>
          </el-table>
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
//获取点击结点的值
import { toDaynodeData } from "@/components/ElectricEnergyAnalysis.vue";
import axios from "axios";

export default {
  name: "LineChart",
  data() {
    return {
      //选择框定义
      areshow0: "",
      areshow1: "display:none",
      areshow2: "display:none",
      areshow3: "display:none",
      areshow4: "display:none",
      data: [
        {
          id: 1,
          label: "电能管理体验馆",
          children: [
            {
              id: 2,
              label: "主变",
              children: [
                {
                  id: 3,
                  label: "1#空调柜2",
                },
                {
                  id: 4,
                  label: "3#动力柜",
                },
                {
                  id: 5,
                  label: "水处理系统",
                },
                {
                  id: 6,
                  label: "风机系统",
                },
                {
                  id: 7,
                  label: "冷却水塔",
                },
                {
                  id: 8,
                  label: "锅炉房",
                },
                {
                  id: 9,
                  label: "空调用水泵",
                },
                {
                  id: 10,
                  label: "2#冰水机",
                },
                {
                  id: 11,
                  label: "高压空压机",
                },
                {
                  id: 12,
                  label: "2#空调柜",
                },
                {
                  id: 13,
                  label: "低压空压机",
                },
                {
                  id: 14,
                  label: "1#冰水机",
                },
                {
                  id: 15,
                  label: "传输系统",
                },
                {
                  id: 16,
                  label: "1#动力柜",
                  children: [
                    {
                      id: 17,
                      label: "1#插座电源",
                    },
                    {
                      id: 18,
                      label: "2#插座电源",
                    },
                  ],
                },
              ],
            },
          ],
        },
      ],
      defaultProps: {
        children: "children",
        label: "label",
      },
      content: toDaynodeData,
      //后端数据容器
      TABLEdata: [], //图表
      //曲线选择
      options: [
        {
          value: "峰谷平尖电量统计",
        },
        {
          value: "日电量明细",
        },
        {
          value: "月峰谷平尖明细",
        },
        {
          value: "时刻电量统计",
        },
        {
          value: "月电量明细",
        },
        {
          value: "自定义日统计",
        },
      ],
      //曲线参数
      value2: "峰谷平尖电量统计",
      //日期选择器
      value3: "",
      value4: "",
      value5: "",
      value6: "",
      value7: "",
      //A相B相选择池
      checkList: [],
      //时间参数
      value1: "",
      disabledDate(time) {
        return time.getTime() > Date.now();
      },

      tableData0: [],
      tableData1: [],
      tableData2: [],
      tableData3: [],
      tableData4: [],
    };
  },

  created() {
    //  this.convert();
  },
  mounted() {
    // echarts设置选项
  },

  methods: {
    //树选择
    handleCheckChange(data, checked) {
      console.log(data, checked);
      if (checked == true) {
      }
    },
    // handleNodeClick(data) {
    //   console.log(data);
    // },
    //打印PDF
    handleCommand(command) {
      if (command == "a") {
        this.getPdf();
      }
    },
    //下拉框选择
    changeTable() {
      //this.convert()

      if (this.value2 == "峰谷平尖电量统计") {
        //负荷变量赋值
        //选择框赋值

        (this.areshow0 = ""),
          (this.areshow1 = "display:none"),
          (this.areshow2 = "display:none"),
          (this.areshow3 = "display:none"),
          (this.areshow4 = "display:none");
        let n = 0;
        // while (n < this.TABLEdata.length) {
          // while (n < 16) {
          //   this.tableData0.push({
          //     deviceId: "",
          //     Totalquantity0: "",
          //     Totalcharge0: "",
          //     TQuantity0: "",
          //     TCharge0: "",
          //     LQuantity0: "",
          //     LCharge0: "",
          //     NQuantity0: "",
          //     NCharge0: "",
          //     HQuantity0: "",
          //     HCharge0: "",
          //   });
          //   n = n + 1;
          // }
        this.tableData0[0].deviceId = "主变";
        this.tableData0[1].deviceId = "1#空调柜2";
        this.tableData0[2].deviceId = "3#动力柜";
        this.tableData0[3].deviceId = "水处理系统";
        this.tableData0[4].deviceId = "风机系统2";
        this.tableData0[5].deviceId = "冷却水塔";
        this.tableData0[6].deviceId = "锅炉房";
        this.tableData0[7].deviceId = "空调用水泵";
        this.tableData0[8].deviceId = "2#冰水机";
        this.tableData0[9].deviceId = "高压空压机";
        this.tableData0[10].deviceId = "低压空压机";
        this.tableData0[11].deviceId = "1#冰水机";
        this.tableData0[12].deviceId = "传输系统";
        this.tableData0[13].deviceId = "1#动力柜";
        this.tableData0[14].deviceId = "1#插座电源";
        this.tableData0[15].deviceId = "2#插座电源";

        // while (i < this.TABLEdata.length) {
        // while (i < 16) {
        //   this.tableData0[i].frequency6 = this.TABLEdata[i].frequencyDeviation;
        //   this.tableData0[i].A6 = this.TABLEdata[i].ia;
        //   this.tableData0[i].B6 = this.TABLEdata[i].ib;
        //   this.tableData0[i].C6 = this.TABLEdata[i].ic;
        //   this.tableData0[i].Uab6 = this.TABLEdata[i].uab;
        //   this.tableData0[i].Ubc6 = this.TABLEdata[i].ubc;
        //   this.tableData0[i].Uca6 = this.TABLEdata[i].uca;
        //   i = i + 1;
        // }
      } else if (this.value2 == "日电量明细") {
        //给无功功率赋值
        //选择框赋值
        this.areshow0 = "display:none";
        this.areshow1 = "";
        this.areshow2 = "display:none";
        this.areshow3 = "display:none";
        this.areshow4 = "display:none";
        let n = 0;
        // while (n < this.TABLEdata.length) {
          // while (n < 16) {
          //   this.tableData1.push({
          //     deviceId: "",
          //     Totalquantity0: "",
          //     Totalcharge0: "",
          //     TQuantity0: "",
          //     TCharge0: "",
          //     LQuantity0: "",
          //     LCharge0: "",
          //     NQuantity0: "",
          //     NCharge0: "",
          //     HQuantity0: "",
          //     HCharge0: "",
          //   });
          //   n = n + 1;
          // }
        this.tableData1[0].deviceId = "主变";
        this.tableData1[1].deviceId = "1#空调柜2";
        this.tableData1[2].deviceId = "3#动力柜";
        this.tableData1[3].deviceId = "水处理系统";
        this.tableData1[4].deviceId = "风机系统2";
        this.tableData1[5].deviceId = "冷却水塔";
        this.tableData1[6].deviceId = "锅炉房";
        this.tableData1[7].deviceId = "空调用水泵";
        this.tableData1[8].deviceId = "2#冰水机";
        this.tableData1[9].deviceId = "高压空压机";
        this.tableData1[10].deviceId = "低压空压机";
        this.tableData1[11].deviceId = "1#冰水机";
        this.tableData1[12].deviceId = "传输系统";
        this.tableData1[13].deviceId = "1#动力柜";
        this.tableData1[14].deviceId = "1#插座电源";
        this.tableData1[15].deviceId = "2#插座电源";

      } else if (this.value2 == "月峰谷平尖明细") {
        //给功率因数赋值
        //选择框赋值
        (this.areshow0 = "display:none"),
          (this.areshow1 = "display:none"),
          (this.areshow2 = ""),
          (this.areshow3 = "display:none"),
          (this.areshow4 = "display:none");

            let n = 0;
        // while (n < this.TABLEdata.length) {
          // while (n < 16) {
          //   this.tableData2.push({
          //     deviceId: "",
          //     Totalquantity0: "",
          //     Totalcharge0: "",
          //     TQuantity0: "",
          //     TCharge0: "",
          //     LQuantity0: "",
          //     LCharge0: "",
          //     NQuantity0: "",
          //     NCharge0: "",
          //     HQuantity0: "",
          //     HCharge0: "",
          //   });
          //   n = n + 1;
          // }

        this.tableData2[0].deviceId = "主变";
        this.tableData2[1].deviceId = "1#空调柜2";
        this.tableData2[2].deviceId = "3#动力柜";
        this.tableData2[3].deviceId = "水处理系统";
        this.tableData2[4].deviceId = "风机系统2";
        this.tableData2[5].deviceId = "冷却水塔";
        this.tableData2[6].deviceId = "锅炉房";
        this.tableData2[7].deviceId = "空调用水泵";
        this.tableData2[8].deviceId = "2#冰水机";
        this.tableData2[9].deviceId = "高压空压机";
        this.tableData2[10].deviceId = "低压空压机";
        this.tableData2[11].deviceId = "1#冰水机";
        this.tableData2[12].deviceId = "传输系统";
        this.tableData2[13].deviceId = "1#动力柜";
        this.tableData2[14].deviceId = "1#插座电源";
        this.tableData2[15].deviceId = "2#插座电源";

      } else if (this.value2 == "时刻电量统计") {
        //给电流赋值
        //选择框赋值
        (this.areshow0 = "display:none"),
          (this.areshow1 = "display:none"),
          (this.areshow2 = "display:none"),
          (this.areshow3 = ""),
          (this.areshow4 = "display:none");
            let n = 0;
        // while (n < this.TABLEdata.length) {
          // while (n < 16) {
          //   this.tableData3.push({
          //     deviceId: "",
          //     Totalquantity0: "",
          //     Totalcharge0: "",
          //     TQuantity0: "",
          //     TCharge0: "",
          //     LQuantity0: "",
          //     LCharge0: "",
          //     NQuantity0: "",
          //     NCharge0: "",
          //     HQuantity0: "",
          //     HCharge0: "",
          //   });
          //   n = n + 1;
          // }

        this.tableData3[0].deviceId = "主变";
        this.tableData3[1].deviceId = "1#空调柜2";
        this.tableData3[2].deviceId = "3#动力柜";
        this.tableData3[3].deviceId = "水处理系统";
        this.tableData3[4].deviceId = "风机系统2";
        this.tableData3[5].deviceId = "冷却水塔";
        this.tableData3[6].deviceId = "锅炉房";
        this.tableData3[7].deviceId = "空调用水泵";
        this.tableData3[8].deviceId = "2#冰水机";
        this.tableData3[9].deviceId = "高压空压机";
        this.tableData3[10].deviceId = "低压空压机";
        this.tableData3[11].deviceId = "1#冰水机";
        this.tableData3[12].deviceId = "传输系统";
        this.tableData3[13].deviceId = "1#动力柜";
        this.tableData3[14].deviceId = "1#插座电源";
        this.tableData3[15].deviceId = "2#插座电源";

      } else if (this.value2 == "月电量明细") {
        //给电压赋值
        //选择框赋值
        (this.areshow0 = "display:none"),
          (this.areshow1 = "display:none"),
          (this.areshow2 = "display:none"),
          (this.areshow3 = "display:none"),
          (this.areshow4 = "");
            let n = 0;
        // while (n < this.TABLEdata.length) {
          // while (n < 16) {
          //   this.tableData4.push({
          //     deviceId: "",
          //     Totalquantity0: "",
          //     Totalcharge0: "",
          //     TQuantity0: "",
          //     TCharge0: "",
          //     LQuantity0: "",
          //     LCharge0: "",
          //     NQuantity0: "",
          //     NCharge0: "",
          //     HQuantity0: "",
          //     HCharge0: "",
          //   });
          //   n = n + 1;
          // }

        this.tableData4[0].deviceId = "主变";
        this.tableData4[1].deviceId = "1#空调柜2";
        this.tableData4[2].deviceId = "3#动力柜";
        this.tableData4[3].deviceId = "水处理系统";
        this.tableData4[4].deviceId = "风机系统2";
        this.tableData4[5].deviceId = "冷却水塔";
        this.tableData4[6].deviceId = "锅炉房";
        this.tableData4[7].deviceId = "空调用水泵";
        this.tableData4[8].deviceId = "2#冰水机";
        this.tableData4[9].deviceId = "高压空压机";
        this.tableData4[10].deviceId = "低压空压机";
        this.tableData4[11].deviceId = "1#冰水机";
        this.tableData4[12].deviceId = "传输系统";
        this.tableData4[13].deviceId = "1#动力柜";
        this.tableData4[14].deviceId = "1#插座电源";
        this.tableData4[15].deviceId = "2#插座电源";

      }
    },

    convert() {
      //请求表格数据
      axios
        .post(
          "http://121.43.111.195/powerRealtime/findPowerDistributionDayByDataTime",
          {
            id: 16,
            deviceId: "1",
            dataTime: "1638892801",
          }
        )
        .then((response) => {
          console.log(1);

          this.tableData0 = response.data;
          this.changeTable()
          console.log(response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>


<style scoped>
#title {
  background-color: rgb(219, 219, 219);
}
.el-aside {
  height: 1030px;
}
.kuan {
  width: 100%;
}
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
#inaside {
  background-color: rgb(241, 241, 239);
}
</style>
