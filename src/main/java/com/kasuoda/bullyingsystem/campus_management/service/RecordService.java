package com.kasuoda.bullyingsystem.campus_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kasuoda.bullyingsystem.campus_management.entity.Record;
import com.kasuoda.bullyingsystem.campus_management.entity.RecordInput;
import com.kasuoda.bullyingsystem.util.R;


public interface RecordService extends IService<Record> {


  Record getRecord(Integer id);


  R saveRecord(RecordInput input);

  R  locationNumber();

  R getBullyMessageByLocation(String location);

  R getDetailInfoForTeacher(Integer id);

   R cardingsolve(Integer id,String teachermsg);
}
