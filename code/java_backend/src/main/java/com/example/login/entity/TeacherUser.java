package com.example.login.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "teacher_user")
@Data
public class TeacherUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
    private String phonenumber;
}
