package com.cg.onlineexamination.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineexamination.dto.Examdto;
import com.cg.onlineexamination.dto.Studentdto;
import com.cg.onlineexamination.dto.TestPaperdto;
import com.cg.onlineexamination.dto.TestQuestiondto;
import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.Student;
import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.entity.TestQuestion;
import com.cg.onlineexamination.service.ExamService;
import com.cg.onlineexamination.service.StudentService;
import com.cg.onlineexamination.util.ExamDtoConvertor;
import com.cg.onlineexamination.util.StudentDtoConvertor;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:2004"},allowedHeaders="*")
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
	
	@GetMapping("/list")
	public ResponseEntity<List<Studentdto>> getAllStudents()
	{
		List<Student> allStudentsInDB = studentService.getAllStudents();

		List<Studentdto> dtoList = new ArrayList<>();
		for (Student student : allStudentsInDB) {

			Studentdto dtoObj = studentDtoConvertor.getStudentdto(student);
			dtoList.add(dtoObj);
		}

		return new ResponseEntity<List<Studentdto>>(dtoList,HttpStatus.OK);
	}
	
	@GetMapping("/{studentid}")
	public ResponseEntity<Studentdto> getStudentById(@PathVariable int studentid) throws Exception {

		Student savedStudent = studentService.viewStudentById(studentid);
		Studentdto studentdto = studentDtoConvertor.getStudentdto(savedStudent);
		return new ResponseEntity<Studentdto>(studentdto, HttpStatus.OK);

	}
	
	
	/*@PutMapping("/{studentid}/exam/{eid}")
	public ResponseEntity<Studentdto> updateExamByStudentId(@PathVariable int studentid, @PathVariable int eid) throws Exception {
		
		Student updatedStudent = studentService.updateExamByStudent(eid, studentid);
		if(updatedStudent != null) {
			Studentdto studentdto = studentDtoConvertor.getStudentdto(updatedStudent);
			return new ResponseEntity<Studentdto>(studentdto,HttpStatus.OK);
		}
		return null;
	}*/
	
	
	
			
}
	


