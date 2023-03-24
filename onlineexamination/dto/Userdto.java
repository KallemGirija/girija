package com.cg.onlineexamination.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Userdto {
	
	
	private String firstName;
	private String lastName;
	private String password;
	private long phoneNumber;
	private String gender;
	private String emailId;

}
