package com.soumojitghoshspring.rmsBackend.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.soumojitghoshspring.rmsBackend.exceptions.NoFoodItemFoundException;
import com.soumojitghoshspring.rmsBackend.exceptions.model.FoodItemExceptionModel;

@ControllerAdvice
public class FoodItemExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<FoodItemExceptionModel> handleException(NoFoodItemFoundException exc) {

		FoodItemExceptionModel error = new FoodItemExceptionModel();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return the response entity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler
	public ResponseEntity<FoodItemExceptionModel> handleException(Exception exc) {

		FoodItemExceptionModel error = new FoodItemExceptionModel();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return the response entity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

}
