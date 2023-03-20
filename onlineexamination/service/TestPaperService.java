package com.cg.onlineexamination.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.entity.TestQuestion;

@Service
public interface TestPaperService {

	public TestPaper addTestPaper(TestPaper t)throws Exception;
	public List<TestPaper>getAllTestPaper();
	public List<TestPaper>getTestPaperByCourse(String course);
	public int getNoOfQuestionsByTestPaperId(int testPaperId);
	   
	
	
	
	
	
	
	}
	
