package com.cg.onlineexamination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineexamination.entity.Student;
import com.cg.onlineexamination.entity.StudentEnrollment;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
