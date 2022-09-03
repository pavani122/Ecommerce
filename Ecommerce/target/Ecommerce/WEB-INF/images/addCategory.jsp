<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="saveCategory" modelAttribute="category">
CategoryName<form:input path="categoryName"/><br><br>
CategoryImage<form:input path="categoryImage"/><br><br>
<input type="submit" value="Save">
</form:form>
</body>
</html>