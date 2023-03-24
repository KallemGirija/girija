package com.cg.onlineexamination.util;

import org.springframework.stereotype.Component;

import com.cg.onlineexamination.dto.TestQuestiondto;
import com.cg.onlineexamination.dto.Userdto;
import com.cg.onlineexamination.entity.TestQuestion;
import com.cg.onlineexamination.entity.User;

@Component
public class UserDtoConvertor {
	
	public Userdto getUserdto(User u)
	{ 
		return new Userdto(u.getFirstName(),u.getLastName(),u.getPassword(),u.getPhoneNumber(),u.getGender(),u.getEmailId());
	}

	
		

}
