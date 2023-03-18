package com.cg.onlineexamination.entity;

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
import javax.persistence.OneToMany;
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
	private int examRollNo;
	private int dateOfExam;
	private String status;
	private int maximumScore;
	private int actualScore;
	private float examDuration;
	private String difficultyLevel;
	
	public Exam(int dateOfExam, String status, int maximumScore, int actualScore, float examDuration,
			String difficultyLevel) {
		super();
		
		this.dateOfExam = dateOfExam;
		this.status = status;
		this.maximumScore = maximumScore;
		this.actualScore = actualScore;
		this.examDuration = examDuration;
		this.difficultyLevel = difficultyLevel;
	}
	
	

	
}
