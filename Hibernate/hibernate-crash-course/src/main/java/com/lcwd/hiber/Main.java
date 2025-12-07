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
            
            // Create Certificates for students (demonstrating One-to-Many relationship)
            Certificate cert1 = new Certificate("Java Programming", "Oracle", "2024-01-15");
            Certificate cert2 = new Certificate("Spring Framework", "VMware", "2024-02-20");
            Certificate cert3 = new Certificate("Hibernate ORM", "Red Hat", "2024-03-10");
            Certificate cert4 = new Certificate("MySQL Database", "Oracle", "2024-01-25");
            Certificate cert5 = new Certificate("Web Development", "W3C", "2024-02-28");
            
            // Associate certificates with students
            student1.addCertificate(cert1);  // John has Java Programming
            student1.addCertificate(cert2);  // John has Spring Framework
            
            student2.addCertificate(cert3);  // Jane has Hibernate ORM
            student2.addCertificate(cert4);  // Jane has MySQL Database
            
            student3.addCertificate(cert5);  // Bob has Web Development
            
            // student4 has no certificates (to show optional relationship)
            
            // Save students to database (certificates will be saved automatically due to cascade)
            System.out.println("Saving students with certificates to database...");
            session.persist(student1);
            session.persist(student2);
            session.persist(student3);
            session.persist(student4);
            
            // Commit transaction
            transaction.commit();
            System.out.println("Students and certificates saved successfully!");
            
            // Display saved students with their certificates
            System.out.println("\n=== Saved Students with Certificates ===");
            System.out.println("\n" + student1);
            System.out.println("  Certificates:");
            student1.getCertificates().forEach(cert -> System.out.println("    - " + cert));
            
            System.out.println("\n" + student2);
            System.out.println("  Certificates:");
            student2.getCertificates().forEach(cert -> System.out.println("    - " + cert));
            
            System.out.println("\n" + student3);
            System.out.println("  Certificates:");
            student3.getCertificates().forEach(cert -> System.out.println("    - " + cert));
            
            System.out.println("\n" + student4);
            System.out.println("  Certificates: None");
            
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