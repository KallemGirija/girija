package com.cg.onlineexamination.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.StudentEnrollment;

@Repository
public interface ExamRepository extends JpaRepository<Exam,Integer>{

	//Exam findByEnrollmentId(int enrollmentId);

	//List<Exam> findAllByBatchName(String batchName);



}
