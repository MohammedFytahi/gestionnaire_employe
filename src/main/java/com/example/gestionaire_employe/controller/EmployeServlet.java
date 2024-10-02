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

        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String departement = request.getParameter("departement");
        String poste = request.getParameter("poste");

        // Create and save the new employee
        Employe employe = new Employe(0, nom, email, telephone, departement, poste);
        employeService.ajouterEmploye(employe);

        // Redirect to the list of employees after successful addition
        response.sendRedirect(request.getContextPath() + "/employes");
    }
}
