package com.example.gestionaire_employe;

import com.example.gestionaire_employe.config.HibernateUtil;
import com.example.gestionaire_employe.model.Employe;
import org.hibernate.Session;

public class TestHibernate {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();


            Employe employe = session.get(Employe.class, 1);
            System.out.println(employe);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}

