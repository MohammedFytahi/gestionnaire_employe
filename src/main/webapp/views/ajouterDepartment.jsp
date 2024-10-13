<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Ajouter un Employé</title>
  <link rel="stylesheet" type="text/css" href="css/form.css">
</head>
<body>
<h2 style="text-align:center;">Ajouter un Employé</h2>

<% String erreur = (String) request.getAttribute("erreur"); %>
<% if (erreur != null) { %>
<p style="color:red; text-align:center;"><%= erreur %></p>
<% } %>

<form action="${pageContext.request.contextPath}/DepartementServlet" method="post" >
  <input type="hidden" name="action" value="ajouter">

  <div>
    <label for="name">Nom:</label>
    <input type="text" id="name" name="name" required pattern="[A-Za-z\s]+" title="Le nom doit uniquement contenir des lettres."><br>
  </div>

  <div>
    <label for="description">Email:</label>
    <input type="text" id="description" name="description" required><br>
  </div>
  <input type="submit" value="submit">


</form>

<p style="text-align:center;">
  <a href="${pageContext.request.contextPath}/employes">Retourner à la liste des employés</a>
</p>
</body>


</html>
