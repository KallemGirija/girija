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
import com.cg.onlineexamination.dto.TestQuestiondto;
import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.Student;
import com.cg.onlineexamination.entity.TestQuestion;
import com.cg.onlineexamination.exception.ExamNotFoundException;
import com.cg.onlineexamination.service.ExamService;
import com.cg.onlineexamination.util.ExamDtoConvertor;

@RestController
@RequestMapping("/exam")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:2004"},allowedHeaders="*")
public class ExamController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ExamService examService;
	
	@Autowired
	ExamDtoConvertor examDtoConvertor;

	
	public ExamController() {
		logger.info("exam controller");
		System.err.println("exam controller");
	}

	@PostMapping("/register")
	public ResponseEntity<Examdto> saveExam(@RequestBody Exam exam) throws Exception {
		Exam savedExam = examService.addExam(exam);
		logger.info(" --->> Exam saved " + savedExam);

		if (savedExam != null) {
			Examdto dtoObj = examDtoConvertor.getExamdto(savedExam);
			return new ResponseEntity<Examdto>(dtoObj, HttpStatus.OK);

		}
		return null;
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Examdto>> getAllExams()
	{
		List<Exam> allExamsInDB = examService.getAllExams();

		List<Examdto> dtoList = new ArrayList<>();
		for (Exam exam : allExamsInDB) {

			Examdto dtoObj = examDtoConvertor.getExamdto(exam);
			dtoList.add(dtoObj);
		}

		return new ResponseEntity<List<Examdto>>(dtoList,HttpStatus.OK);
	}
	
	@GetMapping("/{examid}")
	public ResponseEntity<Examdto> getExamById(@PathVariable int examid) throws Exception {
	
		Exam savedExam = examService.getExambyId(examid);
		Examdto examdto = examDtoConvertor.getExamdto(savedExam);
		return new ResponseEntity<Examdto>(examdto, HttpStatus.OK);

	}
	
	
	@PutMapping("/{eid}/testPaper/{tpid}")
	public String updateExamWithTestPaper(@PathVariable int eid,@PathVariable int tpid)
	{
		Exam updatedExam = examService.updateTestPaper(eid, tpid);

		if(updatedExam.getTestPaper() != null)
		{
			return updatedExam.toString();
		}
		else return "error : - "+updatedExam.toString()+" ";
	}
	
	@PutMapping("/{eid}")
	public String updateExamWithStudentAnswer(@PathVariable int eid, @RequestBody Examdto examdto) throws ExamNotFoundException
	{
		System.out.println("Inside updateExamWithStudentAnswer Method");

		Exam updatedExam = examService.updateStudentAnswer(eid, examdto);

		return updatedExam.toString();
}
	
	
}

