package com.vbs.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbs.admin.dao.VenueDao;
import com.vbs.admin.model.Venue;
import com.vbs.user.dao.BookingDao;
import com.vbs.user.dao.PaymentDao;
import com.vbs.user.dao.UserDao;
import com.vbs.user.model.Booking;
import com.vbs.user.model.Payment;
import com.vbs.user.model.User;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired 
	private PaymentDao paymentDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private BookingDao bookingDao;
	@Autowired
	private VenueDao venueDao;
	
	@Override
	public int bookingPayment(HttpServletRequest request) {
		HttpSession  session = request.getSession();
		String bookingId = (String)session.getAttribute("bookingId");
		String venueName = (String)session.getAttribute("venueName");
		System.out.println(bookingId);
		Booking booking = bookingDao.findById(bookingId).get();
		List<Booking> book = bookingDao.findByUserEmailId(booking.getUser().getEmailId());
		Venue venue = venueDao.findByVenueName(venueName);
		int venuePrice = venue.getPricePerDay();
		if(book.size() ==1) {
			venuePrice = venuePrice - ((venuePrice*5)/100);
		}
		//int totalAmount = venuePrice+((booking.getGuests())*(booking.getBudgetPerPerson()));
		int advancePayment = ((venuePrice)*25)/100;
		return advancePayment;
		
	}

	@Override
	public Payment makePayment(HttpServletRequest request,Payment payment) {
		// TODO Auto-generated method stub
		HttpSession  session = request.getSession();
		User details = (User) session.getAttribute("userDetails");
		String bookingId = (String)session.getAttribute("bookingId");
		String venueName = (String)session.getAttribute("venueName");
		int advancePayment =(int) (session.getAttribute("advancepayment"));
		User user = userDao.findById(details.getEmailId()).get();
		Booking booking = bookingDao.findById(bookingId).get();
		Venue venue = venueDao.findByVenueName(venueName);
		payment.setBooking(booking);
		payment.setUser(user);
		payment.setVenue(venue);
		payment.setPaymentAmount(advancePayment);
		paymentDao.save(payment);
		return payment;
		
		
	}
	

}
