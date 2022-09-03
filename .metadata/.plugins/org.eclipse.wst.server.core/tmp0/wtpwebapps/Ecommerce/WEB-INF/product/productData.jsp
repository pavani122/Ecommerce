<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>productData</title>
</head>
<body>
<form:form action="submit" modelAttribute="product">
ProductName<form:input path="productName"/><br><br>
ProductDes<form:input path="productDesc"/><br><br>
ProductPrice<form:input path="productPrice"/><br><br>
ProductImage<form:input path="productImage"/><br><br>
CategoryName<form:input path="categoryName"/><br><br>
<input type="submit" value="Submit">
</form:form>
</body>
</html>