<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First JSP</title>
</head>
<body>

<h1>First</h1>

<%
    request.setAttribute("now", new java.util.Date());
%>
<jsp:include page="p2.jsp">
   <jsp:param value="100" name="num"/>
</jsp:include>

<h2>Again in First</h2>

</body>
</html>