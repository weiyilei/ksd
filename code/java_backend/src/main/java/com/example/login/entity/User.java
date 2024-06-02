package com.example.login.entity;


import lombok.Data;

import javax.persistence.*;

//modified

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String name;
    private String password;
    private String telephone;
    private String type;


    public User(String id, String name, String password, String telephone, String type){
        this.id = id;
        this.name = name;
        this.password = password;
        this.telephone = telephone;
        this.type = type;
    }

    public User() {
    }
}
