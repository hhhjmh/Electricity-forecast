<!-- 月报分析APP-->
<template>
  <div>
    <!-- APP按钮 -->
    <div class="buttonBackground" id="btn_normal">
      <button type="text" @click="centerDialogVisible = true"></button>
      <p>月报分析</p>
    </div>
    <el-row :gutter="10">
      <el-col :xs="4" :sm="6" :md="8" :lg="9" :xl="11"
        ><div class="grid-content bg-purple-light">
          <el-dialog
            title="月报分析"
            :visible.sync="centerDialogVisible"
            width="72%"
            :close-on-click-modal="false"
            :modal="false"
            center
            v-dialogDrag
            @opened="open()"
          >
            <div class="container">
              <div class="block">
                <span class="demonstration">选择月份：</span>
                <el-date-picker
                  v-model="value2"
                  value-format="yyyy-MM"
                  type="month"
                  placeholder="选择月"
                >
                </el-date-picker>
                <!-- <el-button type="primary" plain size="medium" @click="search"
            >查询</el-button
          > -->
                <el-dropdown>
                  <el-button type="primary" size="medium">
                    目录<i class="el-icon-arrow-down el-icon--right"></i>
                  </el-button>
                  <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item
                      ><a href="#0" style="text-decoration: none"
                        >一、经济用电</a
                      ></el-dropdown-item
                    >
                    <el-dropdown-item
                      ><a href="#1" style="text-decoration: none"
                        >1.1 电费电量使用情况</a
                      ></el-dropdown-item
                    >
                    <el-dropdown-item
                      ><a href="#2" style="text-decoration: none"
                        >1.2 电费电量统计表</a
                      ></el-dropdown-item
                    >
                    <el-dropdown-item
                      ><a href="#3" style="text-decoration: none"
                        >1.3 设备功率因数分析</a
                      ></el-dropdown-item
                    >
                    <el-dropdown-item
                      ><a href="#4" style="text-decoration: none"
                        >二、安全用电</a
                      ></el-dropdown-item
                    >
                    <el-dropdown-item
                      ><a href="#5" style="text-decoration: none"
                        >2.1 变压器运行情况</a
                      ></el-dropdown-item
                    >
                    <el-dropdown-item
                      ><a href="#6" style="text-decoration: none"
                        >三、洁净用电</a
                      ></el-dropdown-item
                    >
                    <el-dropdown-item
                      ><a href="#7" style="text-decoration: none"
                        >3.1 三相不平衡</a
                      ></el-dropdown-item
                    >
                    <el-dropdown-item
                      ><a href="#8" style="text-decoration: none"
                        >3.2 谐波畸变率</a
                      ></el-dropdown-item
                    >
                    <el-dropdown-item
                      ><a href="#9" style="text-decoration: none"
                        >3.3 频率偏差 电压偏差</a
                      ></el-dropdown-item
                    >
                  </el-dropdown-menu>
                </el-dropdown>
                <el-dropdown>
                  <el-button type="primary" size="medium">
                    导出<i class="el-icon-arrow-down el-icon--right"></i>
                  </el-button>
                  <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item>Word</el-dropdown-item>
                    <el-dropdown-item></el-dropdown-item>
                    <el-dropdown-item></el-dropdown-item>
                    <el-dropdown-item></el-dropdown-item>
                    <el-dropdown-item></el-dropdown-item>
                  </el-dropdown-menu>
                </el-dropdown>
              </div>
            </div>
            <h3 id="0">一、经济用电</h3>
            <h4 id="1">1.1 电费电量使用情况</h4>
            <div style="border-style: solid; border-width: 1px">
              <h2 style="text-align: center">
                电能管理体验馆--月电量统计({{ value2 }})
              </h2>
              <el-dropdown
                @command="handleCommand"
                size="mini"
                split-button
                type="primary"
              >
                打印和导出
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item v-print="'#myChart'">
                    打印图表</el-dropdown-item
                  >
                  <!-- <el-dropdown-item>导出PNG格式图片</el-dropdown-item>
            <el-dropdown-item>导出JPEG格式图片</el-dropdown-item> -->
                  <el-dropdown-item command="a">导出PDF文档</el-dropdown-item>
                  <!-- <el-dropdown-item>导出SVG矢量图片</el-dropdown-item> -->
                </el-dropdown-menu>
              </el-dropdown>
              <div
                class="echart"
                id="myChart"
                :style="{ width: '1500px', height: '500px' }"
              ></div>
              <h2 style="text-align: center">
                电能管理体验馆--月电费统计({{ value2 }})
              </h2>
              <el-dropdown
                @command="handleCommand"
                size="mini"
                split-button
                type="primary"
              >
                打印和导出
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item v-print="'#myChart1'"
                    >打印图表</el-dropdown-item
                  >
                  <!-- <el-dropdown-item>导出PNG格式图片</el-dropdown-item>
            <el-dropdown-item>导出JPEG格式图片</el-dropdown-item> -->
                  <el-dropdown-item command="b">导出PDF文档</el-dropdown-item>
                  <!-- <el-dropdown-item>导出SVG矢量图片</el-dropdown-item> -->
                </el-dropdown-menu>
              </el-dropdown>
              <div
                class="echart"
                id="myChart1"
                :style="{ width: '1500px', height: '500px' }"
              ></div>
            </div>
            <h4 id="2">1.2 电费电量统计表</h4>
            <el-table
              :data="tableData1"
              border
              show-summary
              style="width: 100%"
              :cell-style="{ textAlign: 'center' }"
              :header-cell-style="{ textAlign: 'center' }"
            >
              <el-table-column prop="id" label="设备名称" width="180">
              </el-table-column>
              <el-table-column prop="name" label="总电量(kW.h)">
              </el-table-column>
              <el-table-column prop="amount1" label="峰">
                <el-table-column prop="Quantity1" label="峰电量(kW.h)">
                </el-table-column>
                <el-table-column prop="Charge1" label="峰电费(元)">
                </el-table-column>
              </el-table-column>
              <el-table-column prop="amount2" label="谷">
                <el-table-column prop="Quantity2" label="谷电量(kW.h)">
                </el-table-column>
                <el-table-column prop="Charge2" label="谷电费(元)">
                </el-table-column>
              </el-table-column>
              <el-table-column prop="amount3" label="平">
                <el-table-column prop="Quantity3" label="峰平电量(kW.h)">
                </el-table-column>
                <el-table-column prop="Charge3" label="平电费(元)">
                </el-table-column>
              </el-table-column>
              <el-table-column prop="amount3" label="尖">
                <el-table-column prop="Quantity4" label="尖电量(kW.h)">
                </el-table-column>
                <el-table-column prop="Charge4" label="尖电费(元)">
                </el-table-column>
              </el-table-column>
            </el-table>
            <h4 id="3">1.3 设备功率因数分析</h4>
            <el-table
              :data="tableData2"
              style="width: 100%"
              :header-cell-style="{ textAlign: 'center' }"
              :cell-style="{ textAlign: 'center' }"
            >
              <el-table-column prop="name2" label="设备名称" width="300">
              </el-table-column>
              <el-table-column prop="current2" label="月平均电流（A）">
                <el-table-column prop="A2" label="A"> </el-table-column>
                <el-table-column prop="B2" label="B"> </el-table-column>
                <el-table-column prop="C2" label="C"> </el-table-column>
              </el-table-column>
              <el-table-column prop="D2" label="月平均功率"> </el-table-column>
            </el-table>
            <h3 id="4">二、安全用电</h3>
            <h4 id="5">2.1 变压器运行情况</h4>
            <el-table
              :data="tableData3"
              border
              style="width: 100%"
              :cell-style="{ textAlign: 'center' }"
              :header-cell-style="{ textAlign: 'center' }"
            >
              <el-table-column prop="date" label="设备名称" width="180">
              </el-table-column>
              <el-table-column prop="name" label="额定容量(kVA)">
              </el-table-column>
              <el-table-column prop="name" label="月平均负荷(kW)">
              </el-table-column>
              <el-table-column prop="name" label="月最大负荷(kW)">
              </el-table-column>
              <el-table-column prop="name" label="平均功率因数">
              </el-table-column>
              <el-table-column prop="name" label="平均负荷率(%)">
              </el-table-column>
              <el-table-column prop="name" label="平均负载率(%)">
              </el-table-column>
              <el-table-column prop="address" label="最大负载率(%)">
              </el-table-column>
            </el-table>
            <h3 id="6">三、洁净用电</h3>
            <h4 id="7">3.1 三相不平衡</h4>
            <el-table
              :data="tableData4"
              style="width: 100%"
              :cell-style="{ textAlign: 'center' }"
              :header-cell-style="{ textAlign: 'center' }"
            >
              <el-table-column prop="name4" label="设备名称" width="150">
              </el-table-column>
              <el-table-column prop=" current4" label="月平均电流（A）">
                <el-table-column prop="A4" label="A"> </el-table-column>
                <el-table-column prop="B4" label="B"> </el-table-column>
                <el-table-column prop="C4" label="C"> </el-table-column>
                <el-table-column prop="Z4" label="Z"> </el-table-column>
              </el-table-column>
              <el-table-column prop=" voltage4" label="月平均线电压（V）">
                <el-table-column prop="Uab4" label="Uab"> </el-table-column>
                <el-table-column prop="Ubc4" label="Ubc"> </el-table-column>
                <el-table-column prop="Uca4" label="Uca"> </el-table-column>
              </el-table-column>
              <el-table-column
                prop="currentunbalance4"
                label="三相电流不平衡度(%)"
                width="200"
              >
              </el-table-column>
              <el-table-column
                prop="voltageunbalance4"
                label="三相电压不平衡度(%)"
                width="200"
              >
              </el-table-column>
            </el-table>
            <h4 id="8">3.2 谐波畸变率</h4>
            <el-table
              :data="tableData5"
              style="width: 100%"
              :cell-style="{ textAlign: 'center' }"
              :header-cell-style="{ textAlign: 'center' }"
            >
              <el-table-column prop="name5" label="设备名称" width="150">
              </el-table-column>
              <el-table-column
                prop="average5"
                label="月平均负荷（kW）"
                width="150"
              >
              </el-table-column>
              <el-table-column prop="current5" label="月平均电流（A）">
                <el-table-column prop="A5" label="A"> </el-table-column>
                <el-table-column prop="B5" label="B"> </el-table-column>
                <el-table-column prop="C5" label="C"> </el-table-column>
              </el-table-column>
              <el-table-column prop="THDcurrent" label="谐波电流畸变率（%）">
                <el-table-column prop="THDcurrentA" label="A">
                </el-table-column>
                <el-table-column prop="THDcurrentB" label="B">
                </el-table-column>
                <el-table-column prop="THDcurrentC" label="C">
                </el-table-column>
              </el-table-column>
              <el-table-column prop="THDvoltage" label="谐波电压畸变率（%）">
                <el-table-column prop="THDvoltageA" label="A">
                </el-table-column>
                <el-table-column prop="THDvoltageB" label="B">
                </el-table-column>
                <el-table-column prop="THDvoltageC" label="C">
                </el-table-column>
              </el-table-column>
            </el-table>
            <h4 id="9">3.3 频率偏差 电压偏差</h4>
            <el-table
              :data="tableData6"
              style="width: 100%"
              :cell-style="{ textAlign: 'center' }"
              :header-cell-style="{ textAlign: 'center' }"
            >
              <el-table-column prop="name6" label="设备名称" width="150">
              </el-table-column>
              <el-table-column prop="frequency6" label="频率偏差" width="150">
              </el-table-column>
              <el-table-column prop="amount1" label="相电压偏差">
                <el-table-column prop="A6" label="A"> </el-table-column>
                <el-table-column prop="B6" label="B"> </el-table-column>
                <el-table-column prop="C6" label="C"> </el-table-column>
              </el-table-column>
              <el-table-column prop="amount1" label="线电压偏差">
                <el-table-column prop="Uab6" label="Uab"> </el-table-column>
                <el-table-column prop="Ubc6" label="Ubc"> </el-table-column>
                <el-table-column prop="Uca6" label="Uca"> </el-table-column>
              </el-table-column>
            </el-table>
          </el-dialog></div
      ></el-col>
    </el-row>
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
<style scope>
a:link {
  font-size: 12px;
  color: #000000;
  text-decoration: none;
}
a:visited {
  font-size: 12px;
  color: #000000;
  text-decoration: none;
}
a:hover {
  font-size: 12px;
  color: #999999;
  text-decoration: underline;
}
.echart {
  text-align: center;
}
/* 弹窗 */
#btn_bao {
  position: fixed;
  left: 15rem;
  top: 3rem;
  animation: flicker-in-1 1s linear both;
  animation-delay: 0.5s;
}

/* 弹窗按钮 */
.buttonBackground button {
  background-image: url(../assets/icon/monthReport.png);
}
.buttonBackground {
  left: 15rem;
  top: 8rem;
}
</style>
<script >
import axios from "axios";
export default {
  data() {
    return {
      tableData1: [],
      tableData2: [],
      tableData3: [],
      tableData4: [],
      tableData5: [],
      tableData6: [],
      //后端数据容器
      totaldata: [],
      TABLEdata: [],
      //电量图

      option1: {
        toolbox: {
          show: true,
          feature: {
            dataZoom: {
              yAxisIndex: "none",
            },
            dataView: {
              readOnly: false,
            },
            magicType: {
              type: ["line", "bar"],
            },
            restore: {},
            saveAsImage: {
              type: "png",
            },
          },
          showTitle: true,
        },
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "shadow",
          },
        },
        legend: {},
        grid: {
          // left: "3%",
          // right: "4%",
          // bottom: "3%",
          containLabel: true,
        },
        xAxis: {
          type: "category",
          data: [
            // "1号",
            // "2号",
            // "3号",
            // "4号",
            // "5号",
            // "6号",
            // "7号",
            // "8号",
            // "9号",
            // "10号",
            // "11号",
            // "12号",
            // "13号",
            // "14号",
            // "15号",
            // "16号",
            // "17号",
            // "18号",
            // "19号",
            // "20号",
            // "21号",
            // "22号",
            // "23号",
            // "24号",
            // "25号",
            // "26号",
            // "27号",
            // "28号",
            // "29号",
            // "30号",
            // "31号",
          ],
          name: "日期", // x轴名称
          interval: 6,
          nameTextStyle: {
            // x轴名称样式
            fontWeight: 600,
            fontSize: 18,
          },
        },

        yAxis: {
          type: "value",
          name: "KWh", // y轴名称
          nameTextStyle: {
            // y轴名称样式
            fontWeight: 600,
            fontSize: 18,
          },
        },

        series: [
          {
            name: "峰电量",
            type: "bar",
            stack: "Ad",
            emphasis: {
              focus: "series",
            },
            data: [],
          },
          {
            name: "谷电量",
            type: "bar",
            stack: "Ad",
            emphasis: {
              focus: "series",
            },
            data: [],
          },
          {
            name: "平电量",
            type: "bar",
            stack: "Ad",
            emphasis: {
              focus: "series",
            },
            data: [],
          },
          {
            name: "尖电量",
            type: "bar",
            stack: "Ad",
            emphasis: {
              focus: "series",
            },
            data: [],
          },
        ],
      },
      //电费图
      option2: {
        toolbox: {
          show: true,
          feature: {
            dataZoom: {
              yAxisIndex: "none",
            },
            dataView: {
              readOnly: false,
            },
            magicType: {
              type: ["line", "bar"],
            },
            restore: {},
            saveAsImage: {
              type: "png",
            },
          },
          showTitle: true,
        },
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "shadow",
          },
        },
        legend: {},
        grid: {
          containLabel: true,
        },
        xAxis: {
          type: "category",
          data: [
            // "1号",
            // "2号",
            // "3号",
            // "4号",
            // "5号",
            // "6号",
            // "7号",
            // "8号",
            // "9号",
            // "10号",
            // "11号",
            // "12号",
            // "13号",
            // "14号",
            // "15号",
            // "16号",
            // "17号",
            // "18号",
            // "19号",
            // "20号",
            // "21号",
            // "22号",
            // "23号",
            // "24号",
            // "25号",
            // "26号",
            // "27号",
            // "28号",
            // "29号",
            // "30号",
            // "31号",
          ],
          name: "日期", // x轴名称
          interval: 6,
          nameTextStyle: {
            // x轴名称样式
            fontWeight: 600,
            fontSize: 18,
          },
        },

        yAxis: [
          {
            type: "value",
            name: "费用", // y轴名称
            nameTextStyle: {
              // y轴名称样式
              fontWeight: 600,
              fontSize: 18,
            },
          },
        ],
        series: [
          {
            name: "峰电费",
            type: "bar",
            stack: "Ad",
            emphasis: {
              focus: "series",
            },
            data: [],
          },
          {
            name: "谷电费",
            type: "bar",
            stack: "Ad",
            emphasis: {
              focus: "series",
            },
            data: [],
          },
          {
            name: "平电费",
            type: "bar",
            stack: "Ad",
            emphasis: {
              focus: "series",
            },
            data: [],
          },
          {
            name: "尖电费",
            type: "bar",
            stack: "Ad",
            emphasis: {
              focus: "series",
            },
            data: [],
          },
        ],
      },

      htmlTitle: "月电量统计表",
      value2: "",
      value1: "",
      centerDialogVisible: false,
      activeName: "first",
      dialogTableVisible: false,
      dialogFormVisible: false,
      formLabelWidth: "120px",
    };
  },
  created() {
    this.convert();
  },
  mounted() {},
  methods: {
    //1.3
    gonglv() {
      let n = 0;
      // while (n < this.TABLEdata.length) {
      while (n < 16) {
        this.tableData2.push({
          name2: "",
          A2: "",
          B2: "",
          C2: "",
          D2: "",
        });
        n = n + 1;
      }
      // console.log(this.tableData4[0]);

      let i = 0;
      this.tableData2[0].name2 = "主变";
      this.tableData2[1].name2 = "1#空调柜2";
      this.tableData2[2].name2 = "3#动力柜";
      this.tableData2[3].name2 = "水处理系统";
      this.tableData2[4].name2 = "风机系统2";
      this.tableData2[5].name2 = "冷却水塔";
      this.tableData2[6].name2 = "锅炉房";
      this.tableData2[7].name2 = "空调用水泵";
      this.tableData2[8].name2 = "2#冰水机";
      this.tableData2[9].name2 = "高压空压机";
      this.tableData2[10].name2 = "低压空压机";
      this.tableData2[11].name2 = "1#冰水机";
      this.tableData2[12].name2 = "传输系统";
      this.tableData2[13].name2 = "1#动力柜";
      this.tableData2[14].name2 = "1#插座电源";
      this.tableData2[15].name2 = "2#插座电源";

      // while (i < this.TABLEdata.length) {
      while (i < 16) {
        this.tableData2[i].A2 = this.TABLEdata[i].ia;
        this.tableData2[i].B2 = this.TABLEdata[i].ib;
        this.tableData2[i].C2 = this.TABLEdata[i].ic;
        this.tableData2[i].D2 = this.TABLEdata[i].uab;

        i = i + 1;
      }
    },
    //3.1
    sanxiang() {
      let n = 0;
      // while (n < this.TABLEdata.length) {
      while (n < 16) {
        this.tableData4.push({
          name4: "",
          A4: "",
          B4: "",
          C4: "",
          Z4: "",
          Uab4: "",
          Ubc4: "",
          Uca4: "",
          currentunbalance4: "",
          voltageunbalance4: "",
        });
        n = n + 1;
      }
      // console.log(this.tableData4[0]);

      let i = 0;
      this.tableData4[0].name4 = "主变";
      this.tableData4[1].name4 = "1#空调柜2";
      this.tableData4[2].name4 = "3#动力柜";
      this.tableData4[3].name4 = "水处理系统";
      this.tableData4[4].name4 = "风机系统2";
      this.tableData4[5].name4 = "冷却水塔";
      this.tableData4[6].name4 = "锅炉房";
      this.tableData4[7].name4 = "空调用水泵";
      this.tableData4[8].name4 = "2#冰水机";
      this.tableData4[9].name4 = "高压空压机";
      this.tableData4[10].name4 = "低压空压机";
      this.tableData4[11].name4 = "1#冰水机";
      this.tableData4[12].name4 = "传输系统";
      this.tableData4[13].name4 = "1#动力柜";
      this.tableData4[14].name4 = "1#插座电源";
      this.tableData4[15].name4 = "2#插座电源";

      // while (i < this.TABLEdata.length) {
      while (i < 16) {
        this.tableData4[i].A4 = this.TABLEdata[i].ia;
        this.tableData4[i].B4 = this.TABLEdata[i].ib;
        this.tableData4[i].C4 = this.TABLEdata[i].ic;
        this.tableData4[i].Z4 = this.TABLEdata[i].zeroi;
        this.tableData4[i].Uab4 = this.TABLEdata[i].uab;
        this.tableData4[i].Ubc4 = this.TABLEdata[i].ubc;
        this.tableData4[i].Uca4 = this.TABLEdata[i].uca;
        // this.tableData4[i].currentunbalance4 =
        // this.tableData4[i].voltageunbalance4 =
        // console.log(this.TABLEdata[0].ia)
        i = i + 1;
      }
    },
    //3.2
    xiebo() {
      let n = 0;
      // while (n < this.TABLEdata.length) {
      while (n < 16) {
        this.tableData5.push({
          name5: "",
          A5: "",
          B5: "",
          C5: "",
          average5: "",
          THDcurrentA: "",
          THDcurrentB: "",
          THDcurrentC: "",
          THDvoltageA: "",
          THDvoltageB: "",
          THDvoltageC: "",
        });
        n = n + 1;
      }
      // console.log(this.tableData4[0]);

      let i = 0;
      this.tableData5[0].name5 = "主变";
      this.tableData5[1].name5 = "1#空调柜2";
      this.tableData5[2].name5 = "3#动力柜";
      this.tableData5[3].name5 = "水处理系统";
      this.tableData5[4].name5 = "风机系统2";
      this.tableData5[5].name5 = "冷却水塔";
      this.tableData5[6].name5 = "锅炉房";
      this.tableData5[7].name5 = "空调用水泵";
      this.tableData5[8].name5 = "2#冰水机";
      this.tableData5[9].name5 = "高压空压机";
      this.tableData5[10].name5 = "低压空压机";
      this.tableData5[11].name5 = "1#冰水机";
      this.tableData5[12].name5 = "传输系统";
      this.tableData5[13].name5 = "1#动力柜";
      this.tableData5[14].name5 = "1#插座电源";
      this.tableData5[15].name5 = "2#插座电源";

      // while (i < this.TABLEdata.length) {
      while (i < 16) {
        this.tableData5[i].A5 = this.TABLEdata[i].ia;
        this.tableData5[i].B5 = this.TABLEdata[i].ib;
        this.tableData5[i].C5 = this.TABLEdata[i].ic;
        this.tableData5[i].average5 = this.TABLEdata[i].totalLoad;
        // this.tableData4[i].Ubc4 = this.TABLEdata[i].ib;
        // this.tableData4[i].Uca4 = this.TABLEdata[i].ib;
        // this.tableData4[i].currentunbalance4 =
        // this.tableData4[i].voltageunbalance4 =
        // console.log(this.TABLEdata[0].ia)
        i = i + 1;
      }
    },
    //3.3
    piancha() {
      let n = 0;
      // while (n < this.TABLEdata.length) {
      while (n < 16) {
        this.tableData6.push({
          frequency6: "",
          name6: "",
          A6: "",
          B6: "",
          C6: "",
          Uab6: "",
          Ubc6: "",
          Uca6: "",
        });
        n = n + 1;
      }
      // console.log(this.tableData4[0]);

      let i = 0;
      this.tableData6[0].name6 = "主变";
      this.tableData6[1].name6 = "1#空调柜2";
      this.tableData6[2].name6 = "3#动力柜";
      this.tableData6[3].name6 = "水处理系统";
      this.tableData6[4].name6 = "风机系统2";
      this.tableData6[5].name6 = "冷却水塔";
      this.tableData6[6].name6 = "锅炉房";
      this.tableData6[7].name6 = "空调用水泵";
      this.tableData6[8].name6 = "2#冰水机";
      this.tableData6[9].name6 = "高压空压机";
      this.tableData6[10].name6 = "低压空压机";
      this.tableData6[11].name6 = "1#冰水机";
      this.tableData6[12].name6 = "传输系统";
      this.tableData6[13].name6 = "1#动力柜";
      this.tableData6[14].name6 = "1#插座电源";
      this.tableData6[15].name6 = "2#插座电源";

      // while (i < this.TABLEdata.length) {
      while (i < 16) {
        this.tableData6[i].frequency6 = this.TABLEdata[i].frequencyDeviation;
        this.tableData6[i].A6 = this.TABLEdata[i].ia;
        this.tableData6[i].B6 = this.TABLEdata[i].ib;
        this.tableData6[i].C6 = this.TABLEdata[i].ic;
        this.tableData6[i].Uab6 = this.TABLEdata[i].uab;
        this.tableData6[i].Ubc6 = this.TABLEdata[i].ubc;
        this.tableData6[i].Uca6 = this.TABLEdata[i].uca;
        i = i + 1;
      }
    },
    //echart赋值
    charge() {
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
        console.log(daytime);
        // console.log(this.totaldata.length)
        this.option1.xAxis.data[i] = daytime.substring(5, 10); //给X轴赋值
        this.option1.series[0].data[i] = this.totaldata[i].highKWh; //给峰电量赋值
        this.option1.series[1].data[i] = this.totaldata[i].lowKWh; //给谷电量赋值
        this.option1.series[2].data[i] = this.totaldata[i].midKWh; //给平电量赋值
        this.option1.series[3].data[i] = this.totaldata[i].topKWh; //给尖电量赋值

        this.option2.xAxis.data[i] = daytime.substring(5, 10); //给X轴赋值
        this.option2.series[0].data[i] = this.totaldata[i].highCharge; //给峰电费赋值
        this.option2.series[1].data[i] = this.totaldata[i].lowCharge; //给谷电费赋值
        this.option2.series[2].data[i] = this.totaldata[i].midCharge; //给平电费赋值
        this.option2.series[3].data[i] = this.totaldata[i].topCharge; //给尖电费赋值

        i = i + 1;
      }
    },
    // 打印导出
    handleCommand(command) {
      if (command == "a") this.getPdf();
      if (command == "b") this.getPdf1();
    },
    //数据写入
    convert() {
      axios
        .post(
          "http://114.213.210.219/powerRealtime/findPowerDistributionDayByDataTime",
          {
            deviceId: "1",
            dataTime: "1638288000",
          }
        )
        .then((response) => {
          this.totaldata = response.data;
          //console.log(this.totaldata.length)
          console.log(this.totaldata);
          this.charge();
        })
        .catch((error) => {
          console.log(error);
        });
      axios
        .post(
          "http://114.213.211.241/PowerAnalyse/findPowerAnalyseDayAvgByDataTime",
          {
            deviceId: "1",
            dataTime: "1638288000",
          }
        )
        .then((response) => {
          this.TABLEdata = response.data;
          console.log(this.TABLEdata);

          this.sanxiang();
          this.xiebo();
          this.gonglv();
          this.piancha();
        })
        .catch((error) => {
          console.log(error);
        });
    },
    //合计功能
    getSummaries(param) {
      const { columns, data } = param;
      const sums = [];
      columns.forEach((column, index) => {
        if (index === 0) {
          sums[index] = "总价";
          return;
        }
        const values = data.map((item) => Number(item[column.property]));
        if (!values.every((value) => isNaN(value))) {
          sums[index] = values.reduce((prev, curr) => {
            const value = Number(curr);
            if (!isNaN(value)) {
              return prev + curr;
            } else {
              return prev;
            }
          }, 0);
          sums[index] += " 元";
        } else {
          sums[index] = "N/A";
        }
      });

      return sums;
    },
    handleClick(tab, event) {
      console.log(tab, event);
    },
    //echart
    open() {
      console.log("open");
      this.draw();
      this.draw1();
    },
    draw() {
      // 初始化echarts实例
      let myChart = this.$echarts.init(document.getElementById("myChart"));
      // setTimeout(function () {
      //   window.onresize = function () {
      //     twChart.resize();
      //   };
      // }, 200);

      //防止越界，重绘canvas
      window.onresize = myChart.resize;
      myChart.setOption(this.option1); //设置option
    },

    draw1() {
      // 初始化echarts实例
      let myChart1 = this.$echarts.init(document.getElementById("myChart1"));
      // 绘制图表

      //防止越界，重绘canvas
      window.onresize = myChart1.resize;
      myChart1.setOption(this.option2); //设置option
    },
  },
};
</script>
