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
<h1>Event Types</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<a href="add-event-type-form" class="add">Add new event type</a>
<br>
<br>
<table class="mytable">
	<tr>
		<th>Event Type</th>
		<th colspan="2"></th>
	</tr>
<c:forEach var="eventtype" items="${event_types}">
	<tr>
		<td>${eventtype.name}</td>
		<td><a href="edit-event-type-form?id=${eventtype.id}">Edit</a></td>
		<td><a href="delete-event-type?id=${eventtype.id}">Delete</a></td>		
	</tr>
</c:forEach>
</table>
</body>
</html>