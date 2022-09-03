<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.pdpmain{
display: inline-flex;
gap: 50px;
}
#pdpimg{ 
border: 1px solid black;
border-radius: 12px;
text-align: center;
padding: 20px;
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
.pdpdesc{
font-weight: normal;
margin-right: 200px;
}
#pdpab{
gap:30px;
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

</style>
<body>
<h3>${AddtoCartMessage }</h3><br>
<div class="pdpmain">
<div id="pdpimg">
<img alt="product" src="${productData.productImage }">
</div>
<div id="pdpdetails">
<div id="pdpname">${productData.productName }</div><br>
<div id="pdpprice">Rs.${productData.productPrice }/-</div><br>
<div id="pdpab"><a href="/Ecommerce/cart/${productData.productId }/${quantity }">
<button id="button">AddtoCart</button></a>
<a href="/Ecommerce/buy/${productData.productId }/${quantity }">
<button id="button">Buy</button></a></div><br>
<div id="pdpquan">Quantity:
<a href="/Ecommerce/minus/${quantity }"><button>-</button></a>
<a href=""><input type="button" value="${quantity }"></a>
<a href="/Ecommerce/plus/${quantity }"><button>+</button></a>

</div>
</div></div>

<br><br><br>
<div id="pdpdesc"><h3>${productData.productDesc }</h3></div><br>
</body>
</html>