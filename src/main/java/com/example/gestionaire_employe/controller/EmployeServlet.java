package com.example.gestionaire_employe.controller;

import com.example.gestionaire_employe.model.Employe;
import com.example.gestionaire_employe.service.EmployeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class EmployeServlet extends HttpServlet {

    private final EmployeService employeService = new EmployeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employe> employes = employeService.getAllEmployes();
        request.setAttribute("employes", employes);
        request.getRequestDispatcher("/views/listeEmployes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action"); // Obtenir l'action

        if ("ajouter".equals(action)) {
            String nom = request.getParameter("nom");
            String email = request.getParameter("email");
            String telephone = request.getParameter("telephone");
            String departement = request.getParameter("departement");
            String poste = request.getParameter("poste");

            // Créer et enregistrer le nouvel employé
            Employe employe = new Employe(0, nom, email, telephone, departement, poste);
            employeService.ajouterEmploye(employe);

            // Rediriger vers la liste des employés après l'ajout réussi
            response.sendRedirect(request.getContextPath() + "/employes");
        } else if ("mettreAJour".equals(action)) {
            // Mettre à jour l'employé
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String email = request.getParameter("email");
            String telephone = request.getParameter("telephone");
            String departement = request.getParameter("departement");
            String poste = request.getParameter("poste");

            Employe employe = new Employe(id, nom, email, telephone, departement, poste);
            employeService.mettreAJourEmploye(employe);

            // Rediriger vers la liste des employés après la mise à jour réussie
            response.sendRedirect(request.getContextPath() + "/employes");
        } else if ("supprimer".equals(action)) {
            // Supprimer l'employé
            int id = Integer.parseInt(request.getParameter("id"));
            employeService.supprimerEmploye(id);

            // Rediriger vers la liste des employés après la suppression réussie
            response.sendRedirect(request.getContextPath() + "/employes");
        }
    }
}
