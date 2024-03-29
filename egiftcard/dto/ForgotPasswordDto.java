package com.cg.egiftcard.dto;

public class ForgotPasswordDto {

	public String email;

	public String oldPassword;

	public String newPassword;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "ForgotPasswordDto [email=" + email + ", oldPassword=" + oldPassword + ", newPassword=" + newPassword
				+ "]";
	}

}
