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
<h1>Hockey team</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<form:form action="save-hockey-team" method="post" modelAttribute="hockey_team">
<table>
	<tr><td colspan="2"><form:hidden path="id"/></td></tr>	
	<tr><td>Hockey team name</td><td><form:input path="name"/></td></tr>
	<tr><td>Short name</td><td><form:input path="short_name"/></td></tr>
	<tr>
		<td>Leagues or Competitions</td>
		<td>
			<form:select path="leagues" cssClass="select" multiple="true">	
    			<c:forEach items="${all_leagues}" var="league">
        			<form:option value="${league.id}">${league.name}</form:option>
    			</c:forEach>			
			</form:select>
		</td>		
	</tr>	
	<tr><td colspan="2"><input type="submit" value="Save"/></td></tr>
</table>
</form:form>
</body>
</html>