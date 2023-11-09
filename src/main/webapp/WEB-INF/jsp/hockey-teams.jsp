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
<h1>Hockey teams</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<a href="add-hockey-team-form" class="add">Add new hockey team</a>
<br>
<br>
<table class="mytable">
		<tr>
			<th>Hockey Team</th>
			<th>League(s)</th>
			<th colspan="2"></th>
		</tr>
<c:forEach var="hockey_team" items="${hockey_teams}">
	<tr>
		<td>${hockey_team.name}</td>
		<td>${hockey_team.leagues}</td>
		<td><a href="edit-hockey-team-form?id=${hockey_team.id}">Edit</a></td>
		<td><a href="delete-hockey-team?id=${hockey_team.id}">Delete</a></td>		
	</tr>
</c:forEach>
</table>
</body>
</html>