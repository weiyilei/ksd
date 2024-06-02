package com.kasuoda.bullyingsystem.campus_management.controller;


import com.kasuoda.bullyingsystem.BullyingsystemApplication;
import com.kasuoda.bullyingsystem.campus_management.entity.Record;
import com.kasuoda.bullyingsystem.campus_management.entity.RecordInput;
import com.kasuoda.bullyingsystem.campus_management.entity.RecordInputteacher;
import com.kasuoda.bullyingsystem.campus_management.service.RecordService;
import com.kasuoda.bullyingsystem.campus_management.service.impl.RecordServiceImpl;
import com.kasuoda.bullyingsystem.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "RecordController")
@RestController
public class RecordController {
  private static final Logger logger = LoggerFactory.getLogger(RecordController.class);
  @Autowired
  private RecordService recordService;


  @GetMapping(path = "/a")
  public void getAll(@RequestParam Integer id){
    Record getrecord = recordService.getRecord(id);
    return;
  }

  //上报霸凌信息的表单
  @PostMapping(path = "/submit_record")
  public R postrecord(@RequestBody RecordInput recordinput){
    logger.info("进入Controller 开始上报霸凌信息表单");
   return recordService.saveRecord(recordinput);
  }

  //：每个地点霸凌事件的个数
  @GetMapping(path = "/get_position_number")
  public  R getNumber(){
    logger.info("进入Controller 每个地点霸凌事件的个数");
    return  recordService.locationNumber();
  }

  //点击地点，给出地点霸凌信息列表
 @GetMapping(path = "/bullyMessageByPosition")
  public  R getMessageByPostion(@RequestParam String position){
   logger.info("进入Controller 每个地点霸凌信息列表");
return recordService.getBullyMessageByLocation(position);
 }

@GetMapping(path = "/clickOnDetailInfo")
  public R getDetailInfoForTeacher(@RequestParam Integer recordid){
  logger.info("进入Controller 每个地点选中的霸凌行为的详细信息展示");
    return recordService.getDetailInfoForTeacher(recordid);
}

@PostMapping(path = "/teacherSolve")
  public  R getTeacherSolve(@RequestBody RecordInputteacher input){
  logger.info("进入Controller 老师开始对每个地点选中的霸凌行为的打开处理");
    return recordService.cardingsolve(input.getRecordid(),input.getTeachermsg());
}
}
