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
<h1>Bookings</h1>
<table>
	 <tr>
	 	<th>Occasion</th>
	 	<th>Venue Name</th>
	 	<th>City</th>
	 	<th>Guests</th>
	 	<th>Mobile No</th>
	 	<th>Customer Name</th>
	 	<th>Event Date</th>
	 	<th>Status</th>
	 </tr>
<c:forEach var="i" items="${bookings}">
			<tr>
				<td>${i.occasion}</td>
				<td>${i.venueName}</td>
				<td>${i.city}</td>
				<td>${i.guests}</td>
				<td>${i.mobileNo}</td>
				<td>${i.customerName}</td>
				<td>${i.eventDate}</td>
				<td><form action="bookingStatus">
					<input type="hidden" name="bookingId" value="${i.bookingId}">
					<select name="status" id="bookingStatus">
  						<option value="confirm">Confirm</option>
  						<option value="pending">Pending</option>
					</select>
					<input type="submit" value="submit">
					</form>
				</td>
			</tr>
</c:forEach>
</table>
<a href="adminHome"><button class="back">Home</button></a>
</div>
</body>
</html>