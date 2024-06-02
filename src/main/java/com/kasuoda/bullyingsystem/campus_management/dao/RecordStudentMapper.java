package com.kasuoda.bullyingsystem.campus_management.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kasuoda.bullyingsystem.campus_management.entity.Record;
import com.kasuoda.bullyingsystem.campus_management.entity.RecordStudent;
import org.springframework.stereotype.Repository;


@Repository
public interface RecordStudentMapper extends BaseMapper<RecordStudent> {
}
