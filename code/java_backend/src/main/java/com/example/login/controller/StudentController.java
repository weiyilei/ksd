package com.example.login.controller;


import com.example.login.entity.User;
import com.example.login.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//modified

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
//    private StudentRepository studentRepository;
      private UserRepository userRepository;

    @PostMapping("/check")
    public String checkStudentName(@RequestBody User user){
        User studentFind = userRepository.findByNameAndType(user.getName(), user.getType());
        if(studentFind == null){
            return "0";
        }
        else{
            return studentFind.getId();
        }
    }


}
