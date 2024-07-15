package com.vbs.user.controller;

import java.sql.Date;
import java.util.List;

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

import com.vbs.admin.model.Venue;
import com.vbs.user.model.Booking;
import com.vbs.user.model.User;
import com.vbs.user.service.SearchService;

@Controller
public class SearchController {
	
	  @Autowired
	  private SearchService searchServiceImpl;
	  Logger logger = LoggerFactory.getLogger(SearchController.class);
	  
	  @RequestMapping("search") 
	  public String searchVenues(HttpServletRequest request,@RequestParam("city")
	  String city,Model model) 
	  { 
		  HttpSession session = request.getSession();
		  session.setAttribute("city", city);
		  List<Venue> venues = searchServiceImpl.searchVenues(city);
		  model.addAttribute("venues",venues);
		  return "displayVenues";
	  
	  
	  }
	  
	  @RequestMapping("sortBy")
	  public String sortVenues(HttpServletRequest request,@RequestParam("venueDetails") String venueDetails,Model model) {
		  HttpSession session = request.getSession();
		 String city= (String)session.getAttribute("city");
		 System.out.println(venueDetails);
		List<Venue>venues = searchServiceImpl.sort(venueDetails,city); 
		model.addAttribute("venues",venues);
		  return "displayVenues";
		  
	  }
	  
	  
	  @RequestMapping("bookingPage")
	  public String bookingPage(Model model) {
		  List<Venue> venues = searchServiceImpl.getVenues();
		  model.addAttribute("venues",venues);
		  return "booking";
	  }
	  
	  
	  
	  @RequestMapping("saveBooking")
	  public String saveBooking(HttpServletRequest request,@Valid @ModelAttribute("booking") Booking booking,BindingResult br) {
		 if(br.hasErrors()) {
			 return "booking";
		 }
		searchServiceImpl.addBooking(request,booking);
		return "userHome";
		  
	  }
	  
	  @RequestMapping("showMyBookings")
	  public String showMyBookings(HttpServletRequest request,Model model) {
		HttpSession  session = request.getSession();
		User details = (User) session.getAttribute("userDetails");
		List<Booking> myBookings = searchServiceImpl.getMyBookings(details.getEmailId());
		model.addAttribute("myBookings",myBookings);
		return "myBookings";
		  
	  }
	 
	  @RequestMapping("checkAvailability")
	  public String checkAvailability(HttpServletRequest request,@RequestParam("venueName") String venueName,Model m) {
		HttpSession  session = request.getSession();
		session.setAttribute("venueName",venueName);
		m.addAttribute("venueName",venueName);
		return "checkingPage";
		  
	  }
	  
	  @RequestMapping("check")
	  public String checking(HttpServletRequest request,@RequestParam("eventDate") Date date,Model m) {
		HttpSession  session = request.getSession();
		String venueName= (String)session.getAttribute("venueName");
		boolean result = searchServiceImpl.checkDate(date,venueName);
		if(result) {
			m.addAttribute("msg","Venue is Available");
			return "checkingPage";
			
			
		}
		m.addAttribute("msg","Venue is already booked on the given Date");
		return "checkingPage";
		  
	  }
	  
	  
	  @RequestMapping("bookingStatus")
	  public String bookingStatus(HttpServletRequest request,Model m) {
		  String status = request.getParameter("status");
		  String id = request.getParameter("bookingId");
		  System.out.println(id);
		boolean result = searchServiceImpl.addStatus(status,id);
		if(result) {
			return "adminHome";}
		return "adminHome";
		  
	  }
	  
}
