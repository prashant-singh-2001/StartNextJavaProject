<%@page import="com.startnext.utility.Hasher"%>
<%@page import="com.startnext.DAO.AdminDAO"%>
<%@page import="com.startnext.bean.AdminBean"%>
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
	AdminBean ab=new AdminBean();
	ab.setUsername("ps1215");
	ab.setPassword("ps1215");
	boolean b=AdminDAO.login(ab);
	if(b){ab=AdminDAO.getuser(ab);}
	String s=Hasher.getHash(ab.getPassword());
	 
	 %>
	 <%=s.equals(Hasher.getHash(ab.getPassword())) %>

</body>
</html>