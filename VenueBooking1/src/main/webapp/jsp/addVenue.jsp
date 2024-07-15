<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
 	<div class="row d-flex flex-row justify-content-center">
		<div class="col-12 col-md-4 shadow text-center m-3">
			<h1>Venue Details</h1>
			<form:form class="title" action="saveVenue" enctype="multipart/form-data" method="post" modelAttribute="venue">
			<label for="name">Name</label><br>
			<input type="text" id="name" name="venueName">
			<form:errors path="venueName" cssClass="error error_msg"/><br><br>
			<label for="about">Description</label><br>
			<textarea id="about" name="venueDescription"></textarea>
			<form:errors path="venueDescription" cssClass="error error_msg"/><br><br>
			<label for="city">City</label><br>
			<input type="text" id="city" name="venueCity">
			<form:errors path="venueCity" cssClass="error error_msg"/><br><br>
			<label for="price">Price Per Day</label><br>
			<input type="text" id="price" name="pricePerDay"><br><br>
			<label for="contactNo">Contact No</label><br>
			<input type="text" id="contactNo" name="contactNo">
			<form:errors path="contactNo" cssClass="error error_msg"/><br><br>
			<label for="image">Image</label><br>
			<input class="ml-5" type="file" name="multipartfile"><br><br>
			<input class="register" type="submit" value="Add"><br><br>
			</form:form>
			<a href="adminHome"><button class="back">Home</button></a>
		</div>
	</div>
</div>
</body>
</html>