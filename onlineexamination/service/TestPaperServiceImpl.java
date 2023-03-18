package com.cg.onlineexamination.service;

import java.io.InvalidClassException;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.repository.ExamRepository;
import com.cg.onlineexamination.repository.TestPaperRepository;

public class TestPaperServiceImpl implements TestPaperService{

	@Autowired
	TestPaperRepository testPaperRepository;

	@Override
	public TestPaper addTestPaper(TestPaper t) throws Exception {
		if (t != null) {
			if (t.getDifficultyLevel().equals("")) {
				throw new InvalidClassException("testPaper", "testPaper is null");
			}
			TestPaper savedTestPaper = testPaperRepository.save(t);
			return savedTestPaper;
		} else
			throw new NullPointerException("testPaper is null");
	}
	}


