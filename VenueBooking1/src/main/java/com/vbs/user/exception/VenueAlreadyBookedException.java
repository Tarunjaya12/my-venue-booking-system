package com.vbs.user.exception;

public class VenueAlreadyBookedException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String errorCode;
    private String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

 
    public String getErrorMessage() {
        return errorMessage;
    }

 
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public VenueAlreadyBookedException(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

 
    public VenueAlreadyBookedException() {
        super();
        // TODO Auto-generated constructor stub
    }


}
