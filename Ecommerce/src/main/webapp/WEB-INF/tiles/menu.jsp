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
.mainmenu{
display: flex;
flex-direction: row;
text-align: center;

}
.submenu{
display: flex;
flex-direction: column;
}
#menuname{
}
#menuimg{
}
</style>
<body>
<br><br>
<nav>
<c:set var="cat" scope="session" value="${category }"></c:set>
<div class="mainmenu">
<c:forEach items="${cat }" var="i">
<div class="submenu">
<div id="menuimg"><a href="/Ecommerce/plp/${i.categoryName }"><img alt="category" src="${i.categoryImage }"
 style="width: 150px;
height: auto;"></a></div>
<div id="menuname"><c:out value="${i.categoryName }"></c:out></div></div>
</c:forEach>
</div>
</nav>
</body>
</html>