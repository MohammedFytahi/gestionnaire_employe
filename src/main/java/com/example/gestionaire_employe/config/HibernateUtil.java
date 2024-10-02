package com.example.gestionaire_employe.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            System.out.println("Initializing Hibernate configuration...");
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            System.out.println("Building SessionFactory...");
            sessionFactory = configuration.buildSessionFactory();
            System.out.println("SessionFactory built successfully.");
        } catch (Throwable ex) {
            ex.printStackTrace(); // Print the stack trace for better insight
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

}

