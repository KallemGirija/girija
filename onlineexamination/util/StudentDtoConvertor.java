package com.cg.onlineexamination.util;



import com.cg.onlineexamination.dto.StudentEnrollmentdto;
import com.cg.onlineexamination.dto.Studentdto;
import com.cg.onlineexamination.entity.Student;
import com.cg.onlineexamination.entity.StudentEnrollment;

public class StudentDtoConvertor {

	public Studentdto getStudentdto(Student s)
	{ 
		return new Studentdto(s.getStudentId(),s.getUserName(),s.getPassword(),s.getFirstName(),s.getLastName(),s.getGender(),s.getEmailId(),s.getMobileNo());

	
}
	
}