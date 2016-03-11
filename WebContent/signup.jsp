<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parking Lot System - Registration</title>
</head>
<body>

	<center>SignUp</center>

	<form action="signup" name="signup" method="post">
		 Firstname :
		<input type="text" name="firstname" id="firstname"><br>
		<br> Lastname : <input type="text" name="lastname" id="lastname"><br>
		<br> Username : <input type="text" name="username" id="username"><br>
		<br> Password : <input type="text" name="password" id="password"><br>
		<br> Email : <input type="text" name="email" id="email"><br>
		<br> Lot : <select name="lotdetails">
			<option value="lot1">Lot1</option>
			<option value="lot2">Lot2</option>
		</select><br>
		<br> <input type="submit" name="submit" value="Signup"></input>


	</form>

</body>
</html>