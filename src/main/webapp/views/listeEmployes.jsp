<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="views/css/list.css">
  <title>List of Employees</title>
</head>
<body>


<div class="filter-container">
  <form action="${pageContext.request.contextPath}/employes" method="get" class="search-form">
    <input type="text" name="recherche" placeholder="Rechercher par nom" value="${param.recherche}" />
    <input type="submit" value="Rechercher" />
  </form>

  <form action="${pageContext.request.contextPath}/employes" method="get" class="filter-form">
    <label for="departement"> </label>
    <select name="departement" id="departement">
      <option value="">Tous les départements</option>
      <c:forEach var="departement" items="${departements}">
        <option value="${departement}">${departement}</option>
      </c:forEach>
    </select>
    <input type="submit" value="Filtrer" />
  </form>
</div>


<table class="container">
  <thead>
  <tr>
    <th><h1>ID</h1></th>
    <th><h1>Name</h1></th>
    <th><h1>Email</h1></th>
    <th><h1>Telephone</h1></th>
    <th><h1>Department</h1></th>
    <th><h1>Position</h1></th>
    <th><h1>Actions</h1></th>
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
        <a class="btn" href="${pageContext.request.contextPath}/employes?action=modifier&id=${employe.id}">Update</a>
        <form action="${pageContext.request.contextPath}/employes" method="post" style="display:inline;">
          <input type="hidden" name="action" value="supprimer">
          <input type="hidden" name="id" value="${employe.id}">
          <input type="submit" value="Supprimer" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet employé ?');">
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<a class="btn" href="views/ajouterEmploye.jsp">Add New Employee</a>

</body>
</html>
