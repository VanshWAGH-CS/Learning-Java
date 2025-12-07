package com.lcwd.hiber;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentService {
    
    private static SessionFactory sessionFactory;
    
    // Initialize SessionFactory (Singleton pattern)
    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
            System.out.println("SessionFactory initialized successfully!");
        } catch (Exception e) {
            System.err.println("Error initializing SessionFactory: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Save a student to the database
     * @param student The student object to save
     * @return true if saved successfully, false otherwise
     */
    public boolean saveStudent(Student student) {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            
            session.persist(student);
            transaction.commit();
            
            System.out.println("Student saved successfully: " + student);
            return true;
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error saving student: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    /**
     * Get a student by ID
     * @param id The student ID
     * @return Student object if found, null otherwise
     */
    public Student getStudentById(int id) {
        Session session = null;
        
        try {
            session = sessionFactory.openSession();
            Student student = session.find(Student.class, id);
            
            if (student != null) {
                System.out.println("Student found: " + student);
            } else {
                System.out.println("Student with ID " + id + " not found!");
            }
            
            return student;
            
        } catch (Exception e) {
            System.err.println("Error getting student by ID: " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    /**
     * Update a student in the database
     * @param student The student object with updated values
     * @return true if updated successfully, false otherwise
     */
    public boolean updateStudent(Student student) {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            
            session.merge(student);
            transaction.commit();
            
            System.out.println("Student updated successfully: " + student);
            return true;
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error updating student: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    /**
     * Get all students using HQL (Hibernate Query Language)
     * @return List of all students
     */
    public List<Student> getAllStudents() {
        Session session = null;
        
        try {
            session = sessionFactory.openSession();
            
            // HQL Query: from Student (entity name, not table name)
            String hql = "from Student";
            Query query = session.createQuery(hql, Student.class);
            @SuppressWarnings("unchecked")
            List<Student> students = query.getResultList();
            
            System.out.println("Total students found: " + students.size());
            return students;
            
        } catch (Exception e) {
            System.err.println("Error getting all students: " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    /**
     * Get student by name using HQL (Hibernate Query Language)
     * @param name The student name to search for
     * @return List of students matching the name
     */
    public List<Student> getStudentByName(String name) {
        Session session = null;
        
        try {
            session = sessionFactory.openSession();
            
            // HQL Query with parameter
            String hql = "from Student s where s.name = :studentName";
            Query query = session.createQuery(hql, Student.class);
            query.setParameter("studentName", name);
            @SuppressWarnings("unchecked")
            List<Student> students = query.getResultList();
            
            System.out.println("Students found with name '" + name + "': " + students.size());
            return students;
            
        } catch (Exception e) {
            System.err.println("Error getting student by name: " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    /**
     * Close the SessionFactory (should be called when application shuts down)
     */
    public static void closeSessionFactory() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
            System.out.println("SessionFactory closed successfully!");
        }
    }
}

