package com.example.login.repository;

import com.example.login.entity.StudentParentRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentParentRepository extends JpaRepository<StudentParentRelationship, Integer> {
}
