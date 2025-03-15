<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
		<c:set var="result" value="${requestscope.values}" />
		<c:choose>
			<c:when test="${values ne null }">
			<center>
    <form border='1' method="post" action="./controller/update">
        <table>
            <tr>
                <th>ID</th>
                <td>
                    <input type="text" value="${values.sid}" readonly="readonly">
                 <%--    <input type="hidden" name="sid" value="${values.sid}"> --%>
                </td>
            </tr>
            <tr>
                <th>NAME</th>
                <td>
                    <input type="text" name="sname" value="${values.name}">
                </td>
            </tr>
            <tr>
                <th>AGE</th>
                <td>
                    <input type="text" name="sage" value="${values.age}">
                </td>
            </tr>
            <tr>
                <th>ADDRESS</th>
                <td>
                    <input type="text" name="saddr" value="${values.saddress}">
                </td>
            </tr>
            <tr>
                <th></th>
                <td>
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
    </form>
</center>
			</c:when>
			<c:when test="${values eq null }">
				<h1>RECORD NOT FOUND...</h1>
			</c:when>
		</c:choose>
</body>
</html>