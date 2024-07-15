package com.vbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vbs.admin.dao.AdminDao;
import com.vbs.admin.dao.AdminProfileDao;
import com.vbs.admin.dao.VenueDao;
import com.vbs.admin.model.Admin;
import com.vbs.admin.model.AdminProfile;
import com.vbs.admin.model.Venue;
import com.vbs.admin.service.AdminService;
import com.vbs.admin.service.VenueService;
import com.vbs.user.service.SearchServiceImpl;

@SpringBootTest
class VenueBooking1ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private AdminDao adminDao;

	@Autowired
	private AdminProfileDao adminProfileDao;

	@Autowired
	private AdminService adminService;

	@Autowired
	private VenueDao venueDao;

	@Autowired
	private VenueService venueService;
	@Autowired
	private SearchServiceImpl searchServiceImpl;

	@Test
	public void testadminLogin() {
	Admin admin = new Admin();
	admin.setEmailId("pg@gmail.com");
	admin.setPassword("12345678");
	assertNotNull(adminService.adminLogin(admin.getEmailId(), admin.getPassword()));
	}

	@Test
	public void testsaveAdmin() {
	Admin admin = new Admin();
	AdminProfile amp = new AdminProfile();
	admin.setName("ABC");
	admin.setPassword("12345678");
	admin.setEmailId("ar123@gmail.com");
	amp.setEmailId("ar123@gmail.com");
	adminService.saveAdmin(admin, amp);
	assertNotNull(adminDao.findById("ar123@gmail.com"));
	}

	@Test
	public void testsaveAdminProfile() {
	AdminProfile adminProfile = new AdminProfile();
	adminProfile.setEmailId("pg@gmail.com");
	assertNotNull(adminService.saveAdminProfile(adminProfile));

	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testupdateAdminPassword() {
	Admin admin = new Admin();
	admin.setEmailId("pg@gmail.com");
	admin.setName("Praveena");
	admin.setPassword("12345678");
	assertNotNull(adminService.updateAdminPassword(admin.getEmailId(), admin.getPassword()));
	equals(adminDao.findById(admin.getEmailId()).get());
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testgetAdminProfile()
	{
	AdminProfile adminProfile = new AdminProfile();
	adminProfile.setEmailId("pg@gmail.com");
	assertNotNull(adminService.getAdminProfile(adminProfile.getEmailId()));
	equals(adminProfileDao.findById(adminProfile.getEmailId()).get());
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testadminAddVenue() {
	Admin admin = new Admin();
	Venue venue = new Venue();
	admin.setEmailId("pg@gmail.com");
	venue.setContactNo("1234567890");
	venue.setVenueCity("Vizag");
	venue.setVenueCity("weddings");
	venue.setVenueImage("http://localhost:8080/images/");
	venue.setVenueId("V_00006");
	venue.setVenueName("KK_Conventuions");
	equals(venueDao.findAll());

	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testshowBookings() {
	Admin admin = new Admin();
	admin.setEmailId("pg@gmail.com");
	equals(venueDao.findByAdminEmailId(admin.getEmailId()));

	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testshowVenues() {
	Admin admin = new Admin();
	admin.setEmailId("pg@gmail.com");
	equals(venueDao.findByAdminEmailId(admin.getEmailId()));
	}

	@Test
	public void testupdateVenue() {
	Admin admin = new Admin();
	Venue venue = new Venue();
	admin.setEmailId("pg@gmail.com");
	venue.setAdmin(admin);
	assertNotNull(venueService.updateVenue(venue, admin));
	}

	@Test
	public void testdeleteVenue() {
	Venue venue = new Venue();
	venue.setVenueId("V_00001");
	assertNotNull(venueService.deleteVenue(venue));
	}
	
	@Test
	public void testCheckAvailability(HttpServletRequest request) throws ParseException {
		HttpSession  session = request.getSession();
		String venueName= (String)session.getAttribute("venueName");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-yy");

		System.out.print("Time period (YYYY-mm-yy): ");
		String sTime = "2022-06-06";

		Date date = (Date) dateFormat.parse(sTime);
		boolean result = searchServiceImpl.checkDate(date,venueName);
		assertEquals("true",result);
	}
	


}
