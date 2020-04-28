<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee Salary</title>
</head>
<body>
	<h1>Update Employee Salary</h1>
	<form action="update_salary.jsp">
		Employee Id <br /> <input type="number" required name="empid"
			value="${param.empid}" />
		<p></p>
		New Salary <br /> <input type="number" required name="salary"
			value="${param.salary}" />
		<p></p>
		<input type="submit" value="Update" />
	</form>

	<c:if test="${!empty param.empid}">
	    <!-- catch exception into ex variable -->
		<c:catch var="ex">
			<!--  Connect to Oracle  -->
			<sql:setDataSource var="oracle"
				driver="oracle.jdbc.driver.OracleDriver"
				url="jdbc:oracle:thin:@localhost:1521:XE" user="hr" password="hr" />

			<sql:update dataSource="${oracle}" var="uc">
 			update employees set salary = ? where employee_id = ?
            <sql:param value="${param.salary}" />
				<sql:param value="${param.empid}" />
			</sql:update>

			<c:if test="${uc == 1}">
				<h3>Updated Employee Successfully!</h3>
			</c:if>

			<c:if test="${uc == 0}">
				<h3>Employee Id Not Found!</h3>
			</c:if>
		</c:catch>
		
        <!--  if variable ex is not empty then it has an exception -->		
		<c:if test="${!empty ex}">
		   <h3>Sorry! Error during updation : ${ex.message}</h3>
		</c:if>
	</c:if>

</body>
</html>