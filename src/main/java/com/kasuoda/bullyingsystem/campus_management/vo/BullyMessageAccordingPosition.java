package com.kasuoda.bullyingsystem.campus_management.vo;


import lombok.Data;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Data
public class BullyMessageAccordingPosition {
  private List<Integer> student =new LinkedList<>();
  private String bully_time;
  private  String layer;
  private  String detail_position;
  private Integer id;
}
