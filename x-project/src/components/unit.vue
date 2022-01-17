<template>
  <div>
    <el-container>
      <el-aside id="inaside" width="240px">
        <el-tree
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
          <!-- 日电量日期选择器 -->
          <el-date-picker
            :style="areshow0"
            value-format="yyyy-MM-dd"
            v-model="value4"
            type="date"
            placeholder="选择日期"
          >
          </el-date-picker>
          <!-- 月选择器 -->
          <el-date-picker
            :style="areshow1"
            v-model="value5"
            type="month"
            placeholder="选择月"
          >
          </el-date-picker>
          <!-- 年选择器 -->
          <el-date-picker
            :style="areshow2"
            v-model="value3"
            type="year"
            placeholder="选择年"
          >
          </el-date-picker>

          <el-button type="primary" plain size="medium" @click="changeTable()"
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
          <!-- 日电量表 -->
          <el-table
            :style="areshow0"
            :data="tableData"
            border
            class="kuan"
            :cell-style="{ textAlign: 'center' }"
            :header-cell-style="{ textAlign: 'center' }"
          >
            <el-table-column fixed prop="date" label="监测点名称" width="180">
            </el-table-column>
            <el-table-column
              prop="name"
              label="0:00-1:00电量(kW·h)"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="1:00-2:00电量（kW·h）"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="2:00-3:00电量（kW·h）"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="3:00-4:00电量（kW·h）"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="4:00-5:00电量（kW·h）"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="5:00-6:00电量（kW·h）"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="6:00-7:00电量（kW·h）"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="7:00-8:00电量（kW·h）"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="8:00-9:00电量（kW·h）"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="9:00-10:00电量（kW·h）"
              width="120"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="10:00-11:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="11:00-12:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="12:00-13:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="13:00-14:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="14:00-15:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="15:00-16:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="16:00-17:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="17:00-18:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="18:00-19:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="19:00-20:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="20:00-21:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="21:00-22:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="22:00-23:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="23:00-24:00电量（kW·h）"
              width="130"
            >
            </el-table-column>
          </el-table>
          <!-- 月电量明细表 -->
          <el-table
            class="kuan"
            :style="areshow1"
            :data="tableData"
            border
            :cell-style="{ textAlign: 'center' }"
            :header-cell-style="{ textAlign: 'center' }"
          >
            <el-table-column fixed prop="name" label="监测点名称" width="180">
            </el-table-column>
            <el-table-column prop="Quantity1" label="1日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity2" label="2日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="3日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="4日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="5日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="6日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="7日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="8日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="9日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="10日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="11日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="12日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="13日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="14日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="15日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="16日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="17日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="18日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="19日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="20日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="21日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="22日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="23日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="24日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="25日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="26日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="27日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="1日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="28日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="29日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="30日电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="31日电量(kW·h)">
            </el-table-column>
          </el-table>
          <!-- 月电量明细表 -->
          <el-table
            class="kuan"
            :style="areshow2"
            :data="tableData"
            border
            :cell-style="{ textAlign: 'center' }"
            :header-cell-style="{ textAlign: 'center' }"
          >
            <el-table-column fixed prop="name" label="监测点名称" width="180">
            </el-table-column>
            <el-table-column prop="Quantity1" label="1月电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity2" label="2月电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="3月电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="4月电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="5月电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="6月电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="7月电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="8月电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="9月电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="10月电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="11月电量(kW·h)">
            </el-table-column>
            <el-table-column prop="Quantity1" label="12月电量(kW·h)">
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
      data: [
        {
          id: 1,
          label: "电能管理体验馆",
          children: [
            {
              id: 2,
              label: "车间总",
              children: [
                {
                  id: 3,
                  label: "产线2",
                  children: [
                    {
                      id: 4,
                      label: "3#动力柜",
                    },
                    {
                      id: 5,
                      label: "风机系统",
                    },
                  ],
                },
              ],
            },
            {
              id: 6,
              label: "公共设备",
              children: [
                {
                  id: 7,
                  label: "冰机",
                  children: [
                    {
                      id: 8,
                      label: "1#空调柜2",
                    },
                    {
                      id: 8,
                      label: "空调用水泵",
                    },
                    {
                      id: 8,
                      label: "2#冰水机",
                    },
                    {
                      id: 8,
                      label: "2#空调柜",
                    },
                    {
                      id: 9,
                      label: "1#冰水机",
                    },
                  ],
                },
                {
                  id: 7,
                  label: "空压机",
                  children: [
                    {
                      id: 8,
                      label: "高压空压机",
                    },
                    {
                      id: 8,
                      label: "低压空压机",
                    },
                  ],
                },
              ],
            },
            {
              id: 2,
              label: "变压器",
              children: [
                {
                  id: 3,
                  label: "主变",
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
      totaldata: [], //图表
      tableAvgData: [], //表格
      tableMaxData: [],
      tableMinData: [],
      //曲线选择
      options: [
        {
          value: "日电量明细",
        },
        {
          value: "月电量明细",
        },
        {
          value: "年电量明细",
        },
        {
          value: "自定义日统计",
        },
      ],
      //曲线参数
      value2: "日电量明细",
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
      tableData: [],
    };
  },

  created() {
    this.convert();
  },
  mounted() {
    // echarts设置选项
  },

  methods: {
    //打印PDF
    handleCommand(command) {
      if (command == "a") {
        this.getPdf();
      }
    },
    //下拉框选择
    changeTable() {
      //this.convert()

      if (this.value2 == "日电量明细") {
        //负荷变量赋值
        //选择框赋值

        (this.areshow0 = ""),
          (this.areshow1 = "display:none"),
          (this.areshow2 = "display:none"),
          (this.areshow3 = "display:none");

        let i = 0;
        while (i < this.totaldata.length) {
          //时间戳变量转化成时间变量
          var date = new Date(
            this.totaldata[i].dataTime * 1000 + 8 * 3600 * 1000
          );
          var daytime = date
            .toJSON()
            .substr(0, 19)
            .replace("T", " ")
            .replace(/-/g, ".");

          this.echartsOption.xAxis.data[i] = daytime.substring(10, 16); //给X轴赋值
          this.echartsOption.series[0].data[i] = this.totaldata[i].aLoad; //给A相负荷赋值
          this.echartsOption.series[1].data[i] = this.totaldata[i].bLoad; //给B相负荷赋值
          this.echartsOption.series[2].data[i] = this.totaldata[i].cLoad; //给C相负荷赋值
          this.echartsOption.series[3].data[i] = this.totaldata[i].totalLoad; //给总体负荷赋值
          i = i + 1;
        }
      } else if (this.value2 == "月电量明细") {
        //给无功功率赋值
        //选择框赋值
        this.areshow0 = "display:none";
        this.areshow1 = "";
        this.areshow2 = "display:none";
        this.areshow3 = "display:none";

        let i = 0;
        while (i < this.totaldata.length) {
          //时间戳变量转化成时间变量
          var date = new Date(
            this.totaldata[i].dataTime * 1000 + 8 * 3600 * 1000
          );
          var daytime = date
            .toJSON()
            .substr(0, 19)
            .replace("T", " ")
            .replace(/-/g, ".");

          this.echartsOption.xAxis.data[i] = daytime.substring(10, 16); //给X轴赋值
          this.echartsOption.series[0].data[i] =
            this.totaldata[i].aReactivePower; //给A相无功功率赋值
          this.echartsOption.series[1].data[i] =
            this.totaldata[i].bReactivePower; //给B相无功功率赋值
          this.echartsOption.series[2].data[i] =
            this.totaldata[i].cReactivePower; //给C相无功功率赋值
          this.echartsOption.series[3].data[i] =
            this.totaldata[i].totalReactivePower; //给总体无功功率赋值
          i = i + 1;
        }
      } else if (this.value2 == "年电量明细") {
        //给功率因数赋值
        //选择框赋值
        (this.areshow0 = "display:none"),
          (this.areshow1 = "display:none"),
          (this.areshow2 = ""),
          (this.areshow3 = "display:none");

        let i = 0;
        while (i < this.totaldata.length) {
          //时间戳变量转化成时间变量
          var date = new Date(
            this.totaldata[i].dataTime * 1000 + 8 * 3600 * 1000
          );
          var daytime = date
            .toJSON()
            .substr(0, 19)
            .replace("T", " ")
            .replace(/-/g, ".");

          this.echartsOption.xAxis.data[i] = daytime.substring(10, 16); //给X轴赋值
          this.echartsOption.series[0].data[i] = this.totaldata[i].aPowerFactor; //给A相功率因数赋值
          this.echartsOption.series[1].data[i] = this.totaldata[i].bPowerFactor; //给B相功率因数赋值
          this.echartsOption.series[2].data[i] = this.totaldata[i].cPowerFactor; //给C相功率因数赋值
          this.echartsOption.series[3].data[i] =
            this.totaldata[i].totalPowerFactor; //给总体功率因数赋值
          i = i + 1;
        }
      }
    },

    //将输入时间戳转化为年月日时分秒的字符串（2022.01.05 03:35:00）中间的空格为/t是两位
    changeTime(A) {
      var date = new Date(A * 1000 + 8 * 3600 * 1000);
      var B = date.toJSON().substr(0, 19).replace("T", " ").replace(/-/g, ".");
      return B;
    },

    //按钮组的显示定义
    fhclick() {
      this.changeBG = [1, 0, 0, 0, 0, 0, 0, 0, 0];
      this.cleanTable();
      this.tableData[0].message = "总负荷(kW)";
      this.tableData[1].message = "A相负荷(kW)";
      this.tableData[2].message = "B相负荷(kW)";
      this.tableData[3].message = "C相负荷(kW)";

      this.tableData[0].average = this.tableAvgData.totalLoad;
      this.tableData[1].average = this.tableAvgData.aLoad;
      this.tableData[2].average = this.tableAvgData.bLoad;
      this.tableData[3].average = this.tableAvgData.cLoad;

      this.tableData[0].maxValue = this.tableMaxData.totalLoad;
      this.tableData[1].maxValue = this.tableMaxData.aLoad;
      this.tableData[2].maxValue = this.tableMaxData.bLoad;
      this.tableData[3].maxValue = this.tableMaxData.cLoad;

      this.tableData[0].minValue = this.tableMinData.totalLoad;
      this.tableData[1].minValue = this.tableMinData.aLoad;
      this.tableData[2].minValue = this.tableMinData.bLoad;
      this.tableData[3].minValue = this.tableMinData.cLoad;

      this.tableData[0].maxTime = this.changeTime(
        this.tableMaxData.totalLoadTime
      );
      this.tableData[1].maxTime = this.changeTime(this.tableMaxData.aLoadTime);
      this.tableData[2].maxTime = this.changeTime(this.tableMaxData.bLoadTime);
      this.tableData[3].maxTime = this.changeTime(this.tableMaxData.cLoadTime);

      this.tableData[0].minTime = this.changeTime(
        this.tableMinData.totalLoadTime
      );
      this.tableData[1].minTime = this.changeTime(this.tableMinData.aLoadTime);
      this.tableData[2].minTime = this.changeTime(this.tableMinData.bLoadTime);
      this.tableData[3].minTime = this.changeTime(this.tableMinData.cLoadTime);
    },
    wgglclick() {
      this.changeBG = [0, 1, 0, 0, 0, 0, 0, 0, 0];
      this.cleanTable();
      this.tableData[0].message = "总无功(kVar)";
      this.tableData[1].message = "A相无功(kVar)";
      this.tableData[2].message = "B相无功(kVar)";
      this.tableData[3].message = "C相无功(kVar)";

      this.tableData[0].average = this.tableAvgData.totalReactivePower;
      this.tableData[1].average = this.tableAvgData.aReactivePower;
      this.tableData[2].average = this.tableAvgData.bReactivePower;
      this.tableData[3].average = this.tableAvgData.cReactivePower;

      this.tableData[0].maxValue = this.tableMaxData.totalReactivePower;
      this.tableData[1].maxValue = this.tableMaxData.aReactivePower;
      this.tableData[2].maxValue = this.tableMaxData.bReactivePower;
      this.tableData[3].maxValue = this.tableMaxData.cReactivePower;

      this.tableData[0].minValue = this.tableMinData.totalReactivePower;
      this.tableData[1].minValue = this.tableMinData.aReactivePower;
      this.tableData[2].minValue = this.tableMinData.bReactivePower;
      this.tableData[3].minValue = this.tableMinData.cReactivePower;

      this.tableData[0].maxTime = this.changeTime(
        this.tableMaxData.totalReactivePowerTime
      );
      this.tableData[1].maxTime = this.changeTime(
        this.tableMaxData.aReactivePowerTime
      );
      this.tableData[2].maxTime = this.changeTime(
        this.tableMaxData.bReactivePowerTime
      );
      this.tableData[3].maxTime = this.changeTime(
        this.tableMaxData.cReactivePowerTime
      );

      this.tableData[0].minTime = this.changeTime(
        this.tableMinData.totalReactivePowerTime
      );
      this.tableData[1].minTime = this.changeTime(
        this.tableMinData.aReactivePowerTime
      );
      this.tableData[2].minTime = this.changeTime(
        this.tableMinData.bReactivePowerTime
      );
      this.tableData[3].minTime = this.changeTime(
        this.tableMinData.cReactivePowerTime
      );
    },
    glysclick() {
      this.changeBG = [0, 0, 1, 0, 0, 0, 0, 0, 0];
      this.cleanTable();
      this.tableData[0].message = "总功率因数";
      this.tableData[1].message = "A相功率因数";
      this.tableData[2].message = "B相功率因数";
      this.tableData[3].message = "C相功率因数";

      this.tableData[0].average = this.tableAvgData.totalPowerFactor;
      this.tableData[1].average = this.tableAvgData.aPowerFactor;
      this.tableData[2].average = this.tableAvgData.bPowerFactor;
      this.tableData[3].average = this.tableAvgData.cPowerFactor;

      this.tableData[0].maxValue = this.tableMaxData.totalPowerFactor;
      this.tableData[1].maxValue = this.tableMaxData.aPowerFactor;
      this.tableData[2].maxValue = this.tableMaxData.bPowerFactor;
      this.tableData[3].maxValue = this.tableMaxData.cPowerFactor;

      this.tableData[0].minValue = this.tableMinData.totalPowerFactor;
      this.tableData[1].minValue = this.tableMinData.aPowerFactor;
      this.tableData[2].minValue = this.tableMinData.bPowerFactor;
      this.tableData[3].minValue = this.tableMinData.cPowerFactor;

      this.tableData[0].maxTime = this.changeTime(
        this.tableMaxData.totalPowerFactorTime
      );
      this.tableData[1].maxTime = this.changeTime(
        this.tableMaxData.aPowerFactorTime
      );
      this.tableData[2].maxTime = this.changeTime(
        this.tableMaxData.bPowerFactorTime
      );
      this.tableData[3].maxTime = this.changeTime(
        this.tableMaxData.cPowerFactorTime
      );

      this.tableData[0].minTime = this.changeTime(
        this.tableMinData.totalPowerFactorTime
      );
      this.tableData[1].minTime = this.changeTime(
        this.tableMinData.aPowerFactorTime
      );
      this.tableData[2].minTime = this.changeTime(
        this.tableMinData.bPowerFactorTime
      );
      this.tableData[3].minTime = this.changeTime(
        this.tableMinData.cPowerFactorTime
      );
    },
    dlclick() {
      this.changeBG = [0, 0, 0, 1, 0, 0, 0, 0, 0];
      this.cleanTable();
      this.tableData[0].message = "A相电流(A)";
      this.tableData[1].message = "B相电流(A)";
      this.tableData[2].message = "C相电流(A)";
      this.tableData[3].message = "零线电流(A)";

      this.tableData[0].average = this.tableAvgData.ia;
      this.tableData[1].average = this.tableAvgData.ib;
      this.tableData[2].average = this.tableAvgData.ic;
      this.tableData[3].average = this.tableAvgData.zeroi;

      this.tableData[0].maxValue = this.tableMaxData.ia;
      this.tableData[1].maxValue = this.tableMaxData.ib;
      this.tableData[2].maxValue = this.tableMaxData.ic;
      this.tableData[3].maxValue = this.tableMaxData.zeroi;

      this.tableData[0].minValue = this.tableMinData.ia;
      this.tableData[1].minValue = this.tableMinData.ib;
      this.tableData[2].minValue = this.tableMinData.ic;
      this.tableData[3].minValue = this.tableMinData.zeroi;

      this.tableData[0].maxTime = this.changeTime(this.tableMaxData.iaTime);
      this.tableData[1].maxTime = this.changeTime(this.tableMaxData.ibTime);
      this.tableData[2].maxTime = this.changeTime(this.tableMaxData.icTime);
      this.tableData[3].maxTime = this.changeTime(this.tableMaxData.zeroiTime);

      this.tableData[0].minTime = this.changeTime(this.tableMinData.iaTime);
      this.tableData[1].minTime = this.changeTime(this.tableMinData.ibTime);
      this.tableData[2].minTime = this.changeTime(this.tableMinData.icTime);
      this.tableData[3].minTime = this.changeTime(this.tableMinData.zeroiTime);
    },
    dyclick() {
      this.changeBG = [0, 0, 0, 0, 1, 0, 0, 0, 0];
      //由于电压页面有6个所以需要重新定义表格
      this.tableData = [
        {
          message: "",
          average: "",
          maxValue: "",
          maxTime: "",
          minValue: "",
          minTime: "",
        },
        {
          message: "",
          average: "",
          maxValue: "",
          maxTime: "",
          minValue: "",
          minTime: "",
        },
        {
          message: "",
          average: "",
          maxValue: "",
          maxTime: "",
          minValue: "",
          minTime: "",
        },
        {
          message: "",
          average: "",
          maxValue: "",
          maxTime: "",
          minValue: "",
          minTime: "",
        },
        {
          message: "",
          average: "",
          maxValue: "",
          maxTime: "",
          minValue: "",
          minTime: "",
        },
        {
          message: "",
          average: "",
          maxValue: "",
          maxTime: "",
          minValue: "",
          minTime: "",
        },
      ];

      this.tableData[0].message = "A相电压(V)";
      this.tableData[1].message = "B相电压(V)";
      this.tableData[2].message = "C相电压(V)";
      this.tableData[3].message = "Uab线电压(V)";
      this.tableData[4].message = "Ubc线电压(V)";
      this.tableData[5].message = "Uca线电压(V)";

      this.tableData[0].average = this.tableAvgData.ua;
      this.tableData[1].average = this.tableAvgData.ub;
      this.tableData[2].average = this.tableAvgData.uc;
      this.tableData[3].average = this.tableAvgData.uab;
      this.tableData[4].average = this.tableAvgData.ubc;
      this.tableData[5].average = this.tableAvgData.uca;

      this.tableData[0].maxValue = this.tableMaxData.ua;
      this.tableData[1].maxValue = this.tableMaxData.ub;
      this.tableData[2].maxValue = this.tableMaxData.uc;
      this.tableData[3].maxValue = this.tableMaxData.uab;
      this.tableData[4].maxValue = this.tableMaxData.ubc;
      this.tableData[5].maxValue = this.tableMaxData.uca;

      this.tableData[0].minValue = this.tableMinData.ua;
      this.tableData[1].minValue = this.tableMinData.ub;
      this.tableData[2].minValue = this.tableMinData.uc;
      this.tableData[3].minValue = this.tableMinData.uab;
      this.tableData[4].minValue = this.tableMinData.ubc;
      this.tableData[5].minValue = this.tableMinData.uca;

      this.tableData[0].maxTime = this.changeTime(this.tableMaxData.uaTime);
      this.tableData[1].maxTime = this.changeTime(this.tableMaxData.ubTime);
      this.tableData[2].maxTime = this.changeTime(this.tableMaxData.ucTime);
      this.tableData[3].maxTime = this.changeTime(this.tableMaxData.uabTime);
      this.tableData[4].maxTime = this.changeTime(this.tableMaxData.ubcTime);
      this.tableData[5].maxTime = this.changeTime(this.tableMaxData.ucaTime);

      this.tableData[0].minTime = this.changeTime(this.tableMinData.uaTime);
      this.tableData[1].minTime = this.changeTime(this.tableMinData.ubTime);
      this.tableData[2].minTime = this.changeTime(this.tableMinData.ucTime);
      this.tableData[3].minTime = this.changeTime(this.tableMinData.uabTime);
      this.tableData[4].minTime = this.changeTime(this.tableMinData.ubcTime);
      this.tableData[5].minTime = this.changeTime(this.tableMinData.ucaTime);
    },
    dlxbclick() {
      this.changeBG = [0, 0, 0, 0, 0, 1, 0, 0, 0];
    },
    dyxbclick() {
      this.changeBG = [0, 0, 0, 0, 0, 0, 1, 0, 0];
    },
    dypcclick() {
      this.changeBG = [0, 0, 0, 0, 0, 0, 0, 1, 0];
    },
    sxclick() {
      this.changeBG = [0, 0, 0, 0, 0, 0, 0, 0, 1];
    },

    convert() {
      //请求图表数据
      axios
        .post(
          "http://114.213.210.219/powerRealtime/findPowerRealtimeByDataTime",
          {
            deviceId: "1",
            dataTime: "1640534400",
          }
        )
        .then((response) => {
          this.totaldata = response.data;
          //console.log(this.totaldata.length)
          console.log(this.changeTime(1640679300));
          console.log(this.totaldata);
          this.changeLine();
        })
        .catch((error) => {
          console.log(error);
        });

      //请求表格数据
      axios
        .post("http://114.213.211.241/PowerAnalyse/DayAvg", {
          deviceId: "1",
          dataTime: "1641312000",
        })
        .then((response) => {
          this.tableAvgData = response.data;
          console.log(this.tableAvgData);
          this.fhclick();
        })
        .catch((error) => {
          console.log(error);
        });

      axios
        .post("http://114.213.211.241/PowerAnalyse/DayMax", {
          deviceId: "1",
          dataTime: "1641312000",
        })
        .then((response) => {
          this.tableMaxData = response.data;
          console.log(this.tableMaxData);
          this.fhclick();
        })
        .catch((error) => {
          console.log(error);
        });

      axios
        .post("http://114.213.211.241/PowerAnalyse/DayMin", {
          deviceId: "1",
          dataTime: "1641312000",
        })
        .then((response) => {
          this.tableMinData = response.data;
          console.log(this.tableMinData);
          this.fhclick();
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
