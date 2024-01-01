<%@page import="com.startnext.DAO.StartupDAO"%>
<%@page import="com.startnext.bean.StartupBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
			ArrayList<StartupBean> s1=StartupDAO.calal();
		%>
		
<nav class="navbar navbar-expend-lg navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href="#">StartNext</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbaarSupportedContent" aria-controls="navbarSupportedContent">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link disabled" href="index.jsp">Home<span class="sr-only">(Current)</span></a>
				</li>
			
			
			
			</ul>
		
		</div>
	</div>



</nav>
</body>
</html>