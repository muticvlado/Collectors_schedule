<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Collector team</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<form:form action="save-collector-team" method="post" modelAttribute="collectorTeam">
<table>
	<tr><td colspan="2"><form:hidden path="id"/></td></tr>	
	<tr><td>Name</td><td><form:input path="name"/></td></tr>
	<tr><td colspan="2"><input type="submit" value="Save"/></td></tr>
</table>
</form:form>
</body>
</html>