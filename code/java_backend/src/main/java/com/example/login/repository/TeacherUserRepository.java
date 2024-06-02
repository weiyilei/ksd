package com.example.login.repository;

import com.example.login.entity.TeacherUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherUserRepository extends JpaRepository<TeacherUser, Integer> {
    TeacherUser findByPhonenumber(String phonenumber);

    TeacherUser findByPhonenumberAndPassword(String phonenumber, String password);
}
