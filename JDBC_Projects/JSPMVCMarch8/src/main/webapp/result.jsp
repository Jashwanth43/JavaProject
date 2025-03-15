<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:green; text-align:center;">



<c:set var="result" value="${(applicationScope.insert)}"/> 
<c:out value="${result}"/>
<c:choose>
    <c:when test="${result eq 'success'}">
        <h1 style="color:green; text-align:center;">INSERT OPERATION SUCCESSFUL</h1>
    </c:when>
    <c:when test="${result eq 'failure'}">
        <h1 style="color:red; text-align:center;">INSERT OPERATION FAILED</h1>
    </c:when>
</c:choose>
</body>
</html>
