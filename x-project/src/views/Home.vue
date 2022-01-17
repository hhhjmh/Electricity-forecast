<template>
  <div class="home">
    <!-- 电能在线应用 -->
    <baobiao></baobiao>
    <electric-energy-analysis></electric-energy-analysis>
    <appstore></appstore>
    <setting></setting>
    <bianji></bianji>
    <category-compare></category-compare>
    <cityload></cityload>
    <colormeter></colormeter>
    <electricitysituation></electricitysituation>
    <drrun></drrun>
    <energycount></energycount>
    <equipment></equipment>
    <fgptime></fgptime>
    <jiedianjiance></jiedianjiance>
    <machineshop></machineshop>
    <online-stream></online-stream>
    <online-water></online-water>
    <pline></pline>
    <product></product>
    <relation-analyse></relation-analyse>
    <report></report>
    <safe></safe>
    <station></station>
    <statistical-analysis></statistical-analysis>
    <scadadraw></scadadraw>
    <scadashow></scadashow>
    <shift></shift>
    <steam></steam>
    <sysmsg></sysmsg>
    <tepprice></tepprice>
    <time-compare></time-compare>
    <water-month></water-month>
    <water></water>
    <water-count></water-count>
    <yongqifenxi></yongqifenxi>
    <yongqishishi></yongqishishi>
    
    


    <!-- 背景板 -->
    <div id="BgOfHome"><BgOfHome></BgOfHome></div>
  </div>
</template>
<style>
  #BgOfHome{
    position: fixed;
    left: 0;
    top: 0;
    right: 0;
    bottom: 0;
    z-index: -5;
  }
</style>
<script>
// @ is an alias to /src

import BgOfHome from '@/components/BgOfHome.vue'
import baobiao from '@/components/baobiao.vue'
import ElectricEnergyAnalysis from '../components/ElectricEnergyAnalysis.vue'
import Appstore from '../components/appstore.vue'
import setting from '../components/setting.vue'
import CategoryCompare from '../components/categoryCompare.vue'
import Bianji from '../components/bianji.vue'
import Cityload from '../components/cityload.vue'
import Colormeter from '../components/colormeter.vue'
import Drrun from '../components/drrun.vue'
import Electricitysituation from '../components/electricitysituation.vue'
import Energycount from '../components/energycount.vue'
import equipment from '../components/equipment.vue'
import Fgptime from '../components/fgptime.vue'
import Jiedianjiance from '../components/jiedianjiance.vue'
import Machineshop from '../components/machineshop.vue'
import OnlineStream from '../components/onlineStream.vue'
import OnlineWater from '../components/onlineWater.vue'
import Pline from '../components/pline.vue'
import Product from '../components/product.vue'
import RelationAnalyse from '../components/relationAnalyse.vue'
import Report from '../components/report.vue'
import Safe from '../components/safe.vue'
import Station from '../components/station.vue'
import StatisticalAnalysis from '../components/statisticalAnalysis.vue'
import Scadadraw from '../components/scadadraw.vue'
import Scadashow from '../components/scadashow.vue'
import Shift from '../components/shift.vue'
import Steam from '../components/steam.vue'
import Sysmsg from '../components/sysmsg.vue'
import Tepprice from '../components/tepprice.vue'
import TimeCompare from '../components/timeCompare.vue'
import WaterMonth from '../components/waterMonth.vue'
import Water from '../components/water.vue'
import WaterCount from '../components/waterCount.vue'
import Yongqifenxi from '../components/yongqifenxi.vue'
import Yongqishishi from '../components/yongqishishi.vue'



export default {
  name: 'Home',
  components: {

    BgOfHome,
    baobiao,
    ElectricEnergyAnalysis,
    Appstore,
    setting,
    CategoryCompare,
    Bianji,
    Cityload,
    Colormeter,
    Drrun,
    Electricitysituation,
    Energycount,
    equipment,
    Fgptime,
    Machineshop,
    OnlineStream,
    OnlineWater,
    Pline,
    Product,
    RelationAnalyse,
    Report,
    Jiedianjiance,
    Safe,
    Station,
    StatisticalAnalysis,
    Scadadraw,
    Scadashow,
    Shift,
    Steam,
    Sysmsg,
    TimeCompare,
    WaterMonth,
    Water,
    WaterCount,
    Yongqifenxi,
    Yongqishishi,
    Tepprice
   
  }
}
</script>,
    Tepprice