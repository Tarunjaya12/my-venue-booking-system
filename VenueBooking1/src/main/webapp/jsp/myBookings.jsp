<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/booking.css"/> 
</head>
<body>
<div>
<h1>My Bookings</h1>
<table>
	 <tr>
	 	<th>Occasion</th>
	 	<th>City</th>
	 	<th>Guests</th>
	 	<th>Mobile No</th>
	 	<th>Venue Name</th>
	 	<th>Event Date</th>
	 	<th>Status</th>
	 	<th>Payment</th>
	 </tr>
<c:forEach var="i" items="${myBookings}">
			<tr>
				<td>${i.occasion}</td>
				<td>${i.city}</td>
				<td>${i.guests}</td>
				<td>${i.mobileNo}</td>
				<td>${i.venueName}</td>
				<td>${i.eventDate}</td>
				<td>${i.status}</td>
				<td><form action="paymentPage">
					<input type="hidden" name="bookingId" value="${i.bookingId}">
					<input type="hidden" name="venueName" value="${i.venueName}">
					<input type="hidden" name="eventDate" value="${i.eventDate}">
					<input type="submit" value="make payment">
					</form>
				</td>
			</tr>
</c:forEach>
</table>
<a href="home"><button class="back">Home</button></a>
</div>
</body>
</html>