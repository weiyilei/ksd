package com.example.login.controller;


import com.example.login.entity.User;
import com.example.login.repository.UserRepository;
import com.example.login.util.RandomId;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//modified

@RestController
@RequestMapping("/parentUser")
public class ParentUserController {

    @Resource
    private UserRepository userRepository;

    @PostMapping("/check")
    public String checkParentUserTelephone(@RequestBody User user){
        User userFind = userRepository.findByTelephone(user.getTelephone());
        if(userFind == null){
            return "0";
        }
        else{
            return userFind.getId();
        }
    }

    @PostMapping("/register")
    public String addNewParentUser(@RequestBody User user){
        user.setId(RandomId.getUniqueKey());
        userRepository.save(user);
        return userRepository.findByTelephone(user.getTelephone()).getId();
    }

    @PostMapping("/login")
    //用账号和密码匹配用户
    public User login(@RequestBody User user){
        //requestBody自动把前端的json转化为实体类
        return userRepository.findByTelephoneAndPassword(user.getTelephone(), user.getPassword());
    }


//    @PostMapping("/login")
//    //用账号和密码匹配用户
//    public User login(@RequestBody User user){
//        //requestBody自动把前端的json转化为实体类
//        User res = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//        return res;
//    }
//
//    //查询接口--/user/id
//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable Integer id){
//        Optional<User> user = userRepository.findById(id);
//        return user.orElse(null);
//    }
//
//    @PostMapping("/regist")
//    public int insertUser(@RequestBody User user){
//        User userFind = userRepository.findByUsername(user.getUsername());
//        if(userFind != null) {
//            return 0;
//        }
//        userRepository.save(user);
//        int res = 0;
//        res = userRepository.findByUsername(user.getUsername()).getId();
//        return res;
//    }

}
