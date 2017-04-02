package com.pricing.error;

public class ProductException extends RuntimeException {

	private ErrorInfo errorInfo;

	public ProductException(ErrorInfo errorInfo){
		this.errorInfo = errorInfo;
	}
	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	
	
	
}
