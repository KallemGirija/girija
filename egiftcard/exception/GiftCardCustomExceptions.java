package com.cg.egiftcard.exception;

import org.springframework.http.HttpStatus;

public class GiftCardCustomExceptions extends Exception {

	public HttpStatus status;

	public GiftCardCustomExceptions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiftCardCustomExceptions(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public GiftCardCustomExceptions(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public GiftCardCustomExceptions(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public GiftCardCustomExceptions(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
