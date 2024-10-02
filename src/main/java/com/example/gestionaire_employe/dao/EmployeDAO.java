package com.example.gestionaire_employe.dao;

import com.example.gestionaire_employe.model.Employe;
import com.example.gestionaire_employe.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeDAO {


    public List<Employe> getAllEmployes() {
        Transaction transaction = null;
        List<Employe> employes = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            employes = session.createQuery("from Employe", Employe.class).list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employes;
    }
    public void ajouterEmploye(Employe employe) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(employe);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void mettreAJourEmploye(Employe employe) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(employe); // Met à jour l'employé existant
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void supprimerEmploye(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Employe employe = session.get(Employe.class, id);
            if (employe != null) {
                session.delete(employe);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Employe getEmployeById(int id) {
        Transaction transaction = null;
        Employe employe = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Commencer la transaction
            transaction = session.beginTransaction();

            // Récupérer l'employé par son ID
            employe = session.get(Employe.class, id);

            // Valider la transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employe;
    }
}
