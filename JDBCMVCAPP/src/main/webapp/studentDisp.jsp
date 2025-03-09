<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
<center>
	<br />
	<br />
	<br />
	<br />
	<br />
	<c:set var="result" value="${requestScope.student}"/>
	<c:choose>
		<c:when test="${result ne null }">
			<table border='1'>
				<tr>
					<th>ID</th>
					<td>${result.sid }</td>
				</tr>
				<tr>
					<th>NAME</th>
					<td>${result.sname }</td>
				</tr>
				<tr>
					<th>AGE</th>
					<td>${result.sage }</td>
				</tr>
				<tr>
					<th>ADDRESS</th>
					<td>${result.saddr }</td>
				</tr>
			</table>
		</c:when>
		<c:when test="${result eq null }">
			<h1 style='color: red; text-align: center;'>RECORD NOT AVAILABLE
				FOR THE GIVEN ID</h1>
		</c:when>
	
	</c:choose>
</center>
</body>
</html>