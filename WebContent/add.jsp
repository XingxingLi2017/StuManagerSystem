<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h3>Add Student Information</h3>

	<form action="AddServlet" method="post">
		<table border="1" width="600" cellpadding=3 cellspacing=2 >
			<tr>
				<td>name</td>
				<td><input type="text" name="sname"></td>
			</tr>
			<tr>
				<td>gender</td>
				<td>
					<input type="radio" name="gender" value="male" >male
					<input type="radio" name="gender" value="female" >female
				</td>
			</tr>
			<tr>
				<td>phone</td>
				<td><input type="text" name="phone" ></td>
			</tr>
			<tr>
				<td>birthday</td>
				<td><input type="text" name="birthday"></td>
			</tr>
			<tr>
				<td>Info</td>
				<td><textarea name="info" rows="3" cols="20" ></textarea></td>
			</tr>
			<tr>
				<td>hobbies</td>
				<td>
					<input type="checkbox" name="hobby" value="swim">Swim
					<input type="checkbox" name="hobby" value="basketball">Basketball
					<input type="checkbox" name="hobby" value="soccer">Soccer
					<input type="checkbox" name="hobby" value="reading">Reading
					<input type="checkbox" name="hobby" value="writing">Writing
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Student"></td>
			</tr>
		</table>
	</form>
</body>
</html>