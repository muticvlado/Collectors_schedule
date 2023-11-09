<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Game's collection items</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<c:set var="game" value="${game}"></c:set>
<a href="game-item-form?id=${game.id}" class="add">Add new collection item</a>
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
			<th colspan="3"></th>
		</tr>
			
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
		<td>${game.game_date}</td>
		<td>${game.dc_date}</td>
		<td>${game.dc_time}</td>
		<td>${game.end_date}</td>
		<td>${game.end_time}</td>
		<td colspan="3" class="action">
			<a href="game-edit?id=${game.id}">Edit</a>
		</td>	
	</tr>
</table>

<br>
<table class="item">
	<tr>
		<th>Collector</th>
		<th>Event</th>
		<th>Period</th>
		<th>Responde</th>
		<th>Valid</th>
		<th colspan="2"></th>	
	</tr>
	<c:forEach var="item" items="${items}">
	<tr>
		<td>${item.collector.name}</td>
		<td>${item.eventType.name}</td>				
		<td>${item.periodGame.name}</td>	
		<c:if test="${item.responde == 0}">
	      <td> - </td>
	    </c:if>	
	    <c:if test="${item.responde == 1}">
	      <td><img src="img/yes16.png"/> Yes</td>
	    </c:if>	
	    <c:if test="${item.responde == 2}">
	      <td><img src="img/no16.png"/> No</td>
	    </c:if>	
	    <c:if test="${item.responde == 3}">
	      <td><img src="img/done16.png"/> Done</td>
	    </c:if>	
	    <c:choose>
	    	<c:when test="${item.valid == false}"><td> - </td></c:when>
	    	<c:when test="${item.valid == true}"><td><img src="img/ok16.png"/></td></c:when>
	    </c:choose>    	  
		<td><a href="edit-game-item-form?id=${item.id}">Edit</a> <a href="delete-game-item?id=${item.id}">Delete</a></td>	
	</tr>
	</c:forEach>
</table>
<p style="margin: 7px; font-weight: bolder; font-size:medium;">
	<c:if test="${game.note != null}">Napomena: ${game.note}</c:if>
</p>
</body>
</html>