<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student Information</title>
<style>
	tr, td {
		margin: 1px;
	}
</style>
</head>
<body>
	<h3>Update Student Information</h3>

	<form action="UpdateServlet" method="post">
		<input type="hidden" name="sid" value="${stu.sid}" >
		<table border="1" width="600" cellpadding=3 cellspacing=2 >
			<tr>
				<td>name</td>
				<td><input type="text" name="sname" value="${stu.sname }"></td>
			</tr>
			<tr>
				<td>gender</td>
				<td>
				<c:if test="${stu.gender == 'male' }">
					<input type="radio" name="gender" value="male" checked >male
					<input type="radio" name="gender" value="female" >female
				</c:if>
				<c:if test="${stu.gender == 'female' }">
					<input type="radio" name="gender" value="male">male
					<input type="radio" name="gender" value="female" checked>female
				</c:if>
				</td>
			</tr>
			<tr>
				<td>phone</td>
				<td><input type="text" name="phone" value="${stu.phone}" ></td>
			</tr>
			<tr>
				<td>birthday</td>
				<td><input type="text" name="birthday" value="${stu.birthday }" ></td>
			</tr>
			<tr>
				<td>Info</td>
				<td><textarea name="info" rows="3" cols="20" >${stu.info}</textarea></td>
			</tr>
			<tr>
				<td>hobbies</td>
				<td>
					<input type="checkbox" name="hobby" value="swim" <c:if test="${fn:contains(stu.hobby, 'swim')}" >checked</c:if>>Swim
					<input type="checkbox" name="hobby" value="basketball" <c:if test="${fn:contains(stu.hobby, 'basketball')}" >checked</c:if> >Basketball
					<input type="checkbox" name="hobby" value="soccer" <c:if test="${fn:contains(stu.hobby, 'soccer')}" >checked</c:if> >Soccer
					<input type="checkbox" name="hobby" value="reading" <c:if test="${fn:contains(stu.hobby, 'reading')}" >checked</c:if> >Reading
					<input type="checkbox" name="hobby" value="writing" <c:if test="${fn:contains(stu.hobby, 'writing')}" >checked</c:if> >Writing
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="update"></td>
			</tr>
		</table>
	</form>
</body>
</html>