<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>orders</title>
</head>
<style>
.ordermain{
display: flex;
gap:30px;
}
#ordername{
color:black;
font-size: x-large;
font-weight: bold;
}
#orderprice{
color:black;
font-size: x-large;
font-weight: normal;
}
#orderdes{
font-weight: normal;

}
#ordertot{
color:black;
font-size: x-large;
font-weight: bold;
}
#orderquantity{
color:black;
font-size: x-large;
font-weight: normal;
}
#orderimg{
border: 1px solid black;
border-radius: 12px;
text-align: center;
padding: 20px;
}
button{
padding: 10px;
font-size: x-large;
background-color: pink;
}
button:hover {
  background-color: white;
  color: black;
  
}
</style>
<body>
<c:forEach items="${orderList }" var="order">
<div class="ordermain">
<div id="orderimg"><img alt="orderimg" src="${order.productImage }"></div>
<div id="orderdetails"><div id="ordername"><c:out value="${order.productName }"></c:out></div>
<div id="orderdes"><c:out value="${order.productDesc }"></c:out></div>
<div id="orderprice">Rs.<c:out value="${order.productPrice }"></c:out>/-</div>
<div id="orderquantity">Quantity:<c:out value="${order.quantity }"></c:out></div>
<div id="ordertot">TotalPrice: Rs.<c:out value="${order.totalPrice }"></c:out>/-</div>
<div><a href="/Ecommerce/order/remove/${order.orderId }/${order.productId}">
<button id="button">Cancel Order</button></a></div></div></div>
</c:forEach>
</body>
</html>