<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" 
           uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Price Calculation</title>
</head>
<body>
	<h2>Price Calculation</h2>
	<sf:form method="post" modelAttribute="product">
		Base Price <br/>
		<sf:input path="price" />
		<p/>
		Discount Rate<br/> 
		<sf:input path="discount" />
		<p></p>
		<input type="submit" Value="Calculate" />
		<p></p>
		<h3>${product.netPrice}</h3>
	</sf:form>
</body>
</html>