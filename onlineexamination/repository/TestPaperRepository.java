package com.cg.onlineexamination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestPaper;

@Repository
public interface TestPaperRepository extends JpaRepository<TestPaper,Integer>{

	TestPaper updateExamByTestPaper(TestPaper savedTestPaper, Exam savedExam);

	
	
	

}
