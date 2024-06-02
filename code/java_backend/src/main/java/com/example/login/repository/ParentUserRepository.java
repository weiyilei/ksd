package com.example.login.repository;

import com.example.login.entity.ParentUser;
import org.springframework.data.jpa.repository.JpaRepository;


//通过数据库把数据查询出来
public interface ParentUserRepository extends JpaRepository<ParentUser, Integer> {
    ParentUser findByPhonenumber(String phonenumber);

    ParentUser findByPhonenumberAndPassword(String phonenumber, String password);
}
