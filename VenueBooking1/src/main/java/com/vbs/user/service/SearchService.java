package com.vbs.user.service;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.vbs.admin.model.Venue;
import com.vbs.user.model.Booking;

public interface SearchService {

	public List<Venue> searchVenues(String city);


	public void addBooking(HttpServletRequest request, Booking booking);


	public List<Venue> getVenues();


	public List<Booking> getMyBookings(String emailId);


	public boolean checkDate(Date date,String venueName);


	public boolean addStatus(String status, String id);


	public List<Venue> sort(String venueDetails,String city);

}
