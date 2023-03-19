package com.cg.onlineexamination.util;

import org.springframework.stereotype.Component;
import com.cg.onlineexamination.dto.Examdto;
import com.cg.onlineexamination.entity.Exam;

@Component
public class ExamDtoConvertor {
	
	public Examdto getExamdto(Exam e)
	{ 
		return new Examdto(e.getExamId(),e.getDateOfExam(),e.getMaximumScore(),e.getActualScore(),e.getDifficultyLevel(),e.getStatus());
	    
		
	}

}

