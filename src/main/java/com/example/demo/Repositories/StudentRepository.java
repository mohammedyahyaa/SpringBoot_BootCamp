package com.example.demo.Repositories;


import com.example.demo.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    // get the list of students if the URL contains firstname value
    List<Student> findAllByFirstnameContaining(String name);



    List<Student>findAllByFirstnameContainingAndLastnameContaining(String firstname,String lastname);


    List<Student> findByFirstnameStartingWith(String firstname);



}
