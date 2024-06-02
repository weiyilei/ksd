package com.example.login.entity;


import lombok.Data;

import javax.persistence.*;

//modified

@Entity
@Table(name = "parent_student")
@Data
public class ParentStudentRelationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String parent_id;
    private String student_id;

    public String getStudentId(){
        return student_id;
    }

    public void setStudentId(String student_id){
        this.student_id = student_id;
    }
}
