package com.cg.onlineexamination.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Examdto {
	
	private int examId;
	private int dateOfExam;
	private int maximumScore;
	private int actualScore;
	private String difficultyLevel;
	private String status;

}
