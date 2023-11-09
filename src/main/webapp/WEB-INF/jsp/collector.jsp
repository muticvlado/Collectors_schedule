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
<h1>Collector</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<form:form action="save-collector" method="post" modelAttribute="collector">
<table>
	<tr><td colspan="2"><form:hidden path="id"/></td></tr>	
	<tr><td>Name</td><td><form:input path="name"/></td></tr>
	<tr><td>City</td><td><form:input path="city"/></td></tr>
	<tr><td>Bank account</td><td><form:input path="bank_account"/></td></tr>
	<tr><td>Phone</td><td><form:input path="phone"/></td></tr>
	<tr><td>Discord</td><td><form:input path="discord"/></td></tr>
	<tr><td>Email</td><td><form:input path="email"/></td></tr>
	<tr><td>Password</td><td><form:password path="password"/></td></tr>
	<tr><td>Disabled</td><td><form:checkbox path="disabled" cssClass="check"/></td></tr>
	<tr>
		<td>Collector Team</td>
		<td>
			<form:select path="collector_team" cssClass="select">	
    			<c:forEach items="${teams}" var="team">
        			<form:option value="${team.id}" selected="${team.id == collector.collector_team.id? 'selected' : '' }">${team.name}</form:option>
    			</c:forEach>			
			</form:select>
		</td>		
	</tr>
	<tr>
		<td>Price list</td>
		<td>
			<form:select path="priceList" cssClass="select">	
    			<c:forEach items="${priceLists}" var="priceList">
        			<form:option value="${priceList.id}" selected="${priceList.id == collector.priceList.id? 'selected' : '' }">${priceList.name}</form:option>
    			</c:forEach>			
			</form:select>
		</td>		
	</tr>		
	<tr><td colspan="2"><input type="submit" value="Save"/></td></tr>
</table>
</form:form>
</body>
</html>