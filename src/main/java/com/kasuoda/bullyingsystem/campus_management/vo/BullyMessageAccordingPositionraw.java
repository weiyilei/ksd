package com.kasuoda.bullyingsystem.campus_management.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BullyMessageAccordingPositionraw {
  private Integer studentId;
  private String bullyTime;
  private  String layer;
  private  String detailPosition;
  private Integer id;
}
