package com.cg.onlineexamination.service;

import java.util.List;


import org.springframework.stereotype.Service;
import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.Student;

@Service
public interface ExamService  {
	
	
	public Exam addExam(Exam exam)throws Exception;
	public List<Exam>getAllExams();
	
	//public Exam startExam(int examId);
	/*public Exam findResultByEnrollmentId(int enrollmentId);
	List<Exam> findAllResultsByBatchName(String batchName);
	boolean releaseResultByEnrollmentId(int enrollmentId); */

}
