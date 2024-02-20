package com.learning.springdatajpa.repository;

import com.learning.springdatajpa.entities.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.management.StandardEmitterMBean;
import java.util.List;

@Repository
public interface StudentRespository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstname);

    //Native query
    @Query(
            value = "select * from tbl_student s where  s.email_address= ?1",
            nativeQuery = true
    )
    Student getStudentByEmailNative(String emailid);

    @Query(
            value = "select  * from tbl_student s where  s.email_address= :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailNativeParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student  set first_name= ?1 where email_address  = ?2",
            nativeQuery = true
    )
    int updateStudentByEmail(String firstName, String emailID);

}
