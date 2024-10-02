<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un Employé</title>
    <link rel="stylesheet" type="text/css" href="form.css">
</head>
<body>
<h2>Ajouter un Employé</h2>

<% String erreur = (String) request.getAttribute("erreur"); %>
<% if (erreur != null) { %>
<p style="color:red;"><%= erreur %></p>
<% } %>

<form action="${pageContext.request.contextPath}/employes" method="post">

    <label for="nom">Nom:</label>
    <input type="text" id="nom" name="nom" required><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br>

    <label for="telephone">Téléphone:</label>
    <input type="text" id="telephone" name="telephone" required><br>

    <label for="departement">Département:</label>
    <input type="text" id="departement" name="departement" required><br>

    <label for="poste">Poste:</label>
    <input type="text" id="poste" name="poste" required><br>

    <input type="submit" value="Ajouter">
</form>
</body>
</html>
