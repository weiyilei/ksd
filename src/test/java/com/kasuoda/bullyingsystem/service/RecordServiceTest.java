package com.kasuoda.bullyingsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kasuoda.bullyingsystem.campus_management.entity.Record;
import com.kasuoda.bullyingsystem.campus_management.service.RecordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RecordServiceTest {
    @Autowired
    private RecordService recordService;

    @Test
    void test(){
        QueryWrapper<Record> wrapper = new QueryWrapper<>();
        wrapper.eq("submit_id",1);
        recordService.list(wrapper).forEach(System.out::println);
    }
}
