<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="navigation" style="display: flex;    justify-content: space-between;">
<div  style="display: flex;flex-direction: row;gap: 20px;">
<div>
<img alt="pharmeasy-logo"
 src="https://assets.pharmeasy.in/apothecary/images/logo_big.svg?dim=360x0">
</div>
<div style="border-left: 1px solid black;
    height: 40px;"></div>
<div style="display:flex;flex-direction:column;">
<div ><img alt="express"
src="https://assets.pharmeasy.in/apothecary/images/ic_express%20delivery.svg?dim=32x0">
Express delivery to
</div>
<div>

<b>500081 Hyderab... ^</b>
</div>
</div>
</div>

<div style="display: flex;justify-content: space-evenly;">
<ul style="  list-style-type: none;display: flex;flex-direction:row;gap:10px;">
<li><a href="/Ecommerce/main" style="text-decoration: none;font-size: 20px">Home</a></li>
<li><img src="https://assets.pharmeasy.in/web-assets/dist/21b0b5ba.svg" alt="cartImg"></li>
<li><a href="/Ecommerce/cart" style="text-decoration: none;font-size: 20px">cart</a>
</li>
<li><a href="/Ecommerce/order" style="text-decoration: none;font-size: 20px">Orders</a></li>
<li><a href="/Ecommerce/logout" style="text-decoration: none;font-size: 20px">Logout</a></li>
</ul>
</div>

<div style="text-decoration: none;font-size: 20px;margin-top: 17px;" >
Hello, ${name }
</div>

</div>
</body>
</html>