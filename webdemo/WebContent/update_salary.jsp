<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee Salary</title>
</head>
<body>
	<h1>Update Employee Salary</h1>
	<form action="update_salary.jsp">
		Employee Id <br /> <input type="number" required name="empid" value="${param.empid}" />
		<p></p>
		New Salary <br /> <input type="number" required name="salary" value="${param.salary}" />
		<p></p>
		<input type="submit" value="Update" />
	</form>

	<h3>
		<%
      // Process that data send from client
      String empid = request.getParameter("empid");
      if(empid == null)  // no parameter
         return;  // stop JSP

      String salary = request.getParameter("salary");
      // update EMPLOYEES table

      try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr")) 
      {
			PreparedStatement ps = con.prepareStatement
					  ("update employees set salary = ? where employee_id = ?");
			ps.setInt(1, Integer.parseInt(salary));
			ps.setInt(2, Integer.parseInt(empid));
			int count = ps.executeUpdate();
			if (count == 1)
				out.println("Updated Salary Successfully!");
			else
				out.println("Employee Id Not Found!");

			ps.close();
	   }
       catch(Exception ex) {
            out.println("Error  " + ex.getMessage());
       }
    %>
	</h3>

</body>
</html>