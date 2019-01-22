package com.java.exception;

public class InvalidAccountException extends Exception {

	private static final long serialVersionUID = -9003932154029680889L;

	public InvalidAccountException(String message) {
		super(message);
	}
}
