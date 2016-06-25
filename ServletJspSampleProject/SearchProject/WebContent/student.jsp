<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Add New Student</title>
</head>
<body>
	<form action="StudentController.do" method="post">
		<fieldset>
			<div>
				<label for="firstName">First Name</label> <input type="text"
					name="firstName" value="<c:out value="${student.firstName}" />"
					placeholder="First Name" />
			</div>
			<div>
				<label for="lastName">Last Name</label> <input type="text"
					name="lastName" value="<c:out value="${student.lastName}" />"
					placeholder="Last Name" />
			</div>
			<div>
				<label for="gender">Gender</label> <input type="text" name="gender"
					value="<c:out value="${student.gender}" />" placeholder="Gender" />
			</div>
			<div>
				<label for="age">age</label> <input type="text" name="age"
					value="<c:out value="${student.age}" />" placeholder="age" />
			</div>
			<div>
				<label for="mail">Mail</label> <input type="text" name="mail"
					value="<c:out value="${student.mail}" />" placeholder="mail" />
			</div>
			<div>
				<label for="address">Address</label> <input type="text" name="address"
					value="<c:out value="${student.address}" />" placeholder="address" />
			</div>
			<div>
				<input type="submit" value="Submit" />
				<input type="hidden" value="addstudent" name="action" />
			</div>
		</fieldset>
	</form>
</body>
</html>