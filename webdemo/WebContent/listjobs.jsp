<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="javax.sql.rowset.CachedRowSet,oracle.jdbc.rowset.OracleCachedRowSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Jobs</title>
</head>
<body>
	<h1>Jobs</h1>
	<table border='1' cellpadding="5pt" style='width:100%'>
	<tr style="background-color:navy;color:white">
	<th>Id </th>
	<th>Title</th>
	<th>Min Salary</th>
	
    <%
		CachedRowSet crs = new OracleCachedRowSet();
		crs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		crs.setUsername("hr");
		crs.setPassword("hr");
		crs.setCommand("select * from jobs");
		crs.execute();

		while (crs.next()) {
      %>			
			<tr>
			<td> <%= crs.getString("job_id")%> </td>
			<td> <%= crs.getString("job_title")%> </td>
			<td> <%= crs.getString("min_salary")%> </td>
			</tr>
	  <%		
		}
	   %>
	</table>
</body>
</html>