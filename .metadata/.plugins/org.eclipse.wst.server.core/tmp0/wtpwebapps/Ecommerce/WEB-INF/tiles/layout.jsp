<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Layout</title>
</head>
<style>
.main{
margin: auto;
max-width: 1500px;
}
.header{
background-color: #c7cedb;
  text-align: center;
  padding: 20px;
}
.menu{
text-align: center;
 padding: 20px;
 margin-left: 100px;
 margin-right: 100px;
  
}
.body{
}
.footer{
background-color: #c7cedb;
text-align: center;
padding: 10px;
margin-top:40px;
font-size: 16px;
}
#submain{
gap:50px;
}
</style>
<body>
<div class="main">
<div class="header"><tiles:insertAttribute name="header"/></div>
<div class="menu"><tiles:insertAttribute name="menu"/></div>
<div id="submain">
<div class="body"><tiles:insertAttribute name="body"/></div>
<div class="footer"><tiles:insertAttribute name="footer"/></div></div>
</div>
</body>
</html>