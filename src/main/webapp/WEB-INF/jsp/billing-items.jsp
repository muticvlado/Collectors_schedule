<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">

function makeLink() {
	
	var alink = document.getElementById("link");
	alink.href = "list-of-billing-items-filter?collector_id=" + document.getElementById("filter").value;
}

</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>All statuses</h1>
<hr>
<jsp:include page="nav.jsp"></jsp:include>
<br>
<br>			
<table class="item">
	<tr>
		<th>League</th>
		<th>Data set</th>
		<th>Home</th>
		<th>Away</th>
		<th>Game date</th>
		<th>DC date</th>
		<th>Event type</th>
		<th>Collector</th>
		<th>Responde</th>	
		<th>Valid</th>
		<th>Amount</th>
		<th>Price</th>
		<th>Total</th>		
		<th colspan="2"></th>	
	</tr>
	
	<tr>		
		<td colspan="4" style="border-color: transparent;"></td>
		<td style="border-color: transparent;"></td>
		<td style="border-color: transparent;"><input type="date" id="dc_date_from"><br><input type="date" id="dc_date_to"></td>
		<td style="border-color: transparent;"></td>
		<td style="border-color: transparent;">		
		<form:select path="filter" cssClass="select" id="filter">	
			<form:option value="0">-</form:option>
			<c:forEach items="${filter.collectors}" var="collector">
				<c:if test="${filter.collector != null}">
					<form:option value="${collector.id}" selected="${collector.id == filter.collector.id? 'selected' : '' }">${collector.name}</form:option>
				</c:if>
    			<c:if test="${filter.collector == null}">
					<form:option value="${collector.id}">${collector.name}</form:option>
				</c:if>
    		</c:forEach>			
		</form:select>		
		</td>
		<td style="border-color: transparent;">
		<form:select path="filter" cssClass="select">
			<form:option value="0">-</form:option>
			<form:option value="1">Yes</form:option>
			<form:option value="2">No</form:option>
			<form:option value="3">Done</form:option>
		</form:select>		
		</td>
		<td colspan="4" style="border-color: transparent;"></td>
		<td colspan="2" style="border-color: transparent;"><a id="link" href="" onclick="makeLink();">Search</a> <a href="list-of-billing-items">Reset filter</a> </td>
	</tr>
	
	<c:set var="total" value="${0}"/>
	<c:forEach var="item" items="${items}">
	<c:set var="total" value="${total + item.amount*item.price}" />
	
	<tr>
		<td>${item.game.league.name}</td>
		
		<c:if test="${item.game.dataSet.name == 'Live'}">
	      <td style="color: white; background-color: red">${item.game.dataSet.name}</td>
	    </c:if>
	    <c:if test="${item.game.dataSet.name == 'Light+'}">
	      <td style="background-color: orange">${item.game.dataSet.name}</td>
	    </c:if>
	    <c:if test="${item.game.dataSet.name == 'Light'}">
	      <td style="color: white; background-color: green;">${item.game.dataSet.name}</td> 
	    </c:if> 
	    <c:if test="${item.game.dataSet.name == 'Full'}">
	      <td style="color: black; background-color: yellow;">${item.game.dataSet.name}</td> 
	    </c:if> 
	    
	    <td>${item.game.home.name}</td>
		<td>${item.game.away.name}</td>
		<td>${item.game.game_date}</td>
		<td>${item.game.dc_date}</td>
		<td>${item.eventType.name}</td>
		<td>${item.collector.name}</td>
		
		<c:if test="${item.responde == 0}">
	      <td> - </td>
	    </c:if>	
	    <c:if test="${item.responde == 1}">
	      <td><img src="img/yes16.png"/> Yes</td>
	    </c:if>	
	    <c:if test="${item.responde == 2}">
	      <td><img src="img/no16.png"/> No</td>
	    </c:if>	
	    <c:if test="${item.responde == 3}">
	      <td><img src="img/done16.png"/> Done</td>
	    </c:if>	
	    <c:choose>
	    	<c:when test="${item.valid == false}"><td> - </td></c:when>
	    	<c:when test="${item.valid == true}"><td><img src="img/ok16.png"/></td></c:when>
	    </c:choose>
	    <td>${item.amount}</td>
	    <td>${item.price}</td>
	    <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${item.amount * item.price}" /></td>   	  
		<td style="text-align: center"><a href="edit-game-item-form-from-all?id=${item.id}">Edit</a></td>			
	</tr>
	</c:forEach>
	<tr>
		<td colspan="14" style="font-size: xx-large; font-weight: bolder; text-align: right; padding-right: 25px">
			Total = <fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${total}" />
		</td>
	</tr>
</table>
</body>
</html>