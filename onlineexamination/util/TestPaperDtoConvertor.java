package com.cg.onlineexamination.util;

import org.springframework.stereotype.Component;

import com.cg.onlineexamination.dto.TestPaperdto;
import com.cg.onlineexamination.entity.TestPaper;

@Component
public class TestPaperDtoConvertor {

	public TestPaperdto getTestPaperdto(TestPaper t)
	{ 
		return new TestPaperdto(t.getTestPaperId(),t.getDifficultyLevel(),t.getDescription(),t.getCourse());
	    
		
	}


}