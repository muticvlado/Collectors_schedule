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
<h1>Collector teams</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<a href="collector-team-form" class="add">Add new collector team</a>
<br>
<br>
<table class="mytable">
	<tr>
		<th>Collector Team</th>
		<th colspan="2"></th>
	</tr>
<c:forEach var="team" items="${teams}">
	<tr>
		<td>${team.name}</td>
		<td><a href="collector-team-edit?id=${team.id}">Edit</a></td>
		<td><a href="collector-team-delete?id=${team.id}">Delete</a></td>		
	</tr>
</c:forEach>
</table>
</body>
</html>