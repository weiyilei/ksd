package com.example.login.repository;

import com.example.login.entity.ParentStudentRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

//modified

public interface ParentStudentRepository extends JpaRepository<ParentStudentRelationship, Integer> {
}
