package com.example.drools.demo.exception;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.drools.demo.model.ResponseError;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(value = { AddressNotFoundException.class })
	private ResponseEntity<ResponseError> handleEntityNotFound(AddressNotFoundException ex) {
		ResponseError err = new ResponseError();
		err.setCode(HttpStatus.NOT_FOUND.value());
		err.setErrorMessages(ex.getMessage());
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

}
