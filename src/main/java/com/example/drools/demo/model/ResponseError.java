package com.example.drools.demo.model;

import java.util.List;

public class ResponseError {
	private Integer code;
	private List<String> errorMessages;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

}
