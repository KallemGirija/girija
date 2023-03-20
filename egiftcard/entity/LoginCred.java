package com.cg.egiftcard.entity;

public class LoginCred {

	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginCred(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

}
