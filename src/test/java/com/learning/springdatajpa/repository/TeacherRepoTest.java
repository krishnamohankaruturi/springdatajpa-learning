package com.learning.springdatajpa.repository;

import com.learning.springdatajpa.entities.Course;
import com.learning.springdatajpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepoTest {

    @Autowired
    private TeacherRepo teacherRepo;

    @Test
    public void saveTeacher() {
        Course courseDBA = Course.builder().title("DBA").credit(5).build();
        Course courseJAVA = Course.builder().title("JAVA").credit(6).build();
        Teacher teacher = Teacher.builder().firstName("santhi").lastName("babu")
                //.courses(List.of(courseDBA, courseJAVA))
                .build();
        teacherRepo.save(teacher);

    }

}