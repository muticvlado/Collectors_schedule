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
<h1>Data Set</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<form:form action="save-data-set" method="post" modelAttribute="data_set">
<table>
	<tr><td colspan="2"><form:hidden path="id"/></td></tr>	
	<tr><td>Data set name</td><td><form:input path="name"/></td></tr>
	<tr><td colspan="2"><input type="submit" value="Save"/></td></tr>
</table>
</form:form>
</body>
</html>