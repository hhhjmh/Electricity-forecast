<!-- 月报分析APP-->
<template>
  <div>
    <!-- APP按钮 -->
    <div class="buttonBackground"id="btn_normal">
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
                :style="{ width: '100%', height: '500%' }"
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
              :data="tableData"
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
              :data="tableData"
              style="width: 100%"
              :header-cell-style="{ textAlign: 'center' }"
              :cell-style="{ textAlign: 'center' }"
            >
              <el-table-column prop="date" label="设备名称" width="300">
              </el-table-column>
              <el-table-column prop="amount1" label="月平均电流（A）">
                <el-table-column prop="A" label="A"> </el-table-column>
                <el-table-column prop="B" label="B"> </el-table-column>
                <el-table-column prop="C" label="C"> </el-table-column>
              </el-table-column>
              <el-table-column prop="C" label="月平均功率"> </el-table-column>
            </el-table>
            <h3 id="4">二、安全用电</h3>
            <h4 id="5">2.1 变压器运行情况</h4>
            <el-table
              :data="tableData"
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
              :data="tableData"
              style="width: 100%"
              :cell-style="{ textAlign: 'center' }"
              :header-cell-style="{ textAlign: 'center' }"
            >
              <el-table-column prop="date" label="设备名称" width="150">
              </el-table-column>
              <el-table-column prop="amount1" label="月平均电流（A）">
                <el-table-column prop="A" label="A"> </el-table-column>
                <el-table-column prop="B" label="B"> </el-table-column>
                <el-table-column prop="C" label="C"> </el-table-column>
                <el-table-column prop="D" label="D"> </el-table-column>
              </el-table-column>
              <el-table-column prop="amount1" label="月平均线电压（V）">
                <el-table-column prop="A" label="Uab"> </el-table-column>
                <el-table-column prop="B" label="Ubc"> </el-table-column>
                <el-table-column prop="C" label="Uca"> </el-table-column>
              </el-table-column>
              <el-table-column prop="C" label="三相电流不平衡度(%)" width="300">
              </el-table-column>
              <el-table-column prop="C" label="三相电压不平衡度(%)" width="300">
              </el-table-column>
            </el-table>
            <h4 id="8">3.2 谐波畸变率</h4>
            <el-table
              :data="tableData"
              style="width: 100%"
              :cell-style="{ textAlign: 'center' }"
              :header-cell-style="{ textAlign: 'center' }"
            >
              <el-table-column prop="name" label="设备名称" width="150">
              </el-table-column>
              <el-table-column prop="date" label="月平均负荷（kW）" width="150">
              </el-table-column>
              <el-table-column prop="amount1" label="月平均电流（A）">
                <el-table-column prop="A" label="A"> </el-table-column>
                <el-table-column prop="B" label="B"> </el-table-column>
                <el-table-column prop="C" label="C"> </el-table-column>
              </el-table-column>
              <el-table-column prop="amount1" label="谐波电流畸变率（%）">
                <el-table-column prop="A" label="A"> </el-table-column>
                <el-table-column prop="B" label="B"> </el-table-column>
                <el-table-column prop="C" label="C"> </el-table-column>
              </el-table-column>
              <el-table-column prop="amount1" label="谐波电压畸变率（%）">
                <el-table-column prop="A" label="A"> </el-table-column>
                <el-table-column prop="B" label="B"> </el-table-column>
                <el-table-column prop="C" label="C"> </el-table-column>
              </el-table-column>
            </el-table>
            <h4 id="9">3.3 频率偏差 电压偏差</h4>
            <el-table
              :data="tableData"
              style="width: 100%"
              :cell-style="{ textAlign: 'center' }"
              :header-cell-style="{ textAlign: 'center' }"
            >
              <el-table-column prop="name" label="设备名称" width="150">
              </el-table-column>
              <el-table-column prop="date" label="频率偏差" width="150">
              </el-table-column>
              <el-table-column prop="amount1" label="相电压偏差">
                <el-table-column prop="A" label="A"> </el-table-column>
                <el-table-column prop="B" label="B"> </el-table-column>
                <el-table-column prop="C" label="C"> </el-table-column>
              </el-table-column>
              <el-table-column prop="amount1" label="线电压偏差">
                <el-table-column prop="A" label="Uab"> </el-table-column>
                <el-table-column prop="B" label="Ubc"> </el-table-column>
                <el-table-column prop="C" label="Uca"> </el-table-column>
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
      //后端数据容器
      totaldata: [],
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
      tableData: [
        {
          data: "",
          name: "",
          address: "",
        },
      ],
      value2: "",
      value1: "",
      centerDialogVisible: false,
      activeName: "first",
      dialogTableVisible: false,
      dialogFormVisible: false,
      form: {
        name: "",
        region: "",
        date1: "",
        date2: "",
        delivery: false,
        type: [],
        resource: "",
        desc: "",
      },
      formLabelWidth: "120px",
    };
  },
  created() {
    this.convert();
  },
  methods: {
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
