package com.example.login.entity;


import lombok.Data;

import javax.persistence.*;

//modified

@Entity
@Table(name = "teacher_information")
@Data
public class TeacherIndividual {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String name;
    private String phonenumber;
}
