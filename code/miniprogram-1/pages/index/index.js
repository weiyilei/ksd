// index.js
Page({
  data:{
    user:{}
  },
  onShow:function(){
    const user = wx.getStorageSync('user')
    this.setData({user:user})
  }
})
