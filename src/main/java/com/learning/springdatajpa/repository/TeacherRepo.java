package com.learning.springdatajpa.repository;

import com.learning.springdatajpa.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo  extends JpaRepository<Teacher, Long> {
}
