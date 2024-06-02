package com.kasuoda.bullyingsystem.campus_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kasuoda.bullyingsystem.campus_management.controller.RecordController;
import com.kasuoda.bullyingsystem.campus_management.dao.RecordMapper;
import com.kasuoda.bullyingsystem.campus_management.dao.RecordStudentMapper;
import com.kasuoda.bullyingsystem.campus_management.entity.Record;
import com.kasuoda.bullyingsystem.campus_management.entity.RecordInput;
import com.kasuoda.bullyingsystem.campus_management.entity.RecordStudent;
import com.kasuoda.bullyingsystem.campus_management.service.RecordService;
import com.kasuoda.bullyingsystem.campus_management.vo.BullyMessageAccordingPosition;
import com.kasuoda.bullyingsystem.campus_management.vo.BullyMessageAccordingPositionraw;
import com.kasuoda.bullyingsystem.campus_management.vo.PositionRecordNumber;
import com.kasuoda.bullyingsystem.util.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper,Record> implements RecordService {


  @Autowired
  RecordMapper recordMapper;

  @Autowired
  RecordStudentMapper  recordStudentMapper;


  private static final Logger logger = LoggerFactory.getLogger(RecordServiceImpl.class);

  @Override
  public Record getRecord(Integer id) {
    return null;
  }

  @Override
  public R saveRecord(RecordInput input) {
    Integer getmaxid = recordMapper.getrecordmaxid();
    System.out.println(getmaxid);
    Record sample = new Record();
    if (getmaxid != null && getmaxid != 0) {
      getmaxid += 1;
    } else {
      getmaxid = 1;
    }
    sample.setId(getmaxid);
    if (input.getLayer() == null || input.getLayer().equals("")) {
      sample.setLayer("");
    } else {
      sample.setLayer(input.getLayer());
    }

    if (input.getLocation() == null || input.getLocation().equals("")) {
      return new R(false, "location 地点为空");
    } else {
      sample.setLocation(input.getLocation());
    }

    if (input.getDetailPosition() == null || input.getDetailPosition().equals("")) {
      sample.setDetailPosition("");
    } else {
      sample.setDetailPosition(input.getDetailPosition());
    }

    if (input.getBullyTime() == null || input.getBullyTime().equals("")) {
      sample.setBully_time(Timestamp.valueOf("2000-01-01 00:00:00"));
    } else {
      sample.setBully_time(Timestamp.valueOf(input.getBullyTime()));
    }

    sample.setRecord_time(new Timestamp(System.currentTimeMillis()));

    if (input.getRecorderId() == null) {
      logger.info("Service层 上报霸凌信息的结果返回");
      return new R(false, "上报者id为空");
    } else {
      sample.setSubmit_id(input.getRecorderId());
    }

    if (input.getAccountType() == null || input.getAccountType().equals("")) {
      logger.info("Service层 上报霸凌信息的结果返回");
      return new R(false, "上报者身份未知");
    } else {
      sample.setAccountType(input.getAccountType());
    }


    if (input.getInfo() == null || input.getInfo().equals("")) {
      sample.setParentMsg("");
    } else {
      sample.setParentMsg(input.getInfo());
    }
    sample.setState(1);
    //不相关的默认

    sample.setTeacherMsg("");
    sample.setParentMsg("");
    sample.setDeal_id(-1);
    sample.set_bully(true);
    //recorddao.insertrecord(sample);  变量名对应
    recordMapper.insert(sample);


    for (int i = 0; i < input.getStudentId().size(); i++) {
      RecordStudent r = new RecordStudent();
      r.setRecordId(getmaxid);
      if (input.getStudentId().get(i) <= 0) {
        //给一些限制
//        recorddao.deleteRecord(getmaxid);
        recordMapper.deleteById(getmaxid);
        logger.info("Service层 上报霸凌信息的结果返回");
        return new R(false, "举报id不对");
      }
      r.setStudentId(input.getStudentId().get(i));
     recordStudentMapper.insert(r);
    }
    logger.info("Service层 上报霸凌信息的结果返回");
    return new R(true);
  }

  @Override
  public R locationNumber() {
    PositionRecordNumber positionRecordNumber=new PositionRecordNumber();
    HashMap<String,Integer> hashMap=new HashMap<>();
    String[] location={"第一教学楼","第二教学楼","第三教学楼","第一科研楼","琳恩图书馆","一丹图书馆","涵泳图书馆"};
    for (int i=0;i<location.length;i++){
      Integer recordNumberByPosition = recordMapper.getRecordNumberByPosition(location[i]);
      hashMap.put(location[i],recordNumberByPosition);
    }
    positionRecordNumber.setPositionNumber(hashMap);
    logger.info("Service层 每个地点霸凌事件的个数的结果返回");
    return new R(true,positionRecordNumber);
  }

  @Override
  public R getBullyMessageByLocation(String location) {
    List<BullyMessageAccordingPosition> result=new LinkedList<>();
    List<BullyMessageAccordingPositionraw> messageByPosition = recordMapper.getMessageByPosition(location);
    //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    for (int i=0;i<messageByPosition.size();i++){
      BullyMessageAccordingPosition sam=new BullyMessageAccordingPosition();
      //String time=df.format(messageByPosition.get(i).getBullyTime());
      if (result.isEmpty()){
      sam.setBully_time(messageByPosition.get(i).getBullyTime());
      sam.setDetail_position(messageByPosition.get(i).getDetailPosition());
      sam.setLayer(messageByPosition.get(i).getLayer());
      sam.setId(messageByPosition.get(i).getId());
      sam.getStudent().add(messageByPosition.get(i).getStudentId());
      result.add(sam);
      }else if (result.get(result.size()-1).getId()==messageByPosition.get(i).getId()){
        result.get(result.size()-1).getStudent().add(messageByPosition.get(i).getStudentId());
      }else {
        sam.setBully_time(messageByPosition.get(i).getBullyTime());
        sam.setDetail_position(messageByPosition.get(i).getDetailPosition());
        sam.setLayer(messageByPosition.get(i).getLayer());
        sam.setId(messageByPosition.get(i).getId());
        sam.getStudent().add(messageByPosition.get(i).getStudentId());
        result.add(sam);
      }

    }
    logger.info("Service层 每个地点霸凌信息列表结果返回");
    return new R(true,result);
  }

  @Override
  public R getDetailInfoForTeacher(Integer id) {
    Record record = recordMapper.selectById(id);
    HashMap<String,String> result=new HashMap<>();
    if (record.getParentMsg()!=null){
      result.put("detailInfo",record.getParentMsg());
    }else {
      result.put("detailInfo","");
    }

    logger.info("Service层 每个地点选中的霸凌行为的详细信息展示的结果返回");
    return new R(true,result);
  }


  @Override
  public R cardingsolve(Integer id,String teachermsg) {
   recordMapper.updateState(id,teachermsg);
    logger.info("Service层 老师开始对每个地点选中的霸凌行为的打开处理的结果返回");
    return new R(true,"老师核查完成");
  }
}
