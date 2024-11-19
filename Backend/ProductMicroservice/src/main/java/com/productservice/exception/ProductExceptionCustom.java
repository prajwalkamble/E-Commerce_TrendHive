package com.productservice.exception;

public class ProductExceptionCustom extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ProductExceptionCustom() {
		super();
	}
	
	public ProductExceptionCustom(String message) {
		super(message);
	}
	
	public ProductExceptionCustom(Throwable cause) {
		super(cause);
	}
	
	public ProductExceptionCustom(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ProductExceptionCustom(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
