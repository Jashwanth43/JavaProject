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
	<br />
	<br />
	<br />
	<br />
	<br />
	<c:set var="result" value="${requestScope.delete}" />
	<c:choose>
		<c:when test="${result eq 'success'}">
			<h1 style='color: green; text-align: center;'>DELETE OPERATION
				SUCCESFULL</h1>
		</c:when>
		<c:when test="${result eq 'failure'}">
			<h1 style='color: red; text-align: center;'>DELETE OPERATION
				FAILED</h1>
		</c:when>
		<c:when test="${result eq 'notfound'}">
			<h1 style='color: red; text-align: center;'>RECORD NOT AVAILABLE
				FOR DELETION</h1>
		</c:when>
	</c:choose>
</body>
</html>