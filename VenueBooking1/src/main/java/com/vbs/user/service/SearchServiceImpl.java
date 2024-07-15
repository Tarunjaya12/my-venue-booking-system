package com.vbs.user.service;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbs.admin.dao.VenueDao;
import com.vbs.admin.model.Venue;
import com.vbs.user.dao.BookingDao;
import com.vbs.user.dao.UserDao;
import com.vbs.user.exception.VenueAlreadyBookedException;
import com.vbs.user.model.Booking;
import com.vbs.user.model.User;



@Service
public class SearchServiceImpl implements SearchService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private VenueDao venueDao;
	@Autowired
	private BookingDao bookingDao;
	
	@Override
	public List<Venue> searchVenues(String city) {
		// TODO Auto-generated method stub
		List<Venue> venues = venueDao.findByVenueCity(city);
		return venues;
	}

	@Override
	public void addBooking(HttpServletRequest request,Booking booking) {
		// TODO Auto-generated method stub
		Date date = booking.getEventDate();
		Booking booking1 = bookingDao.findByEventDate(date);
		if(booking1 == null) {
		HttpSession  session = request.getSession();
		User user = (User) session.getAttribute("userDetails");
		System.out.println(user.getEmailId());
		User user1 = userDao.findById(user.getEmailId()).get();
		Venue venue = venueDao.findByVenueName(booking.getVenueName());
		booking.setUser(user1);
		booking.setVenue(venue);
		bookingDao.save(booking);}
		else {
			throw new VenueAlreadyBookedException("705","Venue Already booked on the given Date");
		}
		
		
	}

	@Override
	public List<Venue> getVenues() {
		// TODO Auto-generated method stub
		List<Venue>venues = venueDao.findAll(); 
		return venues;
	}
	
	@Override
	public List<Booking> getMyBookings(String emailId) {
		// TODO Auto-generated method stub
		List<Booking> bookings = bookingDao.findByUserEmailId(emailId);
		return bookings;
	}

	@Override
	public boolean checkDate(Date date, String venueName) {
		// TODO Auto-generated method stub
		Booking booking = bookingDao.findByEventDate(date,venueName);
		if(booking != null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean addStatus(String status, String id) {
		// TODO Auto-generated method stub
		Booking booking = bookingDao.findById(id).get();
		booking.setStatus(status);
		bookingDao.save(booking);
		return true;
		
	}

	@Override
	public List<Venue> sort(String venueDetails,String city) {
		// TODO Auto-generated method stub 
		
		if(venueDetails.contentEquals("price")) {
			List<Venue> venues = venueDao.findByVenueCityOrderByPricePerDayDesc(city);
			for(Venue v:venues) {
				System.out.println(venueDetails);
				System.out.println(v.getPricePerDay());
			}
			return venues;
		}else {
			List<Venue> venues = venueDao.findByVenueCityOrderByVenueName(city);
			return venues;
		}
	
		
		
		
	}
	
	

}
