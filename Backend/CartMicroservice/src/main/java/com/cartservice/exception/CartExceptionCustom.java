package com.cartservice.exception;

public class CartExceptionCustom extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CartExceptionCustom() {
		super();
	}
	
	public CartExceptionCustom(String message) {
		super(message);
	}
	
	public CartExceptionCustom(Throwable cause) {
		super(cause);
	}
	
	public CartExceptionCustom(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CartExceptionCustom(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
