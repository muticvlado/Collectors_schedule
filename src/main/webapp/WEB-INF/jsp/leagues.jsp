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
<h1>Leagues</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<a href="add-league-form" class="add">Add new league</a>
<br>
<br>
<table class="mytable">
<tr>
	<th>League</th>
	<th colspan="2"></th>
</tr>
<c:forEach var="league" items="${leagues}">
	<tr>
		<td>${league.name}</td>
		<td><a href="edit-league-form?id=${league.id}">Edit</a></td>
		<td><a href="delete-league?id=${league.id}">Delete</a></td>		
	</tr>
</c:forEach>
</table>
</body>
</html>