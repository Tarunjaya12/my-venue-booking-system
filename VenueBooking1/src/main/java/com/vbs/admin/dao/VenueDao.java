package com.vbs.admin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vbs.admin.model.Venue;


public interface VenueDao extends JpaRepository<Venue,String>{

	List<Venue> findByVenueCity(String city);

	List<Venue> findByAdminEmailId(String emailId);

	List<Venue> findAll();

	Venue findByVenueName(String venueName);

	@Query("From Venue venue where venue.venueName=?1 or venue.pricePerDay=?1 ")
	List<Venue> findByVenueDetails(String venueDetails);

	List<Venue> findByVenueCityOrderByPricePerDayDesc(String city);

	List<Venue> findByVenueCityOrderByVenueName(String venueDetails);

}
