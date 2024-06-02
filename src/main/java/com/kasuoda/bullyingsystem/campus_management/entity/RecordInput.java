package com.kasuoda.bullyingsystem.campus_management.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordInput {
  private  String layer;
  //楼层 选填
  private  String location;
  //地点  必填

  private  String detailPosition;
  //详细地址 选填

  private String bullyTime;
  //霸凌时间  选填

  private Integer  recorderId;
  //上报表单的人的id  必填

  private  String accountType;
  // 上报填写表单的人的类型  必填

  private List<Integer> studentId;
  // 被霸凌的学生的id 必填

  private  String  info;
  //  详细信息 字符串 类型。  选填
}
