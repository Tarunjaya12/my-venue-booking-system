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
<div id="bg">
<div class="container">
<div class="card">
<h3 class="error_msg">${msg}</h3>
<h1>User Login</h1>
<form:form class="title" action="login" modelAttribute="user">
<label for="email">Email Id</label><br>
<input type="text" id="email" name="emailId"><br>
<form:errors path="emailId" cssClass="error error_msg"/><br><br>
<label for="pass">Password</label><br>
<input type="password" id="pass" name="password"><br>
<form:errors path="password" cssClass="error error_msg"/><br><br>
<input class="register" type="submit" value="Login">
</form:form>
<p>Don't have an Account</p>
<a href="userSignup"><button class="register">Signup</button></a>
<a href="index.html"><button class="back">Back</button></a>
</div>
</div>
</div>
</body>
</html>