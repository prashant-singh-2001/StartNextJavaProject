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
	AdminBean ab=new AdminBean();
	ab.setUsername("shabnam19");
	ab.setPassword("shab1902");
	ab.setFname("Shabnam");
	ab.setLname("Bhadouria");
	ab.setEmail("shab.1998.19@gmail.com");
	boolean b=AdminDAO.login(ab);
	ab=AdminDAO.getuser(ab);
	 %>
	 <%=b?Hasher.getHash(ab.getPassword())+" "+ ab.getFname()+ab.getLname():""	 %></body>	
</html>