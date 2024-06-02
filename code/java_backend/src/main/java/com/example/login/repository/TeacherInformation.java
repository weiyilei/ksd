package com.example.login.repository;

import com.example.login.entity.TeacherIndividual;
import org.springframework.data.jpa.repository.JpaRepository;

//modified

public interface TeacherInformation extends JpaRepository<TeacherIndividual, Integer> {
    TeacherIndividual findByNameAndPhonenumber(String name, String phonenumber);
}
