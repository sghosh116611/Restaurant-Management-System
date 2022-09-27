package com.soumojitghoshspring.rmsBackend.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.soumojitghoshspring.rmsBackend.exceptions.GenericCustomException;
import com.soumojitghoshspring.rmsBackend.exceptions.model.GenericExceptionModel;

@ControllerAdvice
public class GenericExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<GenericExceptionModel> handleException(GenericCustomException exc) {

		GenericExceptionModel error = new GenericExceptionModel();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return the response entity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler
	public ResponseEntity<GenericExceptionModel> handleException(Exception exc) {

		GenericExceptionModel error = new GenericExceptionModel();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return the response entity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

}
