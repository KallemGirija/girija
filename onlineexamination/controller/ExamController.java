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
import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.service.ExamService;
import com.cg.onlineexamination.util.ExamDtoConvertor;

@RestController
@RequestMapping("/exam")
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
			
}

