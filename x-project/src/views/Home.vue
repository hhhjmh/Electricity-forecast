<template>
  <div class="home">
    <!-- 电能在线应用 -->
    <testDialog></testDialog>
    <baobiao></baobiao>
    <ElectricEnergyAnalysis></ElectricEnergyAnalysis>
 
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
import testDialog from '@/components/testDialog.vue'
import BgOfHome from '@/components/BgOfHome.vue'
import baobiao from '@/components/baobiao.vue'
import ElectricEnergyAnalysis from '../components/ElectricEnergyAnalysis.vue'


export default {
  name: 'Home',
  components: {
    testDialog,
    BgOfHome,
    baobiao,
    ElectricEnergyAnalysis,
   
  }
}
</script>
