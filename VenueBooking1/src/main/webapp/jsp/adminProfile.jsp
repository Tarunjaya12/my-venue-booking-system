<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/usersignup.css"/>
</head>
<body>
<div id="bg">
<div class="container">
<div class="card">
<h1>My Profile</h1>
<form action="adminProfileUpdate">
Name<br>
<input type="text" name="name" value="${details.name}"><br><br>
Last Name<br>
<input type="text" name="lastName" value="${updatedDetails.lastName}"><br><br>
MobileNo<br>
<input type="number" name="mobileNo" value="${updatedDetails.mobileNo}"><br><br>
Email Address<br>
<input type="text" name="emailId" value="${details.emailId}"><br><br>
Designation<br>
<input type="text" name="designation" value="${updatedDetails.designation}"><br><br>
Organization<br>
<input type="text" name="organization" value="${updatedDetails.organization}"><br><br>
<input type="submit" value="update">
</form><br><br>
<a href="adminHome"><button class="back">Home</button></a>
</div>
</div>
</div>
</body>
</html>