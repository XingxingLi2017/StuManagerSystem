<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" >
		function doDelete(sid, sname) {
			console.log(sid, sname);
			var isDelete = confirm("Are you sure to delete "+sname+"?");
			if (isDelete) {
				window.location.href="DeleteServlet?sid="+sid
			}
		}
	</script>
</head>
<body>
	<h1>Information of Students</h1>
	<table border = "1" width="700">
		<tr>
			<td colspan="8">
				<a href="add.jsp">Add</a>
			</td>
		</tr>
		<tr align="center">
			<td>id</td>
			<td>name</td>
			<td>gender</td>
			<td>phone</td>
			<td>hobby</td>
			<td>info</td>
			<td>birthday</td>
			<td>operation</td>
		</tr>
		<c:forEach var="stu" items="${list}">
			<tr align="center">
				<td>${stu.sid}</td>
				<td>${stu.sname}</td>
				<td>${stu.gender}</td>
				<td>${stu.phone}</td>
				<td>${stu.hobby}</td>
				<td>${stu.info}</td>
				<td>${stu.birthday}</td>
				<td>
					<a href="EditServlet?sid=${stu.sid}">Update</a>
					<a href="#" onclick="doDelete(${stu.sid}, '${stu.sname}')">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	

</body>
</html>