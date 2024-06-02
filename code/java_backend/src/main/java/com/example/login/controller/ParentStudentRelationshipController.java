package com.example.login.controller;


import com.example.login.entity.ParentStudentRelationship;
import com.example.login.repository.ParentStudentRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//modified

@RestController
@RequestMapping("/relationship")
public class ParentStudentRelationshipController {

    @Resource
    private ParentStudentRepository parentStudentRepository;

    @PostMapping("/add")
    public ParentStudentRelationship addNewRelationship(@RequestBody ParentStudentRelationship parentStudentRelationship){
//        parentStudentRelationship.setId(RandomId.getUniqueKey());
        parentStudentRepository.save(parentStudentRelationship);
        return parentStudentRelationship;
    }
}
