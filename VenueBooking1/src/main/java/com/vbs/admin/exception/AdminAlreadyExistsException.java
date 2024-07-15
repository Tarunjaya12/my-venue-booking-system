package com.vbs.admin.exception;

public class AdminAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String errorCode;
    private final String errorMessage;
    
    public AdminAlreadyExistsException(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    
    

    public String getErrorCode() {
        return errorCode;
    }

    

 
    public String getErrorMessage() {
        return errorMessage;
    }

 
   

    

 
   
}
