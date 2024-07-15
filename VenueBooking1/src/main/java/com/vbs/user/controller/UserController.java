package com.vbs.user.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import com.vbs.user.exception.UserNotFoundException;
import com.vbs.user.model.User;
import com.vbs.user.model.UserProfile;
import com.vbs.user.service.UserService;

@Controller
public class UserController {
	@Autowired 
	private UserService userService;
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("user")
	public String userStart() {
		return "userLogin";
	}
	
	@RequestMapping("userSignup")
	public String userSignup() {
		return "userSignup";
	}
	
	@RequestMapping("signup")
	public String saveSignup(@Valid @ModelAttribute("user")User user,BindingResult bindingResult,UserProfile profile) {
		if(bindingResult.hasErrors()) {
			return "userSignup";
		}
		boolean result = userService.saveUser(user,profile);
		if(result) {
			return "userLogin";
		}
		return "userSignup";
	}
	
	
	  @RequestMapping("login") 
	  public String userLogin(@Valid @ModelAttribute("user") User user,BindingResult bindingResult,@RequestParam("emailId") String emailId,@RequestParam("password")String password,HttpServletRequest request,Model model) { 
		  if(bindingResult.hasErrors()) {
			return "userLogin";
		}
		  System.out.println(emailId);
		  System.out.println(password);
		  User user1 = userService.userLogin(emailId, password);
		  if(user1 != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userDetails",user1);
			return "userHome"; 
			}
		   	model.addAttribute("msg","InvalidCredentials");
			return "userLogin";
		
	  
	  }
	 
	
	
	
	
	@RequestMapping("profilePage")
	public String userprofile(HttpServletRequest request,Model model) {
		HttpSession  session = request.getSession();
		User details = (User) session.getAttribute("userDetails");
		model.addAttribute("details",details);
		String emailId = details.getEmailId();
		UserProfile userProfile = userService.getUserProfile(emailId);
		if(userProfile != null) {
			model.addAttribute("updatedDetails",userProfile);
			return  "userProfile";
		}
		return "userProfile";
		
		
	}
	
	
	@RequestMapping("profileUpdate")
	public String updateProfile(UserProfile profile,ModelAndView model) {
		UserProfile updatedProfile = userService.saveProfile(profile);
		if(updatedProfile != null) {
			model.addObject("updatedDetails",updatedProfile);
			model.setViewName("userProfile");
		}
		return "userProfile";
	
		
	}
	
	@RequestMapping("updatePassword")
	public String updatePassword() {
		return "updateUserPassword";
	}
	
	@RequestMapping("updatePass")
	public String savePassword(HttpServletRequest request) {
		String oldpassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		HttpSession  session = request.getSession();
		User details = (User) session.getAttribute("userDetails");
		String password = details.getPassword();
		String emailId = details.getEmailId();
		if(newPassword.contentEquals(confirmPassword) && oldpassword.contentEquals(password)) {
			boolean result = userService.updatePassword(emailId,newPassword);
			if(result) {
				return "userHome";
			}
		}
		return "updateUserPassword";
	}
	
	
	@RequestMapping("home")
	public String getUserHome() {
		return "userHome";
	}
	
	@RequestMapping("userLogout")
	public String adminLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("user");
		return "userLogin";
	}
		return "userLogin";
	
	
	
	
	}
	
}
