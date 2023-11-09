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
<h1>Game item</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<form:form action="save-game-item-from-all" method="post" modelAttribute="item">
<table>
	<tr><td colspan="2"><form:hidden path="id"/></td></tr>
	<tr><td colspan="2"><form:hidden path="game.id"/></td></tr>
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
	<tr>
		<td>Collector</td>
		<td>
			<form:select path="collector" cssClass="select">	
    			<c:forEach items="${collectors}" var="collector">
        			<form:option value="${collector.id}" selected="${collector.id == item.collector.id? 'selected' : '' }">${collector.name}</form:option>
    			</c:forEach>			
			</form:select>
		</td>		
	</tr>	
		
	<tr>
		<td>Period</td>
		<td>
			<form:select path="periodGame" cssClass="select">	
    			<c:forEach items="${periods}" var="period">
        			<form:option value="${period.id}" selected="${period.id == item.periodGame.id? 'selected' : '' }">${period.name}</form:option>
    			</c:forEach>			
			</form:select>
		</td>		
	</tr>	
	<tr><td>Responde</td>
		<td>
			<form:select path="responde" cssClass="select">
			<form:option value="0">----</form:option>
			<form:option value="1">Yes</form:option>
			<form:option value="2">No</form:option>
			<form:option value="3">Done</form:option>
		</form:select>
		</td>
	</tr>
	<tr><td>Valid</td><td><form:checkbox path="valid" cssClass="check"/></td></tr>
	<tr><td colspan="2"><input type="submit" value="Save"/></td></tr>
</table>
</form:form>
</body>
</html>