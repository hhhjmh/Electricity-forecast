
// 达到在不同设备宽度下对应不同的基准值，动态计算不同屏幕下的不同根元素的字体大小
const baseSize = 16
function setRem() {
  const scale = document.documentElement.clientWidth / 1920
  document.documentElement.style.fontSize = baseSize * scale + 'px'
}
setRem()
window.onresize = function () {
  setRem()
}
