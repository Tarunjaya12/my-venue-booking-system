<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#bookError{
color:red;
}
</style>
<link rel="stylesheet" type="text/css" href="CSS/usersignup.css"/>
</head>
<body>
<div id="bg">
<div class="container">
<div class="card">
<h3 id="bookError">${msg}</h3>
<form:form class="title" action="saveBooking" modelAttribute="booking">
<h1>Book Venue</h1>
<label for="event">Event/Occasion</label><br>
<select name="occasion" id="occasion">
  <option value="Wedding">Wedding</option>
  <option value="BirthDay">BirthDay</option>
  <option value="Engagement">Engagement</option>
  <option value="Get Together">GetTogether</option>
</select><br><br>
<label for="city">City</label><br>
<select name="city" id="city">
 <c:forEach var="i" items="${venues}">
  <option value="${i.venueCity}"><c:out value="${i.venueCity}"/></option>
  </c:forEach>
</select><br><br>
<label for="venue">Venue Name</label><br>
<select name="venueName" id="venue">
  <c:forEach var="i" items="${venues}">
  <option value="${i.venueName}"><c:out value="${i.venueName}"/></option>
  </c:forEach>
</select><br><br>
<label for="guests">No of Guests</label><br>
<input type="number" id="guests" name="guests"><br><br>
<label for="budget">Budget per Person</label><br>
<input type="number" id="budget" name="budgetPerPerson"><br><br>
<label for="mobile">Mobile No</label><br>
<input type="number" id="mobile" name="mobileNo">
<form:errors path="mobileNo" cssClass="error error_msg"/><br><br>
<label for="name">Your Name</label><br>
<input type="text" id="name" name="customerName">
<form:errors path="customerName" cssClass="error error_msg"/><br><br>
<label for="eventDate">Event Date</label><br>
<input type="date" name="eventDate"><br><br>
<input class="register"type="submit" value="book">
</form:form><br><br>
<a href="home"><button class="back">Back</button></a>
</div>
</div>
</div>



</body>
</html>