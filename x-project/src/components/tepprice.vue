<!-- 月报分析APP-->
<template>
  <div>
    <!-- APP按钮 -->
    <div class="buttonBackground"id="btn_normal">
      <button   type="text" @click="centerDialogVisible = true"></button>
      <p>电量与电费分析</p>
    </div>
    </div>
</template>
<style src="../assets/css/button.css">


</style>
<style scoped>
 .buttonBackground button {
   
     background-image: url(../assets/icon/tep_price.png);
  }
  .buttonBackground {

    left: 48rem;
    top: 35rem;
  }
</style>

