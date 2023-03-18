package com.cg.onlineexamination.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Examdto {
	
	private int examRollNo;
	private int dateOfExam;
	private String status;
	private int maximumScore;
	private int actualScore;
	private float examDuration;
	private String difficultyLevel;

}
