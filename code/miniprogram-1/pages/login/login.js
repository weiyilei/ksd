// pages/login/login.js
import { request } from "../../request/index"

Page({
  data: {
    telephone:"",
    password:"",
    checked:false
  },
  onChange(event) {
    this.setData({
      checked: event.detail,
    });
  },
  login(){
    let data = {
      telephone:this.data.telephone,
      password:this.data.password
    }
    if(this.data.checked){
      request({
        url:"/teacherUser/login",
        method:"POST",
        data:data
      }).then(res => {
        if (res){
          let loginAccount = {
            id:res.id,
            name:res.name,
            password:res.password,
            telephone:res.telephone,
            type:res.type
          }
          wx.setStorageSync("user", loginAccount);
          wx.showToast({
            title: '登录成功',
            icon:"success"
          })
          setTimeout(() => {
            wx.navigateTo({
              url: "../index/index",
            })
          }, 1000)
        }else{
          wx.showToast({
            title: '登录失败',
            icon:"error"
          })
        }
      })
    }
    else{
      request({
        url:"/parentUser/login",
        method:"POST",
        data:data
      }).then(res => {
        if (res){
          let loginAccount = {
            id:res.id,
            name:res.name,
            password:res.password,
            telephone:res.telephone,
            type:res.type
          }
          wx.setStorageSync("user", loginAccount);
          wx.showToast({
            title: '登录成功',
            icon:"success"
          })
          setTimeout(() => {
            wx.navigateTo({
              url: "../index/index",
            })
          }, 1000)
        }else{
          wx.showToast({
            title: '登录失败',
            icon:"error"
          })
        }
      })
    }
  }
})