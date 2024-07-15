package com.vbs.admin.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
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
import org.springframework.web.multipart.MultipartFile;

import com.vbs.admin.model.Admin;
import com.vbs.admin.model.Venue;
import com.vbs.admin.service.VenueService;
import com.vbs.user.model.Booking;

@Controller
public class VenueController {
	@Autowired
	private VenueService venueService;
	Logger logger = LoggerFactory.getLogger(VenueController.class);
	
	@RequestMapping("addVenue")
	public String getVenue() {
		return "addVenue";
	}
	
	@RequestMapping("saveVenue")
	public String addVenue(HttpServletRequest request,@Valid @ModelAttribute("venue") Venue venue,@RequestParam("multipartfile") MultipartFile multipartFile,BindingResult br) throws IOException, ServletException {
		if(br.hasErrors()) {
			return "addVenue";
		}
		System.out.println(venue);
		if (venueService.adminAddVenue(request,venue,multipartFile)) {
			  venueService.saveImage(multipartFile);
			  return "adminHome"; 
		  }

		return "failure";
	}
	
	@RequestMapping("showBookings")
	public String showBookings(HttpServletRequest request,Model model) {
		List<Booking> bookings = venueService.showBookings(request);
		model.addAttribute("bookings",bookings);
		return "venueBookings";
	}
	
	
	
	@RequestMapping("viewVenues")
	public String viewVenues(HttpServletRequest request,Model model) {
		HttpSession  session = request.getSession();
		Admin details = (Admin) session.getAttribute("adminDetails");
		String emailId = details.getEmailId();
		List<Venue> venues = venueService.showVenues(emailId);
		model.addAttribute("venues",venues);
		return "viewMyVenues";
		
	}
	
	@RequestMapping("updateVenue")
	public String updateVenue(Venue venue,HttpServletRequest request) {
		HttpSession  session = request.getSession();
		Admin details = (Admin) session.getAttribute("adminDetails");
		boolean result = venueService.updateVenue(venue,details);
		if(result)
			return "adminHome";
		return "failure";
		
	}
	
	
	@RequestMapping("deleteVenue")
	public String deleteVenue(Venue venue) {
		boolean result = venueService.deleteVenue(venue);
		if(result)
			return "adminHome";
		return "failure";
	}

}
