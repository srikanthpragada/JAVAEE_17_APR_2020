<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" 
           uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core"%>           
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
		<sf:input path="price" required="true" type="number" title="Price of product"  />
		<p/>
		Discount Rate<br/> 
		<sf:input path="discount" type="number" required="true" title="Discount Percentage" />
		<p></p>
		<input type="submit" Value="Calculate" />
		<p></p>
		<c:if test="${product.netPrice > 0}">
		    <h3> Net price : ${product.netPrice}</h3>
		</c:if>    
	</sf:form>
</body>
</html>