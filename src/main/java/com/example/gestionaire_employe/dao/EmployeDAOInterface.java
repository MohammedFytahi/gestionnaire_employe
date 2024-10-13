package com.example.gestionaire_employe.dao;

import com.example.gestionaire_employe.model.Employe;

import java.util.List;

public interface EmployeDAOInterface {


    List<Employe> getAllEmployes();


    void ajouterEmploye(Employe employe);


    void mettreAJourEmploye(Employe employe);


    void supprimerEmploye(int id);

    Employe getEmployeById(int id);


    List<Employe> rechercherEmployesParNom(String nom);

    List<String> getAllDepartements();


    List<Employe> rechercherEmployesParNomEtDepartement(String nom, String departement);


    List<Employe> getEmployesByDepartement(String departement);
}
