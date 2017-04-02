package com.pricing.error;

import com.pricing.error.enums.EnumErrorId;

public class ErrorInfo {

	private String errorId;
    private String errorMessage;
    private int status;
    
  public ErrorInfo(int status,EnumErrorId id, String errorMessage) {
	this.status = status;  
    this.errorId = id.name();      
    this.errorMessage = errorMessage;    
  }

  public String getErrorId() {
    return errorId;
  }

  public void setErrorId(String errorId) {
    this.errorId = errorId;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
  
   public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
