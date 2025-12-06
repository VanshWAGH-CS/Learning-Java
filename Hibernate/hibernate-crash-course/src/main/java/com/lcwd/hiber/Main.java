package com.lcwd.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Welcome to Hibernate Application");
        
        // Create Configuration object and load hibernate.cfg.xml
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        
        // Build SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        // Open a session
        Session session = sessionFactory.openSession();
        
        // Begin transaction
        Transaction transaction = session.beginTransaction();
        
        try {
            // Create Student objects
            Student student1 = new Student("John Doe", "john.doe@example.com", "New York");
            Student student2 = new Student("Jane Smith", "jane.smith@example.com", "Los Angeles");
            Student student3 = new Student("Bob Johnson", "bob.johnson@example.com", "Chicago");
            Student student4 = new Student("Alice Williams", "alice.williams@example.com", "Houston");
            
            // Save students to database
            System.out.println("Saving students to database...");
            session.persist(student1);
            session.persist(student2);
            session.persist(student3);
            session.persist(student4);
            
            // Commit transaction
            transaction.commit();
            System.out.println("Students saved successfully!");
            
            // Display saved students
            System.out.println("\nSaved Students:");
            System.out.println(student1);
            System.out.println(student2);
            System.out.println(student3);
            System.out.println(student4);
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close session and sessionFactory
            session.close();
            sessionFactory.close();
            System.out.println("\nSession closed successfully!");
        }
    }
}