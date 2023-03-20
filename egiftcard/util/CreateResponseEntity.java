package com.cg.egiftcard.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CreateResponseEntity {

	private boolean status;
	private String message;
	private Object data;
	private HttpStatus httpStatus;

	public CreateResponseEntity() {
		super();
	}

	public CreateResponseEntity(boolean status, String message, Object data, HttpStatus httpStatus) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
		this.httpStatus = httpStatus;
	}

	public ResponseEntity<Map<String, Object>> getResponseEntity() {
		Map<String, Object> res = new HashMap<>();
		res.put("status", this.isStatus());
		res.put("message", this.getMessage());
		res.put("data", this.getData());
		return new ResponseEntity<>(res, this.getHttpStatus());
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
