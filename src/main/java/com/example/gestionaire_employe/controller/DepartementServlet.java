package com.example.gestionaire_employe.controller;

import com.example.gestionaire_employe.dao.DepartementDao;
import com.example.gestionaire_employe.model.Departement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DepartementServlet", value = "/DepartementServlet")
public class DepartementServlet extends HttpServlet {

    private DepartementDao departementDao = new DepartementDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String description = request.getParameter("description");

        Departement departement = new Departement();
        departement.setName(name);
        departement.setDescription(description);
        departementDao.ajouterDepartement(departement);

        response.sendRedirect(request.getContextPath() + "/employes");
    }
}
