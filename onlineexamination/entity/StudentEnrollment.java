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
public class StudentEnrollment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int enrollmentId;
	private String batchName;
	private int enrollmentDate;
	private int completionDate;
	private String status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "examRollNo") // has to be one to many
	private List<Exam>  exam=new ArrayList<>();

	public StudentEnrollment(int enrollmentId, String batchName, int enrollmentDate, int completionDate,
			String status) {
		super();
		this.enrollmentId = enrollmentId;
		this.batchName = batchName;
		this.enrollmentDate = enrollmentDate;
		this.completionDate = completionDate;
		this.status = status;
	}
	
}
