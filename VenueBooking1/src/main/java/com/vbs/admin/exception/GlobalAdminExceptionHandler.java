package com.vbs.admin.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vbs.admin.controller.AdminController;

@ControllerAdvice
public class GlobalAdminExceptionHandler {
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	@ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException elementException){
        return new ResponseEntity<String>("Requested product doesn't exist : ",HttpStatus.NOT_FOUND);
    }
	
	
	
	  @ExceptionHandler(AdminAlreadyExistsException.class) 
	  public String handleAdminAlreadyExistsException(AdminAlreadyExistsException elementException,Model model){ 
		  logger.error("AdminAlreadyExistsException: "+" "+elementException.getErrorMessage());
	   model.addAttribute("msg", "AdminAlreadyExistsException: "+elementException.getErrorCode()+" "+elementException.getErrorMessage());
	   return "failure";
	  }
	  
	  @ExceptionHandler(AdminNotFoundException.class) 
	  public String handleAdminNotFoundException(AdminNotFoundException elementException,Model model){ 
		  logger.error("AdminNotFoundException: "+" "+elementException.getErrorMessage());
		  model.addAttribute("msg","AdminNotFoundException: "+elementException.getErrorCode()+" "+elementException.getErrorMessage());
		return "loginfailure";
	  }
	  
	  
	 
}
