package com.vbs.user.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vbs.user.model.Booking;

public interface BookingDao extends JpaRepository<Booking,String> {

	@Query("SELECT t FROM Booking t WHERE t.venueName=?1")
	List<Booking> findByVenueName(String name);

	List<Booking> findByUserEmailId(String emailId);

	List<Booking> findByVenueVenueId(String string);

	@Query("From Booking b where b.eventDate=?1 and b.venueName=?2")
	Booking findByEventDate(Date date, String venueName);

	Booking findByEventDate(Date date);

}
