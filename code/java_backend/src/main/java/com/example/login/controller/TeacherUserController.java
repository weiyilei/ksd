package com.example.login.controller;

import com.example.login.entity.User;
import com.example.login.repository.UserRepository;
import com.example.login.util.RandomId;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//modified

@RestController
@RequestMapping("/teacherUser")
public class TeacherUserController {

    @Resource
    private UserRepository userRepository;

    @PostMapping("/register")
    public String addNewTeacherUser(@RequestBody User user){
        User userFind = userRepository.findByTelephone(user.getTelephone());
        if(userFind != null){
            return "0";
        }
//        User rst = new User(RandomId.getUniqueKey(), user.getName(), user.getPassword(), user.getTelephone(), user.getType());
        user.setId(RandomId.getUniqueKey());
//        userRepository.save(rst);
        userRepository.save(user);
        return userRepository.findByTelephone(user.getTelephone()).getId();
    }

    @PostMapping("/login")
    //用账号和密码匹配用户
    public User login(@RequestBody User user){
        //requestBody自动把前端的json转化为实体类
        return userRepository.findByTelephoneAndPassword(user.getTelephone(), user.getPassword());
    }

}
