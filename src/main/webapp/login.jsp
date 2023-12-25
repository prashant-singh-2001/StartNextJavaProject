<%@page import="com.startnext.DAO.StartupDAO"%>
<%@page import="com.startnext.bean.StartupBean"%>
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
	ArrayList<StartupBean> all = StartupDAO.calal(); %>
	<%=all.size() %>
</body>
</html>