package com.example.gestionaire_employe.service;

import com.example.gestionaire_employe.dao.EmployeDAOInterface;
import com.example.gestionaire_employe.model.Employe;

import java.util.List;

public class EmployeService implements EmployeServiceInterface {

    private final EmployeDAOInterface employeDAO;

    public EmployeService(EmployeDAOInterface employeDAO) {
        this.employeDAO = employeDAO;
    }

    @Override
    public void ajouterEmploye(Employe employe) {
        employeDAO.ajouterEmploye(employe);
    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeDAO.getAllEmployes();
    }

    @Override
    public void mettreAJourEmploye(Employe employe) {
        employeDAO.mettreAJourEmploye(employe);
    }

    @Override
    public void supprimerEmploye(int id) {
        employeDAO.supprimerEmploye(id);
    }

    @Override
    public Employe getEmployeById(int id) {
        return employeDAO.getEmployeById(id);
    }

    @Override
    public List<Employe> rechercherEmployesParNom(String nom) {
        return employeDAO.rechercherEmployesParNom(nom);
    }

    @Override
    public List<String> getAllDepartements() {
        return employeDAO.getAllDepartements();
    }

    @Override
    public List<Employe> rechercherEmployesParNomEtDepartement(String nom, String departement) {
        return employeDAO.rechercherEmployesParNomEtDepartement(nom, departement);
    }

    @Override
    public List<Employe> getEmployesByDepartement(String departement) {
        return employeDAO.getEmployesByDepartement(departement);
    }
}
