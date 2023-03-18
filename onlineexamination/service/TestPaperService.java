package com.cg.onlineexamination.service;

import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.TestPaper;

@Service
public interface TestPaperService {

	public TestPaper addTestPaper(TestPaper t)throws Exception;
		
	}
	
