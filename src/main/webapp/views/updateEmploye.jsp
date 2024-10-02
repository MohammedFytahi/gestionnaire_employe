<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="views/form.css">
  <title>Update Employee</title>
</head>
<body>

<h2>Update Employee</h2>

<form action="${pageContext.request.contextPath}/employes" method="post">
  <!-- Champ caché pour spécifier l'action -->
  <input type="hidden" name="action" value="mettreAJour">
  <!-- Champ caché pour l'ID de l'employé -->
  <input type="hidden" name="id" value="${employe.id}">

  <label for="nom">Name:</label>
  <input type="text" id="nom" name="nom" value="${employe.nom}" required><br>

  <label for="email">Email:</label>
  <input type="email" id="email" name="email" value="${employe.email}" required><br>

  <label for="telephone">Telephone:</label>
  <input type="text" id="telephone" name="telephone" value="${employe.telephone}" required><br>

  <label for="departement">Department:</label>
  <input type="text" id="departement" name="departement" value="${employe.departement}" required><br>

  <label for="poste">Position:</label>
  <input type="text" id="poste" name="poste" value="${employe.poste}" required><br>

  <input type="submit" value="Update">
  <a href="${pageContext.request.contextPath}/employes">Cancel</a>
</form>

</body>
</html>
