<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>All Employee</title>
</head>
<body>
<h1>List Of Employees</h1> 
<h3><a href="add.html">Add More Employee</a></h3>
<c:if test="${!empty employees}">
  <table align="left" border="1">
    <tr>
      <th>EmpId</th>
      <th>Emp address</th>
      <th>Emp name</th>
      <th>Emp salary</th>
      <th>Action on row</th>
    </tr>
    
        <c:forEach items="${employees}" var="emp" >
      <tr>
        <td><c:out value="${emp.id}"/></td>
        <td><c:out value="${emp.address}"/></td>
        <td><c:out value="${emp.ename}"/></td>
        <td><c:out value="${emp.salary}"/></td>
        <td align="center"><a href="edit.html?id=${employee.id}">Edit</a>
        <a href="delete.html?id=${employee.id}">Delete</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</body>
</html>