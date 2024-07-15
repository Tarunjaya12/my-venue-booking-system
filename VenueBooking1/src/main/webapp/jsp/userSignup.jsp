<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
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
<h1>Signup</h1>
<form:form class="title" action="signup" modelAttribute="user">
<label for="name">Name</label><br>
<input type="text" id="name" name="name">
<form:errors path="name" cssClass="error error_msg"/><br><br>
<label for="email">Email Id</label><br>
<input type="text" id="email" name="emailId">
<form:errors path="emailId" cssClass="error error_msg"/><br><br>
<label for="pass">Password</label><br>
<input type="password" id="pass" name="password">
<form:errors path="password" cssClass="error error_msg"/><br><br>  
<input class="register" type="submit" value="Register">
</form:form>
<a href="user"><button class="register">Login</button></a>
</div>
</div>
</body>
</html>