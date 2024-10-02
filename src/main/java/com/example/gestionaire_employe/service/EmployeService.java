package com.example.gestionaire_employe.service;

import com.example.gestionaire_employe.dao.EmployeDAO;
import com.example.gestionaire_employe.model.Employe;

import java.util.List;

public class EmployeService {

    private final EmployeDAO employeDAO = new EmployeDAO();

    public void ajouterEmploye(Employe employe) {
        employeDAO.ajouterEmploye(employe);
    }
    public List<Employe> getAllEmployes() {
        return employeDAO.getAllEmployes();
    }
    public void mettreAJourEmploye(Employe employe) {
        employeDAO.mettreAJourEmploye(employe);
    }

    public void supprimerEmploye(int id) {
        employeDAO.supprimerEmploye(id);
    }

}
