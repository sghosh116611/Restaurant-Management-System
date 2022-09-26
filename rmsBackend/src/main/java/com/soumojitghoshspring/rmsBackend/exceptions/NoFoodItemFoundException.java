package com.soumojitghoshspring.rmsBackend.exceptions;

public class NoFoodItemFoundException extends RuntimeException {

	public NoFoodItemFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoFoodItemFoundException(String message) {
		super(message);
	}

	public NoFoodItemFoundException(Throwable cause) {
		super(cause);
	}

}
