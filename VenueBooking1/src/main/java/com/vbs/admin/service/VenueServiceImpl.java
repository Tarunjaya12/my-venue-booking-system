package com.vbs.admin.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vbs.admin.dao.AdminDao;
import com.vbs.admin.dao.VenueDao;
import com.vbs.admin.model.Admin;
import com.vbs.admin.model.Venue;
import com.vbs.user.dao.BookingDao;
import com.vbs.user.model.Booking;

@Service
public class VenueServiceImpl implements VenueService {
	@Autowired
	private VenueDao venueDao;
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private BookingDao bookingDao;

	@Override
	public boolean adminAddVenue(HttpServletRequest request,Venue venue, MultipartFile multipartFile) {
		// TODO Auto-generated method stub
		String fileName=multipartFile.getOriginalFilename();
		String filePath=null;
		System.out.println(fileName);
		if(fileName.contains("..")) 
		{
			//throw new fileNameException()
		}
		else {
			HttpSession  session = request.getSession();
			Admin details = (Admin) session.getAttribute("adminDetails");
			Admin admin = adminDao.findById(details.getEmailId()).get();
			filePath = "http://localhost:8080/images/" + fileName; /* +category.getCategoryTitle()+"/" */
			System.out.println(filePath);
			venue.setVenueImage(filePath);
			venue.setAdmin(admin);
			venueDao.save(venue);
		}
		return true;
	
	}

	@Override
	public void saveImage(MultipartFile multipartFile) {
		// TODO Auto-generated method stub
		String fileName=multipartFile.getOriginalFilename();
		System.out.println(fileName);
		String directoryPath=null;
		if(fileName.contains("..")) 
		{
			//throw new fileNameException()
		}
		else {
			Path currentRelativePath = Paths.get("");
			Path s = currentRelativePath.toAbsolutePath();
			System.out.println(s);
			directoryPath = s + "/src/main/resources/static/images/";
			System.out.println(directoryPath);
			Path path=Paths.get(directoryPath);
			File file=new File(directoryPath);
			System.out.println(file);
			if(!file.exists()) {
				try {
					file.createNewFile();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try(InputStream inputStream=multipartFile.getInputStream()){
				Path filePath=path.resolve(fileName);
				System.out.println(filePath);
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			}
			catch (IOException ioe) {        
				//throw new IOException("Could not save image file: " + fileName, ioe);
				ioe.printStackTrace();
	        } 
		}
	}

	
	@Override
	public List<Booking> showBookings(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession  session = request.getSession();
		Admin details = (Admin) session.getAttribute("adminDetails");
		System.out.println(details.getEmailId());
		List<Venue> venues = venueDao.findByAdminEmailId(details.getEmailId());
		List<Booking> bookings = new ArrayList<Booking>();
		for(Venue venue:venues) {
			//String name = venue.getVenueName();
			List<Booking> booking = bookingDao.findByVenueVenueId(venue.getVenueId());
			bookings.addAll(booking);
		}
		return bookings;
		
	}

	@Override
	public List<Venue> showVenues(String emailId) {
		// TODO Auto-generated method stub
		List<Venue> venues = venueDao.findByAdminEmailId(emailId);
		return venues;
	}
	
	@Override
	public boolean updateVenue(Venue venue,Admin details) {
		// TODO Auto-generated method stub
		Admin admin = adminDao.findById(details.getEmailId()).get();
		venue.setAdmin(admin);
		venueDao.save(venue);
		return true;
	}
	
	@Override
	public boolean deleteVenue(Venue venue) {
		venueDao.delete(venue);;
		return true;
	}
}
