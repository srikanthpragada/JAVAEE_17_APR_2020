<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

     <c:set var="a" value="10" scope="page" />
     <c:forEach var="i" begin="1" end="10">
          ${i}
          <br/>
     </c:forEach>
     
     <c:out value="${a}"/>
     <h1>Heading!</h1>
</body>
</html>