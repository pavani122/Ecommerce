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
<style>
.cartMain{
display: flex;
flex-direction: column;
gap:30px;
}
.subCart{
display:flex;
gap:20px;
}
#cartDetails{
display: flex;
flex-direction: column;
}
#cartName{
color:black;
font-size: x-large;
font-weight: bold;
}
#cartPrice{
color:black;
font-size: x-large;
font-weight: normal;
}
#button{
padding: 10px;
font-size: x-large;
background-color: pink;
}
#button:hover {
  background-color: white;
  color: black; 
}
#cartButton{
display: flex;
gap:20px;
}
#cartAmount{
font-size:larger
display: flex;
flex-direction:column
gap:30px;
}
</style>
<body>
<div class="cartMain">
<div id="sub">
<c:forEach items="${cartList }" var="cart">
<div class="subCart">
<div id="cartImg"><img alt="productImage" src="${cart.productImage }"></div>
<div id="cartDetails"><div id="cartName"><c:out value="${cart.productName }"></c:out></div>
<div id="cartPrice">Rs.<c:out value="${cart.productPrice }"></c:out>/-</div><br>
<div id="pdpquan">Quantity:
<a href="/Ecommerce/cartMinus/${cart.cartId }/${cart.productPrice }/${cart.quantity }">
<button>-</button></a>
<a href=""><input type="button" value="${cart.quantity }"></a>
<a href="/Ecommerce/cartPlus/${cart.cartId }/${cart.productPrice }/${cart.quantity }">
<button>+</button></a><br><br>
<div id="cartPrice">TotalPrice: Rs.<c:out value="${cart.totalPrice }">
</c:out>/-
</div>
<div><a href="/Ecommerce/cart/remove/${cart.cartId }">
<button id="button">Remove</button></a></div></div>
</div>
</div>
</c:forEach>
</div>
<c:set var="i" scope="session" value="${cartEmpty }" />
<c:if test="${i==null }">
<div id="cartAmount"><div id="cartPrice">CartTotalAmount: Rs. ${cartAmount } ${cartTotalAmount }/-</div>
<div id="cartButton">
<a href="/Ecommerce/cartBuy"><button id="button">Place an order</button></a></div>
</div>
</c:if>
</div>
<h1>${cartEmpty }
${message }
</h1>
</div>
</body>
</html>