<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/home.css"/> 
</head>
<body>
<div id="bg">
<div class="container">
<div class="card">
<h1>Home</h1>
<form action="search">
<h2>Search Venues</h2>
<input type="text" name="city">
<input type="submit" value="search">
</form><br><br>
<a href="profilePage"><button class="admin_button">My Profile</button></a><br><br>
<a href="updatePassword"><button class="admin_button">Update Password</button></a><br><br>
<a href="showMyBookings"><button class="admin_button">My Bookings</button></a><br><br>
<a href="userLogout"><button class="admin_button">Logout</button></a><br><br>
</div>
</div> 
</div>
</body>
</html>