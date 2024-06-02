package com.example.login.repository;

import com.example.login.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//modified

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByName(String name);
}
