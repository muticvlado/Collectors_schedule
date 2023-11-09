<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Price list item</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<form:form action="save-price-list-item" method="post" modelAttribute="item">			
<table>
	<tr><td colspan="2"><form:hidden path="id"/></td></tr>
	<tr><td colspan="2"><form:hidden path="priceList.id"/></td></tr>
	<tr>
		<td>Dataset</td>
		<td>
			<form:select path="dataSet" cssClass="select">	
    			<c:forEach items="${datasets}" var="dataset">
        			<form:option value="${dataset.id}" selected="${dataset.id == item.dataSet.id? 'selected' : '' }">${dataset.name}</form:option>
    			</c:forEach>			
			</form:select>
		</td>				
	</tr>	
	<tr>
		<td>Event</td>
		<td>
			<form:select path="eventType" cssClass="select">	
    			<c:forEach items="${events}" var="event">
        			<form:option value="${event.id}" selected="${event.id == item.eventType.id? 'selected' : '' }">${event.name}</form:option>
    			</c:forEach>			
			</form:select>
		</td>				
	</tr>
	<tr><td>Price</td><td><form:input path="price"/></td></tr>		
	<tr><td colspan="2"><input type="submit" value="Save"/></td></tr>
</table>
</form:form>
</body>
</html>