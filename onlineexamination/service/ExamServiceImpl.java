package com.cg.onlineexamination.service;

import java.io.InvalidClassException;


import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineexamination.dto.Examdto;
import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.exception.ExamNotFoundException;
import com.cg.onlineexamination.repository.ExamRepository;
import com.cg.onlineexamination.repository.TestPaperRepository;
@Service
public class ExamServiceImpl implements ExamService{


	@Autowired
	ExamRepository examRepository;
	
	
	@Autowired
	TestPaperRepository testPaperRepository;

	@Override
	public Exam addExam(Exam exam) throws Exception {
		if (exam != null) {
			if (exam.getDateOfExam().equals("")) {
				throw new InvalidClassException("exam", "exam is null");
			}
			Exam savedExam = examRepository.save(exam);
			return savedExam;
		} else
			throw new NullPointerException("exam is null");
	}

	@Override
	public List<Exam> getAllExams() {
		return examRepository.findAll();
	}

	@Override
	public Exam getExambyId(int id) {
		
		if (id>=1) {
			Exam savedExam = examRepository.getReferenceById(id);
			if(savedExam != null)
				return savedExam;
			else {
				throw new EntityNotFoundException("Invalid Exam Id: "+ id);
				
			}
			
			
		}
		return null;
		
	}

	@Override
	public Exam updateTestPaper(int examId, int testPaperId) {
		Exam savedExam = examRepository.getReferenceById(examId);
		TestPaper savedTestPaper = testPaperRepository.getReferenceById(testPaperId);

		
		if(savedExam != null & savedTestPaper != null) 
		{
			savedExam.setTestPaper(savedTestPaper);
			return savedExam;
		}

		return null;
	}

	
}

	

	/*@Override
	public Exam startExam(int examId) {
		
	}
	}*/
	
	/*@Override
	public Exam findResultByEnrollmentId(int enrollmentId) throws ExamNotFoundException {
		 Exam result = examRepository.findByEnrollmentId(enrollmentId);
		    if (result == null) {
		        throw new ExamNotFoundException("Exam not found for enrollment ID: " + enrollmentId);
		    }
		    return result;
		
	}

	@Override
	public List<Exam> findAllResultsByBatchName(String batchName) throws ExamNotFoundException {
		 List<Exam> examResults = examRepository.findAllByBatchName(batchName);
		    if (examResults.isEmpty()) {
		        throw new ExamNotFoundException("No exams found for batch name: " + batchName);
		    }
		    return examResults;
	}

	
	   
	
	@Override
	public boolean releaseResultByEnrollmentId(int enrollmentId) {
		// TODO Auto-generated method stub
		return false;
	} */


