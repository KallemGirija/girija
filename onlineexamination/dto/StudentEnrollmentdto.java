package com.cg.onlineexamination.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEnrollmentdto {
	private int enrollmentId;
	private String batchName;
	private int enrollmentDate;
	private int completionDate;
	private String status;

}
