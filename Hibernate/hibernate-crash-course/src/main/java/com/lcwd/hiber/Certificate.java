package com.lcwd.hiber;

import jakarta.persistence.*;

@Entity
@Table(name = "certificate")
public class Certificate {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "certificate_name")
    private String certificateName;
    
    @Column(name = "issuing_organization")
    private String issuingOrganization;
    
    @Column(name = "issue_date")
    private String issueDate;
    
    // Many-to-One relationship: Many certificates belong to one student
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    
    // Default constructor (required by Hibernate)
    public Certificate() {
    }
    
    // Parameterized constructor
    public Certificate(String certificateName, String issuingOrganization, String issueDate) {
        this.certificateName = certificateName;
        this.issuingOrganization = issuingOrganization;
        this.issueDate = issueDate;
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getCertificateName() {
        return certificateName;
    }
    
    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }
    
    public String getIssuingOrganization() {
        return issuingOrganization;
    }
    
    public void setIssuingOrganization(String issuingOrganization) {
        this.issuingOrganization = issuingOrganization;
    }
    
    public String getIssueDate() {
        return issueDate;
    }
    
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
    
    public Student getStudent() {
        return student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    @Override
    public String toString() {
        return "Certificate{" +
                "id=" + id +
                ", certificateName='" + certificateName + '\'' +
                ", issuingOrganization='" + issuingOrganization + '\'' +
                ", issueDate='" + issueDate + '\'' +
                '}';
    }
}

