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
<h1>Update Password</h1>
<form action="updateAdminPass">
Old Password<br>
<input type="password" name="oldPassword"><br><br>
New Password<br>
<input type="password" name="newPassword"><br><br>
Confirm Password<br>
<input type="password" name="confirmPassword"><br><br>
<input type="submit" value="submit">
</form>
<a href="home"><button class="back">Home</button></a>
</div>
</div>
</div>
</body>
</html>