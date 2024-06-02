package com.kasuoda.bullyingsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kasuoda.bullyingsystem.campus_management.entity.Record;
import com.kasuoda.bullyingsystem.campus_management.service.ParentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ParentServiceTest {
    @Autowired
    private ParentService parentService;


    @Test
    void test(){

        parentService.findAllParentHaveDoneList(1).forEach(System.out::println);
    }
}
