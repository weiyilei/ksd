package com.kasuoda.bullyingsystem.campus_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kasuoda.bullyingsystem.campus_management.dao.ParentMapper;
import com.kasuoda.bullyingsystem.campus_management.dao.RecordMapper;
import com.kasuoda.bullyingsystem.campus_management.dao.TeacherMapper;
import com.kasuoda.bullyingsystem.campus_management.entity.Teacher;
import com.kasuoda.bullyingsystem.campus_management.service.TeacherService;
import com.kasuoda.bullyingsystem.campus_management.vo.ParentHaveDoneRecord;
import com.kasuoda.bullyingsystem.campus_management.vo.ParentRightNowRecord;
import com.kasuoda.bullyingsystem.campus_management.vo.TeacherHaveDoneRecord;
import com.kasuoda.bullyingsystem.campus_management.vo.TeacherRightNowRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public List<TeacherHaveDoneRecord> findAllTeacherHaveDoneList(Integer id) {
        return recordMapper.selectTeacherHaveDone(id);
    }

    @Override
    public List<TeacherRightNowRecord> findAllTeacherRightNowList(Integer id) {
        return recordMapper.selectTeacherRightNow(id);
    }
}
