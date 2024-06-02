package com.kasuoda.bullyingsystem.campus_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kasuoda.bullyingsystem.campus_management.entity.Teacher;
import com.kasuoda.bullyingsystem.campus_management.vo.TeacherHaveDoneRecord;
import com.kasuoda.bullyingsystem.campus_management.vo.TeacherRightNowRecord;


import java.util.List;

public interface TeacherService extends IService<Teacher> {
    List<TeacherHaveDoneRecord> findAllTeacherHaveDoneList(Integer id);
    List<TeacherRightNowRecord> findAllTeacherRightNowList(Integer id);
}
