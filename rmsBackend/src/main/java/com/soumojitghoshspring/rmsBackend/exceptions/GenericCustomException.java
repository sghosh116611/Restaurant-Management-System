package com.soumojitghoshspring.rmsBackend.exceptions;

public class GenericCustomException extends RuntimeException {

	public GenericCustomException(String message, Throwable cause) {
		super(message, cause);
	}

	public GenericCustomException(String message) {
		super(message);
	}

	public GenericCustomException(Throwable cause) {
		super(cause);
	}

}
