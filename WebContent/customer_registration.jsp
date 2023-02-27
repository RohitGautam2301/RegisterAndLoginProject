<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<h1>Customer Registration Page</h1>
<form action="regCustomer" method="post">
<label for="tbName">Name: </label>
<input type="text" name="tbName" id="tbName" />
<br/>
<label for="tbEmail">Email: </label>
<input type="email" name="tbEmail" id="tbEmail" placeholder="enter your email" required />
<br/>
<label for="tbMobile">Mobile: </label>
<input type="tel" name="tbMobile" id="tbMobile" />
<br/>
<label for="tbPass">Password: </label>
<input type="password" name="tbPass" id="tbPass" placeholder="enter your password" required />
<br/>
<label for="ddlStates">State: </label>
<select name="ddlStates" id="ddlStates">
<option value="">--select--</option>
<option value="Karnataka">Karnataka</option>
<option value="Tamil Nadu">Tamil Nadu</option>
<option value="Andhra Pradesh">Andhra Pradesh</option>
<option value="Kerala">Kerala</option>
</select>
<br/>
<input type="submit" name="btnRegister" id="btnRegister" value="Register" />
</form>
</body>
</html>