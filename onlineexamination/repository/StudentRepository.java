package com.cg.onlineexamination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.onlineexamination.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
