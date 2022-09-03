<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>plp</title>
</head>
<style>
.products{
display: inline-flex;
flex-wrap: wrap;
gap: 50px;
}
.pdpmain{
border: 1px solid #8292af1a;
border-radius: 12px;
text-align: center;
padding: 10px;
}
#pdpimg{ 
padding: 50px;
height: 300px;
width: 300px;
}
#pdpname{
color:black;
font-size: x-large;
font-weight: bold;
}
#pdpprice{
color:black;
font-size: x-large;
font-weight: normal;

}

</style>
<body>
<div class="products">
<c:forEach items="${list }" var="product">
<div class="pdpmain">
<div id="pdpimg"><a href="/Ecommerce/plp/pdp/${product.productId }">
<img alt="product" src="${product.productImage }"></a>
</div>
<div id="pdpname"><c:out value="${product.productName }"></c:out></div><br>
<div id="pdpprice">Rs.<c:out value="${product.productPrice }"></c:out>/-</div><br>
</div>
</c:forEach>
</div>
</body>
</html>