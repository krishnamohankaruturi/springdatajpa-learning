package com.learning.springdatajpa.repository;

import com.learning.springdatajpa.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
    Page<Course> findByTitleContaining(String title, Pageable pageable);
}

