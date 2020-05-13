<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Department</title>
</head>
<body>
	<h2>Edit Department</h2>
	<c:if test="${dept != null}">
		<sf:form method="post" modelAttribute="dept">
		Id : <sf:input path="id" />
		Name : <sf:input path="name" />
			<p></p>
			<input type="submit" Value="Update" />
		</sf:form>
	</c:if>

	<h4>${error}</h4>

</body>
</html>