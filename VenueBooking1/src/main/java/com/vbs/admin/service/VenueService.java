package com.vbs.admin.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.vbs.admin.model.Admin;
import com.vbs.admin.model.Venue;
import com.vbs.user.model.Booking;

public interface VenueService {

	public boolean adminAddVenue(HttpServletRequest request,Venue venue, MultipartFile multipartFile);

	public void saveImage(MultipartFile multipartFile);
	
	public List<Booking> showBookings(HttpServletRequest request);

	public List<Venue> showVenues(String emailId);

	public boolean updateVenue(Venue venue,Admin details);

	public boolean deleteVenue(Venue venue);

}
