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
<h1>Price Lists</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<a href="price-list-form" class="add">Add new price list</a>
<br>
<br>
<table class="mytable">
	<tr>
		<th>Price list</th>
		<th colspan="2"></th>
	</tr>
<c:forEach var="priceList" items="${priceLists}">
	<tr>
		<td>${priceList.name}</td>
		<td>
			<a href="price-list-edit-form?id=${priceList.id}">Edit</a>
			<a href="delete-price-list?id=${priceList.id}">Delete</a>
			<a href="list-items-of-the-price-list?id=${priceList.id}">Price list's item</a>	
		</td>	
	</tr>
</c:forEach>
</table>
</body>
</html>