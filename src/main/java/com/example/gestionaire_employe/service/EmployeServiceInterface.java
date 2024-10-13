package com.example.gestionaire_employe.service;

import com.example.gestionaire_employe.model.Employe;

import java.util.List;

public interface EmployeServiceInterface {

    void ajouterEmploye(Employe employe);

    List<Employe> getAllEmployes();

    void mettreAJourEmploye(Employe employe);

    void supprimerEmploye(int id);

    Employe getEmployeById(int id);

    List<Employe> rechercherEmployesParNom(String nom);

    List<String> getAllDepartements();

    List<Employe> rechercherEmployesParNomEtDepartement(String nom, String departement);

    List<Employe> getEmployesByDepartement(String departement);
}
