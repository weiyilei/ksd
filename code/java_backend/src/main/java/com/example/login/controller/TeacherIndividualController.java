package com.example.login.controller;


import com.example.login.entity.TeacherIndividual;
import com.example.login.repository.TeacherInformation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//modified

@RestController
@RequestMapping("/teacherInformation")
public class TeacherIndividualController {
    @Resource
    private TeacherInformation teacherInformation;

    @PostMapping("/get")
    public TeacherIndividual getTeacherInformationByNameAndPhonenumber(@RequestBody TeacherIndividual teacherIndividual){
        TeacherIndividual res = teacherInformation.findByNameAndPhonenumber(teacherIndividual.getName(), teacherIndividual.getPhonenumber());
        return res;
    }
}
