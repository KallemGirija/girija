package com.cg.onlineexamination.service;

import java.io.InvalidClassException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlineexamination.entity.Student;
import com.cg.onlineexamination.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;

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
		}


