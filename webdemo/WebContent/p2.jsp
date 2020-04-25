<%@ page language="java"
    contentType="text/html; charset=ISO-8859-1"
    import="java.util.Date"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Second Page</title>
</head>
<body>
<h1>Second</h1>

Name : ${param.name}
<p></p>
Num : ${param.num}
<hr/>

<%
   Date d = (Date) request.getAttribute("now");
%>
${requestScope.now} 

</body>
</html>