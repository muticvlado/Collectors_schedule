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
<h1>Collectors</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<a href="collector-form" class="add">Add new collector</a>
<br>
<br>
<table class="mytable">
	<tr>
		<th>Collector</th>
		<th>Team</th>
		<th></th>
	</tr>
<c:forEach var="collector" items="${collectors}">
	<tr>
		<td>${collector.name}</td>
		<td>${collector.collector_team.name}</td>
		<td>
			<a href="collector-edit?id=${collector.id}">Edit</a>
			<a href="collector-delete?id=${collector.id}">Delete</a>	
			<a href="availabilities?id=${collector.id}">Availabilities</a>
		</td>	
	</tr>
</c:forEach>
</table>
</body>
</html>