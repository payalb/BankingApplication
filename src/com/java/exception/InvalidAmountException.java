package com.java.exception;

public class InvalidAmountException extends Exception {

	private static final long serialVersionUID = 9048095911829340468L;

	public InvalidAmountException(String message) {
		super(message);
	}
}
