<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<style>

input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}
input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}
.login {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}
#fields{
font-size: x-large;
text-align: left;
}
  input[type=submit]
{
border: none;
padding: 15px;
text-align: center;
background-color: #c7cedb;
  font-size:x-large;
  color: Black;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

</style>
<body>
<h1>
${error }<br><br>
${message }<br><br>
${cartMessage }<br><br>
${LoginMessage }<br><br></h1>
<form action="/Ecommerce/welcome" method="get">
<div class="container">
<h1>Sign in</h1>
<label id="fields"><b>Username</b></label><input type="text" name="name"><br><br>
<label id="fields"><b>Password</b></label><input type="password" name="password"><br><br>
<input type="submit" value="Login">
</div>
<div class="container signin">
    <p>Dont have an account? <a href="/Ecommerce/register">Register</a>.</p>
  </div>
</form>

</body>
</html>