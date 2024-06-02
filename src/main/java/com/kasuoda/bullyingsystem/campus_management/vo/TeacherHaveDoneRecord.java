package com.kasuoda.bullyingsystem.campus_management.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TeacherHaveDoneRecord {

    private  String layer;
    private  String position;
    private  String roomType;
    private Timestamp recordTime;
    private String uploadPerson;
    private Timestamp bullyTime;
    private String parentMsg;
    private  String accountType;
    private  Integer state;
    private String teacherMsg;
    private String dealPerson;
    private Boolean isBully;
    private Integer level;
}
