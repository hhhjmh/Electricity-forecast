<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
<script>
  // 阻止放缩带来的页面结构布局变化
  import DevicePixelRatio from './assets/js/devicePixelRatio.js';
  export default {
    name: "App",
    created() {
      new DevicePixelRatio().init();
  	},
    mounted () {
        window.onresize = () => {
          return (() => {
            this.detectZoom()
          })()
        };
    },
    methods:{
        detectZoom (){
          var ratio = 0,
          screen = window.screen,
          ua = navigator.userAgent.toLowerCase();
          if (window.devicePixelRatio !== undefined) {
              ratio = window.devicePixelRatio;
          }
          else if (~ua.indexOf('msie')) {
            if (screen.deviceXDPI && screen.logicalXDPI) {
              ratio = screen.deviceXDPI / screen.logicalXDPI;
            }
          }
          else if (window.outerWidth !== undefined && window.innerWidth !== undefined) {
            ratio = window.outerWidth / window.innerWidth;
          }

          if (ratio){
            ratio = Math.round(ratio * 100);
          }
          //ratio就是获取到的百分比
          console.log(ratio)
          this.onresize_height = ratio
          // return ratio;
        },
    }
  };
</script>
