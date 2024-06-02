package com.kasuoda.bullyingsystem.campus_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kasuoda.bullyingsystem.campus_management.dao.ParentMapper;
import com.kasuoda.bullyingsystem.campus_management.dao.RecordMapper;
import com.kasuoda.bullyingsystem.campus_management.entity.Parent;
import com.kasuoda.bullyingsystem.campus_management.service.ParentService;
import com.kasuoda.bullyingsystem.campus_management.vo.ParentHaveDoneRecord;
import com.kasuoda.bullyingsystem.campus_management.vo.ParentRightNowRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl extends ServiceImpl<ParentMapper, Parent> implements ParentService {
    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private ParentMapper parentMapper;

    @Override
    public List<ParentHaveDoneRecord> findAllParentHaveDoneList(Integer id) {
        return recordMapper.selectParentHaveDone(id);
    }

    @Override
    public List<ParentRightNowRecord> findAllParentRightNowList(Integer id) {
        return recordMapper.selectParentRightNow(id);
    }
}
