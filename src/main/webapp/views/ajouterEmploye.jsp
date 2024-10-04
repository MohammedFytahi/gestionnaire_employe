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

<form action="${pageContext.request.contextPath}/employes" method="post" onsubmit="return validerFormulaire()">
    <input type="hidden" name="action" value="ajouter">

    <div>
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" required pattern="[A-Za-z\s]+" title="Le nom doit uniquement contenir des lettres."><br>
    </div>

    <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
    </div>

    <div>
        <label for="telephone">Téléphone:</label>
        <input type="text" id="telephone" name="telephone" required pattern="\+?\d{10,15}" title="Entrez un numéro de téléphone valide (10 à 15 chiffres)."><br>
    </div>

    <div>
        <label for="departement">Département:</label>
        <input type="text" id="departement" name="departement" required><br>
    </div>

    <div>
        <label for="poste">Poste:</label>
        <input type="text" id="poste" name="poste" required><br>
    </div>

    <div style="text-align:center;">
        <input type="submit" value="Ajouter">
    </div>
</form>

<p style="text-align:center;">
    <a href="${pageContext.request.contextPath}/employes">Retourner à la liste des employés</a>
</p>
</body>
<script>
    function validerFormulaire() {
        var nom = document.getElementById("nom").value;
        var email = document.getElementById("email").value;
        var telephone = document.getElementById("telephone").value;
        var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
        var telephonePattern = /^\+?\d{10,15}$/;

        if (nom === "" || email === "" || telephone === "") {
            alert("Tous les champs sont obligatoires.");
            return false;
        }

        if (!emailPattern.test(email)) {
            alert("Veuillez entrer un email valide.");
            return false;
        }

        if (!telephonePattern.test(telephone)) {
            alert("Veuillez entrer un numéro de téléphone valide (10 à 15 chiffres).");
            return false;
        }

        return true;
    }
</script>

</html>
