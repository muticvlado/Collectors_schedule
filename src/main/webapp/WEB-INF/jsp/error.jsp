<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Error</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<br><br>
<h3 style="color: red; margin: 10px">${msg}</h3>
<a href="${back}" style="margin: 5px">Back</a>
</body>
</html>