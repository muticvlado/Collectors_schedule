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
<h1>Price's list items</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<c:set var="game" value="${game}"></c:set>
<a href="/price-list-item-form?id=${priceList.id}" class="add">Add new price list item</a>
<br>
<br>
<table class="mytable">
		<tr>
			<th>Price list</th>
			<th colspan="3"></th>
		</tr>			
	<tr>	
		<td>${priceList.name}</td>
		<td colspan="3" class="action">
			<a href="price-list-edit-form?id=${priceList.id}">Edit</a>
		</td>	
	</tr>
</table>

<br>
<table class="item">
	<tr>
		<th>Event type</th>
		<th>Data set</th>
		<th>Price</th>
		<th colspan="2"></th>	
	</tr>
	<c:forEach var="item" items="${items}">
	<tr>
		<td>${item.eventType.name}</td>
		<td>${item.dataSet.name}</td>
		<td>${item.price}</td>		
		<td><a href="edit-price-item-form?id=${item.id}">Edit</a> <a href="delete-price-item?id=${item.id}">Delete</a></td>	
	</tr>
	</c:forEach>
</table>
</body>
</html>