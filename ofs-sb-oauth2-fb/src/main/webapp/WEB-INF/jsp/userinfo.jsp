<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Your Facebook Registered Email : ${userprofile.getEmail()}</h1>
	<h1>Your Facebook Registered First Name : ${userprofile.getFirstName()}</h1>
	<h1>Your Facebook Registered Last Name : ${userprofile.getLastName()}</h1>
</body>
</html>