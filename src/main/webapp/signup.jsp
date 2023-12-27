<!-- signup.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Signup Page</title>

</head>
<body>
	<h1>Signup</h1>
	<form action="signupProcess.jsp" method="post">
		First Name: <input type="text" name="fname"><br> Last
		Name: <input type="text" name="lname"><br> Username: <input
			type="text" name="username"><br> Password: <input
			type="password" id="password" name="password"> <span
			id="uppercaseMsg" style="display: none; color: orange;">Password
			should contain at least one uppercase letter</span> <span id="lowercaseMsg"
			style="display: none; color: yellow;">Password should contain at
			least one lowercase letter</span> <span id="numberMsg"
			style="display: none; color: yellow;">Password should contain at
			least one number</span> <span id="specialCharMsg"
			style="display: none; color: yellow;">Password should contain at
			least one special character</span><br> Email: <input type="email"
			name="mail"><br> Contact: <input type="text" id="contact"
			name="contact" >

		<p id="contactMsg" style="display: none; color: red;">Contact
			number should be a 10-digit numeric value</p><br>
		<!-- Add more input fields for other UserBean properties if needed -->
		<input type="submit" value="Sign Up">
	</form>
	<script type="text/javascript">
		const passwordField = document.getElementById('password'); 
		const uppercaseMsg = document.getElementById('uppercaseMsg');
		const lowercaseMsg = document.getElementById('lowercaseMsg');
		const numberMsg = document.getElementById('numberMsg');
		const specialCharMsg = document.getElementById('specialCharMsg');

		passwordField.addEventListener('input', function() {
			const password = passwordField.value;
			const hasUpperCase = /[A-Z]/.test(password);
			const hasLowerCase = /[a-z]/.test(password);
			const hasNumber = /[0-9]/.test(password);
			const hasSpecialChar = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/
					.test(password);

			uppercaseMsg.style.display = hasUpperCase ? 'none' : 'block';
			lowercaseMsg.style.display = hasLowerCase ? 'none' : 'block';
			numberMsg.style.display = hasNumber ? 'none' : 'block';
			specialCharMsg.style.display = hasSpecialChar ? 'none' : 'block';
		});
		const contactField = document.getElementById('contact'); 
		const contactMsg = document.getElementById('contactMsg');

		contactField.addEventListener('input', function() {
			const contact = contactField.value;
			const isValidContact = /^\d+$/.test(contact)
					&& contact.length === 9;

			contactMsg.style.display = isValidContact ? 'none' : 'block';
		});
	</script>
</body>
</html>
