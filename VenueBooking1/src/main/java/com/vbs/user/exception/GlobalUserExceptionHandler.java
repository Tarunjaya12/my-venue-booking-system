	package com.vbs.user.exception;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vbs.admin.controller.AdminController;
import com.vbs.user.model.User;

@ControllerAdvice
public class GlobalUserExceptionHandler {
	Logger logger = LoggerFactory.getLogger(AdminController.class);

	@ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException elementException){
        return new ResponseEntity<String>("Requested product doesn't exist : ",HttpStatus.NOT_FOUND);
    }
	
	
	
	  @ExceptionHandler(UserAlreadyExistsException.class) 
	  public String handleUserAlreadyExistsException(UserAlreadyExistsException elementException,Model model){ 
		  logger.error("UserAlreadyExistsException: "+" "+elementException.getErrorMessage());	   
		  model.addAttribute("msg","UserAlreadyExistsException: "+elementException.getErrorCode()+" "+elementException.getErrorMessage());
		  return "failure";
	  }
	  
	  @ExceptionHandler(UserNotFoundException.class) 
	  public String handleUserNotFoundException(UserNotFoundException elementException,Model model){ 
		  logger.error("UserNotFoundException: "+" "+elementException.getErrorMessage());
		  model.addAttribute("msg","UserNotFoundException: "+elementException.getErrorCode()+" "+elementException.getErrorMessage());
		  return "loginfailure";
	  }
	  
	  
	  @ExceptionHandler(VenueAlreadyBookedException.class) 
	  public String handleVenueAlreadyBookedException(VenueAlreadyBookedException elementException,Model model,HttpServletRequest request){
		  HttpSession  session = request.getSession();
			User user = (User) session.getAttribute("userDetails");
			logger.error("Venue Already Booked"+user.getEmailId());
		  logger.error("VenueAlreadyBookedException: "+" "+elementException.getErrorMessage());
		  model.addAttribute("msg","VenueAlreadyBookedException: "+elementException.getErrorCode()+" "+elementException.getErrorMessage());
		  return "booking";
	  }
	  
	  
	 
}
