package com.example.demo.Entities;


import jakarta.persistence.*;

@Entity
public class StudentProfile {


    @Id
    @GeneratedValue
    private Long id;

    private String bio ;


    @OneToOne
    @JoinColumn(name = "student_id")
    Student student;




    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentProfile() {

    }

    public StudentProfile(String bio) {
        this.bio = bio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
