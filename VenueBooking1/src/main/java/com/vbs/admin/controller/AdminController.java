package com.vbs.admin.controller;

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

import com.vbs.admin.model.Admin;
import com.vbs.admin.model.AdminProfile;
import com.vbs.admin.service.AdminService;

@Controller
public class AdminController {
	@Autowired 
	private AdminService adminService;
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping("admin")
	public String adminStart() {
		return "adminLogin";
	}
	
	@RequestMapping("adminSignup")
	public String adminSignup() {
		return "adminSignup";
	}
	
	@RequestMapping("adminsignup")
	public String saveSignup(@Valid @ModelAttribute("admin")Admin admin,BindingResult bindingResult,AdminProfile adminProfile) {
		if(bindingResult.hasErrors()) {
			return "adminSignup";
		}else {
		boolean result = adminService.saveAdmin(admin,adminProfile);
		if(result)
			return "adminLogin";
		return "adminSignUp";
		}
		
	}
	
	@RequestMapping("adminlogin")
	public String userLogin(HttpServletRequest request,@Valid @ModelAttribute("admin") Admin admin,BindingResult bindingResult,@RequestParam("emailId") String emailId,@RequestParam("password") String password,Model model) {
		if(bindingResult.hasErrors()) {
			return "adminLogin";
		}else {
		Admin admin1 = adminService.adminLogin(emailId, password);
		if(admin1 != null) {
		HttpSession session = request.getSession();
		session.setAttribute("adminDetails",admin1);
		return "adminHome";
		}
		model.addAttribute("msg","InvalidCredentials");
		return "adminLogin";	
		}	
		
	}
	
	
	@RequestMapping("adminProfilePage")
	public String adminProfile(HttpServletRequest request,Model model) {
		HttpSession  session = request.getSession();
		Admin details = (Admin) session.getAttribute("adminDetails");
		model.addAttribute("details",details);
		String emailId = details.getEmailId();
		AdminProfile adminProfile = adminService.getAdminProfile(emailId);
		if(adminProfile != null) {
			model.addAttribute("updatedDetails",adminProfile);
			return  "adminProfile";
		}
		return "adminProfile";
	}
	
	
	@RequestMapping("adminProfileUpdate")
	public String updateAdminProfile(AdminProfile adminProfile,ModelAndView model) {
		AdminProfile updatedAdminProfile = adminService.saveAdminProfile(adminProfile);
		if(updatedAdminProfile != null) {
			model.addObject("updatedDetails",updatedAdminProfile);
			model.setViewName("adminProfile");
		}
		return "adminProfile";
	
		
	}
	
	@RequestMapping("updateAdminPassword")
	public String updateAdminPassword() {
		return "updateAdminPassword";
	}
	
	@RequestMapping("updateAdminPass")
	public String saveAdminPassword(HttpServletRequest request) {
		String oldpassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		HttpSession  session = request.getSession();
		Admin details = (Admin) session.getAttribute("adminDetails");
		String password = details.getPassword();
		String emailId = details.getEmailId();
		if(newPassword.contentEquals(confirmPassword) && oldpassword.contentEquals(password)) {
			boolean result = adminService.updateAdminPassword(emailId,newPassword);
			if(result) {
				return "adminHome";
			}
		}
		return "updateAdminPassword";
	}
	
	@RequestMapping("adminHome")
	public String getBackHome() {
		return "adminHome";
	}
	
	@RequestMapping("adminLogout")
	public String adminLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("admin");
		return "adminLogin";
	}
		return "adminLogin";
	
	}
	
	
}
