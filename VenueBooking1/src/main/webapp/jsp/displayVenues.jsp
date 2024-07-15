<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" contentType="text/html; charset="ISO-8859-1">
<title>Add Products</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="CSS/displayVenues.css"/>

</head>
<body>
 <div class="container">
 <h1>Venues</h1>
<form action="sortBy">
<select name="venueDetails" id="occasion">
  <option value="name">VenueNames</option>
  <option value="price">Price</option>
</select><br><br>
<input type="submit" value="submit">
</form>
<c:forEach items="${venues}" var="i">
<div class="pt-5 pb-5">
     
          <div class="row">
				<div class="col-12 col-md-6 shadow">
						<div class="venue_container mb-3">
								<img class="venue_image" src="${i.venueImage}">
								
								<div class="p-3">
									<h1 class="venue_name">${i.venueName}</h1>
									<p class="card-text">${i.venueCity}</p>
									<p class="card-text">${i.venueDescription}</p>
									<p class="card-text">${i.pricePerDay}</p>
									<div class="d-flex flex-row justify-content-center">
									<a class="read" href="bookingPage"><button class="m-2 book_button" >Book</button></a>
									<form action="checkAvailability">
									<input type="hidden" name="venueName" value="${i.venueName}">
									<input class="check_button" type="submit" value="CheckAvailability">
									</form>
									</div>
								</div>
						</div>
				</div>
		</div><br><br>
		
	
</div>
</c:forEach>
<a href="home"><button class="admin_button">Home</button></a>
</div>					
</body>
</html>


