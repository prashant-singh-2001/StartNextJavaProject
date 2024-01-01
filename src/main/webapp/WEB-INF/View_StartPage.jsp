<%@page import="java.util.ArrayList"%>
<%@page import="com.startnext.DAO.UserDAO"%>
<%@page import="com.startnext.bean.UserBean"%>
<%@page import="com.startnext.bean.StartupBean"%>
<%@page import="com.startnext.bean.StUsBean"%>
<%@page import="com.startnext.DAO.StartupDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%StartupBean sb= new StartupBean();
UserBean ub = new UserBean();
sb.setId(1);
StUsBean su=StartupDAO.byid(sb, ub); %>



<div class="container">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"><a class="navbar-brand" href"#">StartNext</a>
		<button class="navbar-toggler" tye="button" data-toggle="collapse" data-target="#navbarSupportContent1" aria-controls=""></button>
		<div class="collapse navbar-collapse" id="navbarSupportContent1">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="index.jsp"></a>Home<span class="sr-only">Current</span></li>
				<li class="nav-item"><a class="nav-link" href="View_StartPage.jsp"></a>All StartUps</li>
				<li class="nav-item"><a class="nav-link disabled" href="profile.jsp"></a>Profile</li>
							
			</ul>
			<form>
				<img style="margin-left:5px" src="" height="37px" width="35px">
			</form>
		</div>
	</nav>
</div>
<div class="container">
	<table>
		<tbody>
			<tr>
				<td width="18%"><img src="" height="150px" weight="250px" alt=""/></td>
				<td width="81%"><h2 align="center">Welcome, <%=ub.getFname() %></h2>
					<i><b>@<%=ub.getUsername()  %><br></b></i><br>
					Name:<%=ub.getFname() +" "+ ub.getLname()  %><br>
					Mail:<%=ub.getMail()%><br>
					<%if(ub.getContact()!=0) %>
					Contact Number:<%=ub.getContact() %><br>
					<!--<%//if(ub.getStart_id()!=null) %>
					StartUp Established: <%//StartupDAO.getname(ub.getStart_id()) %><br> 
					 -->
				</td>
			</tr>
		</tbody>
	</table>

<hr>
<hr>
</div>


<%ArrayList<StartupBean> slist=UserDAO.liked(ub.getId()); %>
<div class="container">
	<%for(StartupBean sb:slist){ %>
	<form action="strtvie w.jsp">
		<table width="100%" border="0">
			<tbody>
				<tr>
					<td width="28%" align="center"><img alt="<%=sb.getName() %>" src="<%=sb.getImg() %>" width="300px" height="150px"></td>
					<td width="50%" style="padding-left:50px">
						<label>StartNext ID:</label><br><input type="text" disabled="true" name="stid" class="form-control col-sm-1" value="<%=sb.getId()%>" ><br><br>
						Name:<%=sb.getName() %><br><br>
						In Field:<%=sb.getField() %><br><br>
						<%if(sb.getFounder()!=null){
							out.println("Founded by:");
							Connection con = DBUtil.connect();
							PreparedStatement ps=con.PreparedStatement("select fname, lname from user_details where startup_id'" +sb.getFounder()+"';");
							ResultSet rs=ps.ExecuteQuery();
							while(rs.next()){
								out.println(rs.getString(1)+" "+rs.getString(2));
							}
						}
						%><br><br>
						
					</td>
					<td width="20%">
					<%session.setAttribute("stid",sb.getId()); %>
					<input type="submit" value="View Startup" class="btn btn-light btn-outline-danger">
					
					</td>
				</tr>
			
			</tbody>
		
		</table>
	</form>
	<%} %>

</div>

</body>
</html>