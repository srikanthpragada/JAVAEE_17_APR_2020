<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employees By Department</title>
</head>
<body>
	<h2>Employees By Department</h2>
	<sf:form method="post" modelAttribute="department">
		Department 
		<sf:select path="id" items="${departments}"
			itemLabel="name" itemValue="id" />
		<input type="submit" Value="Employees" />
	</sf:form>

	<c:if test="${!empty employees}">
		<h2>Employees</h2>
		<table border="1" cellpadding="5px">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Salary</th>
			</tr>

			<c:forEach var="emp" items="${employees}">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.name}</td>
					<td>${emp.salary}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>