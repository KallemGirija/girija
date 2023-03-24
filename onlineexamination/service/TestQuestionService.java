package com.cg.onlineexamination.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.entity.TestQuestion;

@Service
public interface TestQuestionService {
	
	public TestQuestion addTestQuestion(TestQuestion TestQuestion)throws Exception;
	public boolean removeTestQuestion(int testQuestionId);
	public List<TestQuestion>viewAllTestQuestions();
	public TestQuestion viewTestQuestionById(int id)throws Exception;
	public TestQuestion updateTestPaperByTestQuestion(int testPaperId ,int testQuestionId)throws Exception;
	public List<TestQuestion> getAllQuestionsByTestPaperId(int testPaperId);
}
