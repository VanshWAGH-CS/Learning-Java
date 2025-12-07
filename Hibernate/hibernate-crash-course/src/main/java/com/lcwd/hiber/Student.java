package com.lcwd.hiber;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "city")
    private String city;
    
    // One-to-Many relationship: One student can have many certificates
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Certificate> certificates = new ArrayList<>();
    
    // Default constructor (required by Hibernate)
    public Student() {
    }
    
    // Parameterized constructor
    public Student(String name, String email, String city) {
        this.name = name;
        this.email = email;
        this.city = city;
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public List<Certificate> getCertificates() {
        return certificates;
    }
    
    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }
    
    // Helper method to add certificate
    public void addCertificate(Certificate certificate) {
        certificates.add(certificate);
        certificate.setStudent(this);
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", certificates=" + certificates.size() + " certificates" +
                '}';
    }
}

