<%@page import="com.startnext.DAO.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.startnext.bean.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<title>Signup Processing</title>
</head>
<body>
	<%
	// Retrieve form data
	String fname = request.getParameter("fname");
	String lname = request.getParameter("lname");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String mail = request.getParameter("mail");
	long contact=Long.parseLong(request.getParameter("contact"));
	// Create a UserBean object and set the properties
	UserBean user = new UserBean();
	user.setFname(fname);
	user.setLname(lname);
	user.setUsername(username);
	user.setPassword(password);
	user.setMail(mail);
	user.setContact(contact);
	UserBean b = UserDAO.signup(user);
	if (b != null) {
		out.println("<h1>User Signup Details:</h1>");
		out.println("<p>" + user.toString() + "</p>");
	}
	else{
		out.println("What Happend!");
	}
	%>
</body>
</html>
