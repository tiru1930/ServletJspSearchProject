<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student list</title>
</head>
<body>
	<form action="StudentController.do" method="post">
		<fieldset>
			<div>
				<label for="student">Search student </label>
				 <input type="text"	name="searhvalue" value="" placeholder="Search by name or email or gender" />
			</div>
			<div>
				<input type="submit" value="Submit" />
				<input type="hidden" value="search" name="action" />
			</div>
			<div>
				<p>
					<a href="StudentController.do?action=insert">Add Student</a>
				</p>
			</div>
		</fieldset>
	</form>
	<div>
		<table>
			<thead>
				<tr>
					<th>Student ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Gender</th>
					<th>Age</th>
					<th>mail</th>
					<th>address</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="student">
					<tr>
						<td><c:out value="${student.studentId}" /></td>
						<td><c:out value="${student.firstName}" /></td>
						<td><c:out value="${student.lastName}" /></td>
						<td><c:out value="${student.gender}" /></td>
						<td><c:out value="${student.age}" /></td>
						<td><c:out value="${student.mail}"/></td>
						<td><c:out value="${student.address}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>