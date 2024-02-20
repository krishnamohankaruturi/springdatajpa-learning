package com.learning.springdatajpa.repository;

import com.learning.springdatajpa.entities.Guardian;
import com.learning.springdatajpa.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRespositoryTest {
    @Autowired
    private StudentRespository studentRespository;

    @Test
    public void saveStudent() {
        Student student = Student.builder().emalId("krishna@gmail.com")
                .firstName("krishna").lastName("karuturi")
                //.guardianName("ram mohan")
                //.guardianEmail("ram@gmail.com").
                //guardianMobile("898541545")
                .build();
        studentRespository.save(student);

    }

    @Test
    public void printAllStudent() {
        List<Student> students = studentRespository.findAll();
        System.out.println("Student List " + students);

    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder().name("venkat")
                .email("venkat@gmail.com")
                .mobile("94917173788").build();
        Student student = Student.builder().firstName("ram")
                .lastName("karuturi")
                .emalId("ram@gmail.com")
                .guardian(guardian)
                .build();
        studentRespository.save(student);
    }

    @Test
    public  void  printStudentByFirstName()
    {
        List<Student> student = studentRespository.findByFirstName("ram");
        System.out.println(student);
    }

    @Test
    public void printStudentBuEmailNative(){
        Student studentByEmailNative = studentRespository.getStudentByEmailNative("ram@gmail.com");
        System.out.println("Student :"+ studentByEmailNative);
    }

    @Test
    public  void   printStduentEmailByNativeparam(){
        Student studentByEmailNativeParam = studentRespository.getStudentByEmailNativeParam("ram@gmail.com");
        System.out.println(studentByEmailNativeParam);

    }
    @Test
    public void updateStudentNameByEmail(){
        studentRespository.updateStudentByEmail("Ram Rk", "ram@gmail.com");
    }

}