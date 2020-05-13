<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html> 
<head>
<meta charset="ISO-8859-1">
<title>Departments List</title>
</head>
<body>
	<h2>Departments List</h2>
	<ul>
		<c:forEach var="dept" items="${depts}">
			<li>${dept.id}, ${dept.name}</li>
		</c:forEach>
	</ul>
</body>
</html>