package com.cg.onlineexamination.entity;

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
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	private String userName;
	private int password;
	private String firstName;
	private String lastName;
	private String gender;
	private String emailId;
	private long mobileNo;
	//private int score;
	
	
	
	public Student(String userName, int password, String firstName, String lastName, String gender,
			String emailId, long mobileNo) {
		super();
		
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
	}

	
}


