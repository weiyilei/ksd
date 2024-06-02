package com.example.login.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "student_parent")
@Data
public class StudentParentRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer studentid;
    private Integer parentid;

}
