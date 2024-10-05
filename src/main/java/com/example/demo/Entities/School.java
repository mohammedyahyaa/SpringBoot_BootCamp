package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class School {




    @Id
    @GeneratedValue
    private Integer id;

    private String name;


    @OneToMany(
            mappedBy = "school"
    )
    @JsonManagedReference
    private List<Student> students  ;


    public School(String name) {
        this.name = name;
    }
    public School() {}



    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
