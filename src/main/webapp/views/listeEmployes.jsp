<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="views/list.css">
  <title>List of Employees</title>
</head>
<body>

<table class="container">
  <thead>
  <tr>
    <th><h1>ID</h1></th>
    <th><h1>Name</h1></th>
    <th><h1>Email</h1></th>
    <th><h1>Telephone</h1></th>
    <th><h1>Department</h1></th>
    <th><h1>Position</h1></th>
    <th><h1>Actions</h1></th> <!-- Nouvelle colonne pour les actions -->
  </tr>
  </thead>
  <tbody>
  <c:forEach var="employe" items="${employes}">
    <tr>
      <td>${employe.id}</td>
      <td>${employe.nom}</td>
      <td>${employe.email}</td>
      <td>${employe.telephone}</td>
      <td>${employe.departement}</td>
      <td>${employe.poste}</td>
      <td>
        <a class="btn" href="views/updateEmploye.jsp?id=${employe.id}">Update</a>
        <a class="btn" href="views/deleteEmploye.jsp?id=${employe.id}" onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<a class="btn" href="views/ajouterEmploye.jsp">Add New Employee</a>

</body>
</html>
