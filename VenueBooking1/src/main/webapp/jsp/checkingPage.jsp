<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/checking.css"/> 
</head>
<body>
<div id="bg">
<div class="container">
<div class="card">
<form action="check">
<h1>Check Availability</h1>
<h1>${venueName}</h1>
<h3 class="msg">${msg}</h3>
<label for="event">Event/Occasion</label>
<select name="occasion" id="occasion">
  <option value="Wedding">Wedding</option>
  <option value="BirthDay">BirthDay</option>
  <option value="Engagement">Engagement</option>
  <option value="Get Together">GetTogether</option>
</select><br><br>
<label for="name">Your Name</label>
<input type="text" id="name" name="customerName"><br><br>
<label for="eventDate">Event Date</label>
<input type="date" name="eventDate"><br><br>
<input type="submit" value="check"><br><br>
</form>
</div>
</div>
</div>
</body>
</html>