package com.cg.onlineexamination.service;

import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.Student;

@Service
public interface StudentService {
	
	public Student addStudent(Student student)throws Exception;

	
	
}
