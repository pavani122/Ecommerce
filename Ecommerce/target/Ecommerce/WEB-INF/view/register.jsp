<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@page isELIgnored="false" %>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register</title>
</head>
<style>
.register{
text-align: center;
}
.container {
  padding: 16px;
  background-color: white;
}
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}
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
input[type=submit]
{
border: none;
padding: 15px;
text-align: center;
background-color: #c7cedb;
  color: Black;
  font-size:x-large;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

#fields{
font-size: x-large;
text-align: left;
}
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
<body>
<h1>
${message }<br><br>
${notRegistered }<br><br></h1>


<form:form action="registered" modelAttribute="person">
<div class="container">
<h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>
<label id="fields"><b>Name</b></label>
<b><form:errors path="name"></form:errors></b>
<form:input path="name"/>
<b><form:errors path="email"></form:errors><br></b>
<label id="fields"><b>Email</b></label><form:input path="email"/>
<b><form:errors path="password"></form:errors><br></b>
<label id="fields"><b>Password</b></label><form:password path="password"/>
<b><form:errors path="number"></form:errors><br></b>
<label id="fields"><b>Mobile Number</b></label><form:input path="number"/>
<label id="fields"><b>Gender: </b></label>
<label id="fields"><b>Male</b></label><form:radiobutton path="gender" value="male"/>
<label id="fields"><b>Female</b></label><form:radiobutton path="gender" value="female"/>
<b><form:errors path="gender"></form:errors><br></b>
<br><hr>
 <p>By creating an account you agree to our <a href="#">Terms & Privacy</a></p>
 <hr>
<input type="submit" value="Register">
</div>

 <div class="container signin">
    <p>Already have an account? <a href="/Ecommerce/login">Sign in</a>.</p>
  </div>
</form:form>


</body>
</html>