<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee with JavaBean</title>
</head>
<body>
	<h1>Update Employee With JavaBean</h1>
	<form action="update_salary2.jsp">
		Employee Id <br /> <input type="number" required name="empid"
			value="${param.empid}" />
		<p></p>
		New Salary <br /> <input type="number" required name="salary"
			value="${param.salary}" />
		<p></p>
		<input type="submit" value="Update" />
	</form>

	<%
	   // Process that data send from client
	   String empid = request.getParameter("empid");
	   if (empid == null) // no parameter
		 return; // stop JSP
	%>

	<jsp:useBean class="beans.EmployeeBean" scope="page" id="empBean" />
	<jsp:setProperty name="empBean" property="*" />
	
	<%
		empBean.updateSalary();
	%>
	
	
	<h3> ${empBean.message}	</h3>


</body>
</html>