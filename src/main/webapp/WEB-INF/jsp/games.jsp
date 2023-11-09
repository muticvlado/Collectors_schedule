<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Games</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<a href="game-form" class="add">Add new game</a>
<br>
<br>
<table class="mytable">
		<tr>
			<th>League</th>
			<th>Data set</th>
			<th>Home</th>
			<th>Away</th>
			<th>Game date</th>
			<th>DC date</th>
			<th>DC time</th>
			<th>END date</th>
			<th>END time</th>
			<th>Complete</th>
			<th colspan="3"></th>
		</tr>
			
<c:forEach var="game" items="${games}">	
	<tr>
		<td>${game.league}</td>
		
		<c:if test="${game.dataSet.name == 'Live'}">
	      <td style="color: white; background-color: red">${game.dataSet.name}</td> 
	    </c:if>
	    <c:if test="${game.dataSet.name == 'Light+'}">
	      <td style="background-color: orange">${game.dataSet.name}</td>
	    </c:if>
	    <c:if test="${game.dataSet.name == 'Light'}">
	      <td style="color: white; background-color: green;">${game.dataSet.name}</td>
	    </c:if> 
	    <c:if test="${game.dataSet.name == 'Full'}">
	      <td style="color: black; background-color: yellow;">${game.dataSet.name}</td> 
	    </c:if> 
	     
		<td>${game.home.short_name}</td>
		<td>${game.away.short_name}</td>
		<td><fmt:formatDate value="${game.game_date}" pattern="dd-MMM-yyyy"/></td>
		<td><fmt:formatDate value="${game.dc_date}" pattern="dd-MMM-yyyy"/></td>
		<td>${game.dc_time}</td>		
		<td><fmt:formatDate value="${game.end_date}" pattern="dd-MMM-yyyy"/></td>
		<td>${game.end_time}</td>
		<td></td>
		<td colspan="3" class="action">
			<a href="game-edit?id=${game.id}">Edit</a>
			<a href="game-delete?id=${game.id}">Delete</a>
			<a href="list-items-of-the-game?id=${game.id}">Collection's items</a>
		</td>	
	</tr>
</c:forEach>
</table>
</body>
</html>