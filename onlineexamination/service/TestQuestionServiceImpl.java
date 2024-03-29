package com.cg.onlineexamination.service;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.entity.TestQuestion;
import com.cg.onlineexamination.repository.ExamRepository;
import com.cg.onlineexamination.repository.TestPaperRepository;
import com.cg.onlineexamination.repository.TestQuestionRepository;

@Service
public class TestQuestionServiceImpl implements TestQuestionService{
	
	@Autowired
	TestQuestionRepository testQuestionRepository;
	
	@Autowired
	TestPaperRepository testPaperRepository;

	/*@Override
	public void checkAnswer(String option) {
		
		String correctAnswer = "B";
		if(option.equalsIgnoreCase(correctAnswer)) {
			System.out.println("Correct");
			
		}
		else {
			System.out.println("Incorrect. The correct answer is" +correctAnswer);
		}
		
	}*/


	@Override
	public TestQuestion addTestQuestion(TestQuestion testQuestion) throws Exception {
		if (testQuestion != null) {
			if (testQuestion.getCorrectAnswer().equals("")) {
				throw new InvalidClassException("testQuestion", "testQuestion is null");
			}
			TestQuestion savedTestQuestion = testQuestionRepository.save(testQuestion);
			return savedTestQuestion;
		} else
			throw new NullPointerException("testQuestion is null");
	}

	
	
	

	@Override
	public TestQuestion updateTestPaperByTestQuestion(int testPaperId, int testQuestionId)throws Exception{
		TestQuestion testQuestionFromDB = viewTestQuestionById(testQuestionId);
		TestPaper testPaperFromDB = testPaperRepository.getReferenceById(testPaperId);

		if(testQuestionFromDB != null & testPaperFromDB != null) 
		{
			List<TestQuestion> allTestQuestions = testPaperFromDB.getTestQuestion();
			if(allTestQuestions != null && allTestQuestions.isEmpty()==false) {
				allTestQuestions.add(testQuestionFromDB);
				testPaperFromDB.setTestQuestion(allTestQuestions);
			}
			else {
				List<TestQuestion> newTestQuestionList = new ArrayList<>();
				newTestQuestionList.add(testQuestionFromDB);
				testPaperFromDB.setTestQuestion(newTestQuestionList);
				
			}
			testPaperRepository.saveAndFlush(testPaperFromDB);
			testQuestionRepository.save(testQuestionFromDB);
			return testQuestionFromDB;
			}
		else {
			throw new NullPointerException(
					"Either TestQuestion" +testQuestionFromDB + "or TestPaper " + testPaperFromDB + "is Null");
		}
	}

	@Override
	public TestQuestion viewTestQuestionById(int id) throws Exception {
		// TODO Auto-generated method stub
		if (id >=1) {
			TestQuestion savedTestQuestion = testQuestionRepository.getReferenceById(id);
			if(savedTestQuestion != null)
				return savedTestQuestion;
			else {
				throw new EntityNotFoundException("Invalid TestQuestion ID : " + id);
			}
		}
		return null;
	}

	@Override
	public List<TestQuestion> viewAllTestQuestions() {
		// TODO Auto-generated method stub
		return testQuestionRepository.findAll();
	}





	@Override
	public List<TestQuestion> getAllQuestionsByTestPaperId(int testPaperId) {
		TestPaper testPaper = testPaperRepository.getReferenceById(testPaperId);
		List<TestQuestion> allTestQuestions = testPaper.getTestQuestion();
		return allTestQuestions;
		}





	@Override
	public boolean removeTestQuestion(int testQuestionId) {
		// TODO Auto-generated method stub
		
		testQuestionRepository.deleteById(testQuestionId);
		return true;
		
	}
	}

	
	
	
	
	
	
	


