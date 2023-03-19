package com.cg.onlineexamination.util;

import org.springframework.stereotype.Component;

import com.cg.onlineexamination.dto.Studentdto;
import com.cg.onlineexamination.dto.TestPaperdto;
import com.cg.onlineexamination.dto.TestQuestiondto;
import com.cg.onlineexamination.entity.Student;
import com.cg.onlineexamination.entity.TestQuestion;

@Component
public class TestQuestionDtoConvertor {
	
	public TestQuestiondto getTestQuestiondto(TestQuestion tq)
	{ 
		return new TestQuestiondto(tq.getQuestionId(),tq.getQuestion(),tq.getOption1(),tq.getOption2(),tq.getOption3(),tq.getOption4(),tq.getCorrectAnswer());

	
}
	

}

