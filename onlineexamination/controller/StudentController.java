package com.cg.onlineexamination.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineexamination.dto.Examdto;
import com.cg.onlineexamination.dto.Studentdto;
import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.Student;
import com.cg.onlineexamination.service.ExamService;
import com.cg.onlineexamination.service.StudentService;
import com.cg.onlineexamination.util.ExamDtoConvertor;
import com.cg.onlineexamination.util.StudentDtoConvertor;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StudentDtoConvertor studentDtoConvertor;
	
	public StudentController() {
		logger.info("student controller");
		System.err.println("student controller");
	}
	
	@PostMapping("/register")
	public ResponseEntity<Studentdto> saveStudent(@RequestBody Student student) throws Exception {
		Student savedStudent = studentService.addStudent(student);
		logger.info(" --->> Student saved " + savedStudent);

		if (savedStudent != null) {
			Studentdto dtoObj = studentDtoConvertor.getStudentdto(savedStudent);
			return new ResponseEntity<Studentdto>(dtoObj, HttpStatus.OK);

		}
		return null;
	}
			
}
	


