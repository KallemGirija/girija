package com.cg.onlineexamination.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
public class TestQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionId;
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String correctAnswer;
	
	
	
	
	public TestQuestion(String question, String option1, String option2, String option3, String option4,
			String correctAnswer) {
		super();
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correctAnswer = correctAnswer;
	}
	
	
	
	
	
	
}
