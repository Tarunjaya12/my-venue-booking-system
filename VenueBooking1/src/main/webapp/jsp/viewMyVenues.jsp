<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/usersignup.css"/>
</head>
<body>
<div class="container">
<div class="card">
			<h1>Venue Details</h1>
		<c:forEach var="i" items="${venues}">
			<form>
			<label for="venueId">venueId</label><br>
			<input type="text" name="venueId" value="${i.venueId}"><br><br>
			<label for="name">Name</label><br>
			<input type="text" id="name" name="venueName" value="${i.venueName}"><br><br>
			<label for="about">Description</label><br>
			<input type="text" id="about" name="venueDescription" value="${i.venueDescription}"><br><br>
			<label for="city">City</label><br>
			<input type="text" id="city" name="venueCity" value="${i.venueCity}"><br><br>
			<label for="image">Image</label><br>
			<input type="text" name="venueImage" value="${i.venueImage}"><br><br>
			<label for="contactNo">Contact No</label><br>
			<input type="text" id="contactNo" name="contactNo" value="${i.contactNo}"><br><br>
			<div>
			<input class="register" type="submit" value="Update" formaction="updateVenue">
			</div>
			<div>
			<input class="register" type="submit" value="Delete" formaction="deleteVenue">
			</div>
			</form>
		</c:forEach>
</div>
</div>

</body>
</html>