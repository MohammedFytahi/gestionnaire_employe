package com.example.gestionaire_employe.dao;

import com.example.gestionaire_employe.model.Employe;
import com.example.gestionaire_employe.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeDAO implements EmployeDAOInterface {

@Override
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

    @Override
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

    @Override

    public void mettreAJourEmploye(Employe employe) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(employe);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override

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
    @Override

    public Employe getEmployeById(int id) {
        Transaction transaction = null;
        Employe employe = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            employe = session.get(Employe.class, id);


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employe;
    }

    @Override

    public List<Employe> rechercherEmployesParNom(String nom) {
        Transaction transaction = null;
        List<Employe> employes = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = "FROM Employe WHERE nom LIKE :nom";
            Query<Employe> query = session.createQuery(hql, Employe.class);
            query.setParameter("nom", "%" + nom + "%");
            employes = query.list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employes;
    }

    @Override

    public List<String> getAllDepartements() {
        Transaction transaction = null;
        List<String> departements = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "SELECT DISTINCT departement FROM Employe";
            departements = session.createQuery(hql, String.class).list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return departements;
    }

    @Override
    public List<Employe> rechercherEmployesParNomEtDepartement(String nom, String departement) {
        Transaction transaction = null;
        List<Employe> employes = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = "FROM Employe WHERE nom LIKE :nom AND departement = :departement";
            Query<Employe> query = session.createQuery(hql, Employe.class);
            query.setParameter("nom", "%" + nom + "%");
            query.setParameter("departement", departement);

            employes = query.list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return employes;
    }

    @Override
    public List<Employe> getEmployesByDepartement(String departement) {
        Transaction transaction = null;
        List<Employe> employes = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();


            String hql = "FROM Employe WHERE departement = :departement";
            Query<Employe> query = session.createQuery(hql, Employe.class);
            query.setParameter("departement", departement);

            employes = query.list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employes;
    }


}
