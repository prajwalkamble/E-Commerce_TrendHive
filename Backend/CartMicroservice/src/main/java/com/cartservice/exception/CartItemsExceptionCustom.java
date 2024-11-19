package com.cartservice.exception;

public class CartItemsExceptionCustom extends Exception {

	private static final long serialVersionUID = 1L;

	public CartItemsExceptionCustom() {
    super();
	}
	
	public CartItemsExceptionCustom(String message) {
	    super(message);
	}
	
	public CartItemsExceptionCustom(Throwable cause) {
	    super(cause);
	}
	
	public CartItemsExceptionCustom(String message, Throwable cause) {
	    super(message, cause);
	}
	
	public CartItemsExceptionCustom(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	    super(message, cause, enableSuppression, writableStackTrace);
	}
}
