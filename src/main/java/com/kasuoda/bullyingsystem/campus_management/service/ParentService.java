package com.kasuoda.bullyingsystem.campus_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kasuoda.bullyingsystem.campus_management.entity.Parent;
import com.kasuoda.bullyingsystem.campus_management.vo.ParentHaveDoneRecord;
import com.kasuoda.bullyingsystem.campus_management.vo.ParentRightNowRecord;

import java.util.List;

public interface ParentService extends IService<Parent> {
    List<ParentHaveDoneRecord> findAllParentHaveDoneList(Integer id);
    List<ParentRightNowRecord> findAllParentRightNowList(Integer id);
}
