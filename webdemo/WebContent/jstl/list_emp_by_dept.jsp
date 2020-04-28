<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:setDataSource var="oracle" driver="oracle.jdbc.driver.OracleDriver"
	url="jdbc:oracle:thin:@localhost:1521:XE" user="hr" password="hr" />

<c:if test="${!empty param.deptid}">

	<sql:query var="emplist" dataSource="${oracle}">
      select employee_id,first_name,salary
      from employees
      where department_id = ?
      <sql:param value="${param.deptid}" />
	</sql:query>

	<h2>Employees of Department [${param.deptid}]</h2>

	<c:if test='${emplist.rowCount == 0}'>
		<h3>Sorry! No Employees Found!</h3>
	</c:if>

	<ul>
		<c:forEach var="emp" items="${emplist.rows}">
			<li>${emp.employee_id},${emp.first_name},${emp.salary}
		</c:forEach>
	</ul>

</c:if>

<c:if test="${empty param.deptid}">
Sorry! Missing department id. Please provide a parameter deptid.
</c:if>