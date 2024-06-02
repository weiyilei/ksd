package com.example.login.entity;


import lombok.Data;

import javax.persistence.*;

//modified

@Entity
@Table(name = "student_information")
@Data
public class Student {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String name;
}
