package com.cg.onlineexamination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.entity.TestQuestion;

@Repository
public interface TestQuestionRepository extends JpaRepository<TestQuestion,Integer>{

	//TestQuestion updateTestPaperByTestQuestion(TestQuestion savedTestQuestion, TestPaper savedTestPaper);

	//public void checkAnswer(String option);
}
