<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page isELIgnored="false" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
</head>
<style>
.slide{
display:inline-flex;
overflow-x: scroll;
}
</style>
<body>
<div class="slide"><marquee>
<c:forEach items="${images }" var="i" >
<img alt="${i }" src="${i.imageUrl }">
</c:forEach>
</marquee>
</div>
</body>
</html>