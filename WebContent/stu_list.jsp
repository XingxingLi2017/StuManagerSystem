<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Information of Students</h1>
	<table border = "1" width="700">
		<tr align="center">
			<td>id</td>
			<td>name</td>
			<td>age</td>
			<td>gender</td>
			<td>address</td>
		</tr>
		<c:forEach var="stu" items="${sessionScope.list}" >
			<tr align="center">
				<td>${stu.id}</td>
				<td>${stu.name}</td>
				<td>${stu.age}</td>
				<td>${stu.gender}</td>
				<td>${stu.address}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>