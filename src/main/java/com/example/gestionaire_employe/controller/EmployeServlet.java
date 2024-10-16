package com.example.gestionaire_employe.controller;

import com.example.gestionaire_employe.dao.EmployeDAO;
import com.example.gestionaire_employe.model.Employe;
import com.example.gestionaire_employe.service.EmployeService;
import com.example.gestionaire_employe.service.EmployeServiceInterface;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class EmployeServlet extends HttpServlet {

    private final EmployeServiceInterface employeService = new EmployeService(new EmployeDAO());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String recherche = request.getParameter("recherche");
        String departement = request.getParameter("departement");

        List<Employe> employes;


        if ("modifier".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Employe employe = employeService.getEmployeById(id);
            request.setAttribute("employe", employe);
            request.getRequestDispatcher("/views/updateEmploye.jsp").forward(request, response);
            return;
        }


        if (recherche != null && !recherche.isEmpty()) {
            if (departement != null && !departement.isEmpty()) {
                employes = employeService.rechercherEmployesParNomEtDepartement(recherche, departement);
            } else {
                employes = employeService.rechercherEmployesParNom(recherche);
            }
        } else if (departement != null && !departement.isEmpty()) {
            employes = employeService.getEmployesByDepartement(departement);
        } else {
            employes = employeService.getAllEmployes();
        }


        List<String> departements = employeService.getAllDepartements();
        request.setAttribute("departements", departements);


        request.setAttribute("employes", employes);
        request.getRequestDispatcher("/views/listeEmployes.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("ajouter".equals(action)) {
            String nom = request.getParameter("nom");
            String email = request.getParameter("email");
            String telephone = request.getParameter("telephone");
            String departement = request.getParameter("departement");
            String poste = request.getParameter("poste");


            if (nom == null || nom.isEmpty() || email == null || email.isEmpty() ||
                    telephone == null || telephone.isEmpty() || departement == null ||
                    departement.isEmpty() || poste == null || poste.isEmpty()) {
                request.setAttribute("erreur", "Tous les champs sont obligatoires.");
                request.getRequestDispatcher("/views/ajouterEmploye.jsp").forward(request, response);
                return;
            }


            if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                request.setAttribute("erreur", "L'email n'est pas valide.");
                request.getRequestDispatcher("/views/ajouterEmploye.jsp").forward(request, response);
                return;
            }


            if (!telephone.matches("^\\+?\\d{10,15}$")) {
                request.setAttribute("erreur", "Le numéro de téléphone n'est pas valide.");
                request.getRequestDispatcher("/views/ajouterEmploye.jsp").forward(request, response);
                return;
            }


            Employe employe = new Employe(0, nom, email, telephone, departement, poste);
            employeService.ajouterEmploye(employe);

            response.sendRedirect(request.getContextPath() + "/employes");

        } else if ("mettreAJour".equals(action)) {
            String idStr = request.getParameter("id");
            if (idStr != null && !idStr.isEmpty()) {
                int id = Integer.parseInt(idStr);
                String nom = request.getParameter("nom");
                String email = request.getParameter("email");
                String telephone = request.getParameter("telephone");
                String departement = request.getParameter("departement");
                String poste = request.getParameter("poste");

                Employe employe = new Employe(id, nom, email, telephone, departement, poste);
                employeService.mettreAJourEmploye(employe);

                response.sendRedirect(request.getContextPath() + "/employes");
            } else {

                response.sendRedirect(request.getContextPath() );
            }
        }
        else if ("supprimer".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));
            employeService.supprimerEmploye(id);


            response.sendRedirect(request.getContextPath() + "/employes");
        }
    }
}
