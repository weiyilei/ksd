package com.kasuoda.bullyingsystem.campus_management.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ParentRightNowRecord {

    private  String layer;
    private  String position;
    private  String roomType;
    private Timestamp recordTime;
    private String uploadPerson;
    private Timestamp bullyTime;
    private String parentMsg;
    private  String accountType;
    private  Integer state;
}
