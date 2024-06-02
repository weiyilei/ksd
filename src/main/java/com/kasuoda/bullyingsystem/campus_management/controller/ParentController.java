package com.kasuoda.bullyingsystem.campus_management.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kasuoda.bullyingsystem.campus_management.entity.Parent;
import com.kasuoda.bullyingsystem.campus_management.entity.Record;
import com.kasuoda.bullyingsystem.campus_management.service.ParentService;
import com.kasuoda.bullyingsystem.campus_management.service.RecordService;
import com.kasuoda.bullyingsystem.campus_management.vo.ParentHaveDoneRecord;
import com.kasuoda.bullyingsystem.campus_management.vo.ParentRightNowRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@Api(tags = "ParentController")
@RestController
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @ApiOperation(value = "获得当前登录用户所有已上报且被处理记录")
    @GetMapping("/listHaveDone")
    public List<ParentHaveDoneRecord> listHaveDone(){
        return parentService.findAllParentHaveDoneList(1);
    }

    @ApiOperation(value = "获得当前登录用户所有已上报但未被处理记录")
    @GetMapping("/listRightNow")
    public List<ParentRightNowRecord> listRightNow(){
        return parentService.findAllParentRightNowList(1);
    }





}
