package com.cg.onlineexamination.util;



import com.cg.onlineexamination.dto.StudentEnrollmentdto;
import com.cg.onlineexamination.entity.StudentEnrollment;

public class StudentEnrollmentDtoConvertor {

	public StudentEnrollmentdto getStudentEnrollmentdto(StudentEnrollment se)
	{ 
		return new StudentEnrollmentdto(se.getEnrollmentId(),se.getBatchName(),se.getEnrollmentDate(),se.getCompletionDate(),se.getStatus());
	    
		
	}
}


