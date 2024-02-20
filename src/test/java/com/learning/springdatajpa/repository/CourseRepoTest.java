package com.learning.springdatajpa.repository;

import com.learning.springdatajpa.entities.Course;
import com.learning.springdatajpa.entities.Student;
import com.learning.springdatajpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class CourseRepoTest {
    @Autowired
    private CourseRepo courseRepo;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepo.findAll();
        System.out.println("Courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder().firstName("rama").lastName("lakshmi").build();
        Course course1 = Course.builder().title("Python").credit(6).teacher(teacher).build();
        courseRepo.save(course1);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPagewithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPagewithTwoRecords = PageRequest.of(1, 2);
        List<Course> courses = courseRepo.findAll(firstPagewithThreeRecords).getContent();
        long totalElements = courseRepo.findAll(firstPagewithThreeRecords).getTotalElements();
        long totalPages = courseRepo.findAll(firstPagewithThreeRecords).getTotalPages();
        System.out.println("totalPages : " + totalPages);
        System.out.println("totalelements : " + totalElements);
        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting() {
        PageRequest titleSort = PageRequest.of(0, 2, Sort.by("title"));
        PageRequest sortByAesc = PageRequest.of(0, 3, Sort.by("credit").ascending());
        PageRequest sortByTitleByDescCredit = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));
        List<Course> courses = courseRepo.findAll(sortByAesc).getContent();
        System.out.println("courses:  " + courses);

    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);
        List<Course> courses = courseRepo.findByTitleContaining("D", firstPageTenRecords).getContent();
        System.out.println(courses);
    }

    @Test
    public void saveCoursewithStudentAndTeacher() {
        Teacher teacher = Teacher.builder().firstName("Mahesh")
                .lastName("Babu")
                .build();

        Student student = Student.builder().firstName("krishna")
                .lastName("mohan")
                .emalId("krish@gmail.com")
                .build();

        Course course = Course.builder().title("AI")
                .credit(7)
                .teacher(teacher)
                .build();
         course.addStudents(student);
         courseRepo.save(course);

    }
}
