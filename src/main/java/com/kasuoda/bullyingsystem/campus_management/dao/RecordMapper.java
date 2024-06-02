package com.kasuoda.bullyingsystem.campus_management.dao;
import com.kasuoda.bullyingsystem.campus_management.entity.Record;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kasuoda.bullyingsystem.campus_management.vo.*;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordMapper extends BaseMapper<Record> {
    //@Select("selectParentHaveDone")
    List<ParentRightNowRecord> selectParentRightNow(Integer submitId);
    List<TeacherHaveDoneRecord> selectTeacherHaveDone(Integer dealId);
    List<TeacherRightNowRecord> selectTeacherRightNow(Integer dealId);
    List<ParentHaveDoneRecord> selectParentHaveDone(Integer submit_id);


    Integer getrecordmaxid();

    Integer getRecordNumberByPosition(String position);

    List<BullyMessageAccordingPositionraw> getMessageByPosition(String position);


    Integer updateState(Integer id,String msg);
}
