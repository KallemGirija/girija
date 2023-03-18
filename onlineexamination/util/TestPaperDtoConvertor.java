package com.cg.onlineexamination.util;

import com.cg.onlineexamination.dto.TestPaperdto;
import com.cg.onlineexamination.entity.TestPaper;

public class TestPaperDtoConvertor {

	public TestPaperdto getTestPaperdto(TestPaper t)
	{ 
		return new TestPaperdto(t.getTestPaperCode(),t.getDifficultyLevel(),t.getDescription());
	    
		
	}


}