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
<h1>Periods</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<a href="period-form" class="add">Add new period</a>
<br>
<br>
<table class="mytable">
	<tr>
		<th>Period</th>
		<th>Amount</th>
		<th></th>
	</tr>
<c:forEach var="period" items="${periods}">
	<tr>
		<td>${period.name}</td>
		<td>${period.amount}</td>
		<td>
			<a href="period-edit?id=${period.id}">Edit</a>
			<a href="period-delete?id=${period.id}">Delete</a>	
		</td>	
	</tr>
</c:forEach>
</table>
</body>
</html>