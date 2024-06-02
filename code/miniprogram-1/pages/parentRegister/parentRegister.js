// pages/login/login.js
import { request } from "../../request/index"

Page({
  data: {
    name:"",
    password:"",
    telephone:"",
    studentname:""
  },
  regist(){
    let parentUser = {
      name:this.data.name,
      password:this.data.password,
      telephone:this.data.telephone,
      type:"1"
    }
    let student = {
      name:this.data.studentname,
      type:"2"
    }
    var student_id = 0
    var parent_id
    request({
      url:"/parentUser/check",
      method:"POST",
      data:parentUser
    }).then(res => {
      if(res == "0"){
        request({
          url:"/student/check",
          method:"POST",
          data:student
        }).then(res => {
          if(res == "0"){
            wx.showToast({
              title: "学生不存在",
              icon:"error"
            })
          }
          else{
            student_id = res
            request({
              url:"/parentUser/register",
              method:"POST",
              data:parentUser
            }).then(res => {
              parent_id = res
              let studentParentRelationship = {
                parent_id:parent_id,
                student_id:student_id
              }
              console.log(studentParentRelationship)
              request({
                url:"/relationship/add",
                method:"POST",
                data:studentParentRelationship
              }).then(res => {})
              wx.showToast({
                title: "注册成功",
                icon:"success"
              })
            })
          }
        })
      }
      else{
        wx.showToast({
          title: "用户已存在",
          icon:"error"
        })
      }
    })
  }
})