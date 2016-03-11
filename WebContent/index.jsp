<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parking Lot System</title>
</head>
<body>
<center>  <h2><strong>Welcome to Parking Lot System!!</h2></strong></center>


<h3>Login</h3>

<form action="Login" name="login" method="post">
<input type="hidden" name="action" value="login"></input>

Username: <input type="text" name="username" id="username"></input><br><br>
Password: <input type="text" name="password" id="password"></input><br><br>

<input type="submit" name="submit" value="Submit"></input>    <a href="signup.jsp">Signup</a>
 


</form>

</body>
</html>