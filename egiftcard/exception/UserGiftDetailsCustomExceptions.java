package com.cg.egiftcard.exception;

import org.springframework.http.HttpStatus;

public class UserGiftDetailsCustomExceptions extends Exception {

	public HttpStatus status;

	public UserGiftDetailsCustomExceptions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public UserGiftDetailsCustomExceptions(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserGiftDetailsCustomExceptions(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserGiftDetailsCustomExceptions(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	public UserGiftDetailsCustomExceptions(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
