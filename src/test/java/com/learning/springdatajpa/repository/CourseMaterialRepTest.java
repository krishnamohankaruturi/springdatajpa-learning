package com.learning.springdatajpa.repository;

import com.learning.springdatajpa.entities.Course;
import com.learning.springdatajpa.entities.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseMaterialRepTest
{
    @Autowired
    private  CourseMaterialRepo courseMaterialRepo;

    @Test
    public  void  saveCourseMaterial(){
        Course course1 = Course.builder().title("Networking").credit(5).build();
        CourseMaterial courseMaterial = CourseMaterial.builder().url("www.selenium.com")
                .course(course1)
                .build();
        courseMaterialRepo.save(courseMaterial);
    }

    @Test
    public  void  printAllCourses(){
        List<CourseMaterial> courseMaterials = courseMaterialRepo.findAll();
        System.out.println("Coursematerial = " + courseMaterials);
    }
}
