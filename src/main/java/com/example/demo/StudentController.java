package com.example.demo;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @PostMapping("/PostStudent")
    public Student postStudent(@RequestBody Student student) {

        return studentRepository.save(student);
        //  return Student ;
    }

    @GetMapping("/students")
    public List<Student> getStudent() {

        return studentRepository.findAll();
    }

    @GetMapping("/students/{student-id}")
    public Student getStudentById(@PathVariable("student-id") int studentId) {

        return studentRepository.findById(studentId).orElse(new Student());
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student>getStudentByName(@PathVariable("student-name") String name) {

        return studentRepository.findAllByFirstnameContaining(name);
    }

    @DeleteMapping("DeleteStudents/{student-id}")
    public void DeleteStudent (@PathVariable("student-id") int studentId) {

       studentRepository.deleteById(studentId);
    }



}
