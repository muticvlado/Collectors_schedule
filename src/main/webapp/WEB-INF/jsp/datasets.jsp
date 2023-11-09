<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Data Sets</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<a href="add-data-set-form" class="add">Add new data set</a>
<br>
<br>
<table class="mytable">
	<tr>
		<th>Data Set</th>
		<th colspan="2"></th>
	</tr>
<c:forEach var="dataset" items="${data_sets}">
	<tr>
		<td>${dataset.name}</td>
		<td><a href="edit-data-set-form?id=${dataset.id}">Edit</a></td>
		<td><a href="delete-data-set?id=${dataset.id}">Delete</a></td>		
	</tr>
</c:forEach>
</table>
</body>
</html>