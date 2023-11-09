<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Availabilities</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<br>
<br>
<form action="">

<table>
	<tr><td>Date: </td><td><input type="date"></td></tr>
	<tr><td>Start: </td><td><input type="time"></td></tr>
	<tr><td>End: </td><td><input type="time"></td></tr>
	<tr><td>Only for light: </td><td><input type="checkbox"></td></tr>
	<tr><td colspan="2"><input type="submit" value="Save"></td></tr>
</table>
	
</form>
</body>
</html>