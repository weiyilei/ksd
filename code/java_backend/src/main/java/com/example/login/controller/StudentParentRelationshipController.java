package com.example.login.controller;


import com.example.login.entity.StudentParentRelationship;
import com.example.login.repository.StudentParentRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/relationship")
public class StudentParentRelationshipController {

    @Resource
    private StudentParentRepository studentParentRepository;

    @PostMapping("/add")
    public StudentParentRelationship addNewRelationship(@RequestBody StudentParentRelationship studentParentRelationship){
        studentParentRepository.save(studentParentRelationship);
        return studentParentRelationship;
    }
}
