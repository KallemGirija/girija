package com.cg.onlineexamination.entity;

import java.time.LocalDate;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int examId;
	private int score;
	private LocalDate dateOfExam;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "testPaperId")
	private TestPaper testPaper;
	
	
	/*@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "studentId") 
	private List<Student>  student;*/
	
	/*@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "studentId")
	private Student s;*/


	public Exam(int score, LocalDate dateOfExam ) {
		super();
		this.score = score;
		this.dateOfExam = dateOfExam;
		
	}


	
	
}
