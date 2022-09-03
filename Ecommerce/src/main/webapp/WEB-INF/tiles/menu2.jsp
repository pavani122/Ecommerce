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
.mainmenu2{
display: flex;
text-align: center;
}
#menu2details{
display: flex;
flex-direction: column;
}
button{
padding: 10px;
font-size: x-large;
background-color: white;
}
#homemenu2{
padding-top: 100px;
}

</style>
<body>
<nav>
<c:set var="ctg" scope="application" value="${categoryname }"></c:set>
<div class="mainmenu2">
<div id="homemenu2"><a href="/Ecommerce/main"><button>Home</button></a></div>
<c:forEach items="${category }" var="cats">
<c:set var="x" scope="page" value="${cats.categoryName}"></c:set>
<c:if test="${!x.equals(ctg) }">
<div id="menu2details">
<div id="menu2img"><a href="/Ecommerce/plp/${x}"><img alt="category" src="${cats.categoryImage }" 
style="width: 150px;
height: auto;"></a></div>
<div id="menu2name"><c:out value="${x}"></c:out></div></div>
</c:if>
</c:forEach>
</div>
</nav>
</body>
</html>