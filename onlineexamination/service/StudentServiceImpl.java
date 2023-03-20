package com.cg.onlineexamination.service;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.Student;
import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.entity.TestQuestion;
import com.cg.onlineexamination.repository.ExamRepository;
import com.cg.onlineexamination.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ExamRepository examRepository;

	@Override
	public Student addStudent(Student student) throws Exception {
			if (student != null) {
				if (student.getUserName().equals("")) {
					throw new InvalidClassException("student", "student is null");
				}
				Student savedStudent = studentRepository.save(student);
				return savedStudent;
			} else
				throw new NullPointerException("student is null");
		}

	

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}



	/*@Override
	public Student updateExamByStudent(int examId, int studentId) throws Exception {
		Student studentFromDB = viewStudentById(studentId);
		Exam examFromDB = examRepository.getReferenceById(examId);

		if(studentFromDB != null & examFromDB != null) 
		{
			List<Student> allStudents = examFromDB.getStudent();
			if(allStudents != null && allStudents.isEmpty()==false) {
				allStudents.add(studentFromDB);
				examFromDB.setStudent(allStudents);
			}
			else {
				List<Student> newStudentList = new ArrayList<>();
				newStudentList.add(studentFromDB);
				examFromDB.setStudent(newStudentList);
				
			}
			examRepository.save(examFromDB);
			studentRepository.save(studentFromDB);
			return studentFromDB;
			}
		else {
			throw new NullPointerException(
					"Either Student" +studentFromDB + "or Exam " + examFromDB + "is Null");
		}
	}*/



	@Override
	public Student viewStudentById(int id) throws Exception {
		if (id >=1) {
			Student savedStudent = studentRepository.getReferenceById(id);
			if(savedStudent != null)
				return savedStudent;
			else {
				throw new EntityNotFoundException("Invalid Student ID : " + id);
			}
		}
		return null;
	}

	
}


