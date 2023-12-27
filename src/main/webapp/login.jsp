<%@page import="com.startnext.DAO.UserDAO"%>
<%@page import="com.startnext.bean.AdminBean"%>
<%@page import="java.util.List"%>
<%@page import="com.startnext.utility.DummyClass"%>
<%@page import="com.startnext.utility.Hasher"%>
<%@page import="com.startnext.DAO.AdminDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.startnext.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login : StartNext</title>
</head>
<body>
	<%
	UserBean ub = new UserBean();
	ub.setUsername("maharani");
	ub.setPassword("Lala@101");
	UserBean b=UserDAO.login(ub);
	%>
	<%=b!=null?b.toString():"OFO" %></body>
</html>