package com.example.gestionaire_employe.dao;

import com.example.gestionaire_employe.config.HibernateUtil;
import com.example.gestionaire_employe.model.Departement;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DepartementDao {

    public void ajouterDepartement(Departement departement){
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.save(departement);
            transaction.commit();

        }catch(Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
