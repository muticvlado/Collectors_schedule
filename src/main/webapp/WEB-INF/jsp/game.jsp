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
<h1>Game</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<form:form action="save-game" method="post" modelAttribute="game">
<table>
	<tr><td colspan="2"><form:hidden path="id"/></td></tr>
		
	<tr><td>Game date</td><td><form:input type="date" path="game_date" /></td></tr>
	<tr><td>Data collection date</td><td><form:input type="date" path="dc_date"/></td></tr>
	<tr><td>Data collection time</td><td><form:input type="time" path="dc_time"/></td></tr>
	<tr><td>End date</td><td><form:input type="date" path="end_date"/></td></tr>
	<tr><td>End time</td><td><form:input type="time" path="end_time"/></td></tr>	
	<tr>
		<td>League</td>
		<td>
			<form:select path="league" cssClass="select">	
    			<c:forEach items="${leagues}" var="league">
        			<form:option value="${league.id}" selected="${league.id == game.league.id? 'selected' : '' }">${league.name}</form:option>
    			</c:forEach>			
			</form:select>
		</td>		
	</tr>	
	<tr>
		<td>Data Set</td>
		<td>
			<form:select path="dataSet" cssClass="select">	
    			<c:forEach items="${data_sets}" var="data_set">
        			<form:option value="${data_set.id}" selected="${data_set.id == game.dataSet.id? 'selected' : '' }">${data_set.name}</form:option>
    			</c:forEach>			
			</form:select>
		</td>		
	</tr>		
	<tr>
		<td>Home</td>
		<td>
			<form:select path="home" cssClass="select">	
    			<c:forEach items="${hcteams}" var="hcteam">
        			<form:option value="${hcteam.id}" selected="${hcteam.id == game.home.id? 'selected' : '' }">${hcteam.name}</form:option>
    			</c:forEach>			
			</form:select>
		</td>		
	</tr>	
	<tr>
		<td>Away</td>
		<td>
			<form:select path="away" cssClass="select">	
    			<c:forEach items="${hcteams}" var="hcteam">
        			<form:option value="${hcteam.id}" selected="${hcteam.id == game.away.id? 'selected' : '' }">${hcteam.name}</form:option>
    			</c:forEach>			
			</form:select>
		</td>		
	</tr>
	<tr>
	<td>Note</td>
	<td>
		<form:textarea path="note" rows="7" cols="20"/>
	</td>	
	</tr>	
	<tr><td colspan="2"><input type="submit" value="Save"/></td></tr>
</table>
</form:form>
</body>
</html>