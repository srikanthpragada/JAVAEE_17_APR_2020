<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
   Object obj = session.getAttribute("count");
   if (obj == null)  // not found 
       session.setAttribute("count",1);
   else
	   session.setAttribute("count", ((Integer) obj) + 1);
%>

<h2>Count : ${sessionScope.count}</h2>

</body>
</html>