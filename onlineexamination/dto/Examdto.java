package com.cg.onlineexamination.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Examdto {
	
	private int examId;
	private int score;
	private LocalDate dateOfExam;
	
	

}
