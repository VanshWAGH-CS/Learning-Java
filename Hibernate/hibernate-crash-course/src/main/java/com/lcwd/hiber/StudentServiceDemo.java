package com.lcwd.hiber;

import java.util.List;

public class StudentServiceDemo {
    public static void main(String[] args) {
        System.out.println("=== Student Service Demo ===\n");
        
        StudentService studentService = new StudentService();
        
        // 1. Save Student
        System.out.println("1. Saving a new student...");
        Student newStudent = new Student("Mike Brown", "mike.brown@example.com", "Seattle");
        boolean saved = studentService.saveStudent(newStudent);
        System.out.println("Save result: " + (saved ? "Success" : "Failed"));
        System.out.println();
        
        // 2. Get Student by ID
        System.out.println("2. Getting student by ID (ID: 1)...");
        Student student = studentService.getStudentById(1);
        if (student != null) {
            System.out.println("Retrieved: " + student);
        }
        System.out.println();
        
        // 3. Update Student
        System.out.println("3. Updating student...");
        if (student != null) {
            student.setCity("Boston");
            student.setEmail("updated.email@example.com");
            boolean updated = studentService.updateStudent(student);
            System.out.println("Update result: " + (updated ? "Success" : "Failed"));
            System.out.println("Updated student: " + student);
        }
        System.out.println();
        
        // 4. Get All Students using HQL
        System.out.println("4. Getting all students using HQL...");
        List<Student> allStudents = studentService.getAllStudents();
        if (allStudents != null) {
            System.out.println("All Students:");
            allStudents.forEach(s -> System.out.println("  - " + s));
        }
        System.out.println();
        
        // 5. Get Student by Name using HQL
        System.out.println("5. Getting student by name using HQL (Name: 'John Doe')...");
        List<Student> studentsByName = studentService.getStudentByName("John Doe");
        if (studentsByName != null) {
            System.out.println("Students with name 'John Doe':");
            studentsByName.forEach(s -> System.out.println("  - " + s));
        }
        System.out.println();
        
        // Close SessionFactory
        StudentService.closeSessionFactory();
        System.out.println("\n=== Demo Completed ===");
    }
}

