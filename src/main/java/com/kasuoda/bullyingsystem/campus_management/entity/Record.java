package com.kasuoda.bullyingsystem.campus_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
  @Id
  private  Integer id;

  private  String layer;

  private  String location;

  private  String detailPosition;

  private Timestamp bully_time;

  private  Timestamp record_time;

  private Integer  submit_id;

  private  String accountType;
  //发生事件的类型，1为家长上报事件，2为机器检测事件

  private  Integer state;

  private  String teacherMsg;
  //老师处理后的回执信息


  private String parentMsg;
  //上报时事件的具体信息

  private  Integer deal_id;
  //处理时间的老师ID
  private  boolean is_bully;
  // 是否为霸凌行为
}
