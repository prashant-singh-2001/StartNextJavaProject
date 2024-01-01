<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table width="100%" border="0px" align="center">
		<tbody>
		<tr>
			<td width = "33%" height="168">&nbsp;</td>
			<td width = "33%">&nbsp;</td>
			<td width = "33%">&nbsp;</td>
		</tr>
		<tr>
			<td height="509">&nbsp;</td>
			<td valign="middle" class="ted">
				<div class="container" align="center">
				<h1>ADMIN LOGIN</h1>
				<img src="" class="rounded ig-fluid" alt="Login #StartNext" height="200px" width="200px"> 
				<br><br><br>
				
				<form action="AdminLogin" method="post">
					<div class="form-group col-xl-9">
						<label for="username">Enter UserName</label>
						<input name="uname" required type="text" class="form-control" id="uname" placeholder="Enter UserName">
						<span id="warn" style="color:red"></span>
					</div>
					<div class="form-group col-xl-9">
						<label for="password">Enter Password</label>
						<input name="password" required type="password" class="form-control" id="pword" placeholder="Enter Password">
						
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
				<hr>
				<hr>
				<form>
					New to StartNext?... 	<button type="submit" class="btn btn-secondary btn-sm">SIGN UP</button>
				</form>
				</div>
			</td>
		</tr>
		<tr>
			<td height="411">&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		</tbody>
		</table>
</body>
</html>