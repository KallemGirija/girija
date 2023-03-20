package com.cg.onlineexamination.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.Student;
import com.cg.onlineexamination.entity.TestQuestion;

@Service
public interface StudentService {
	
	public Student addStudent(Student student)throws Exception;
	public List<Student>getAllStudents();
	public Student viewStudentById(int id)throws Exception;
	//public Student updateExamByStudent(int examId ,int studentId)throws Exception;
	
	
	
}
