// pages/login/login.js
import { request } from "../../request/index"

Page({
  data: {
    name:"",
    password:"",
    telephone:""
  },
  regist(){
    let teacherIndividual = {
      name:this.data.name,
      phonenumber:this.data.telephone
    }
    let teacherUser = {
      name:this.data.name,
      password:this.data.password,
      telephone:this.data.telephone,
      type:"0"
    }
    request({
      url:"/teacherInformation/get",
      method:"POST",
      data:teacherIndividual
    }).then(res => {
      console.log(res)
      if (res){
        request({
          url:"/teacherUser/register",
          method:"POST",
          data:teacherUser
        }).then(res => {
          if(res != "0"){
            wx.showToast({
              title:"注册成功",
              icon:"success"
            })
            setTimeout(() => {
              wx.navigateTo({
                url: "../login/login",
              })
            }, 1000)
          }
          else{
            wx.showToast({
              title: "用户已存在",
              icon:"error"
            })
          }
        })
      }else{
        wx.showToast({
          title: '教师信息不存在',
          icon:"error"
        })
      }
    })
  }
})