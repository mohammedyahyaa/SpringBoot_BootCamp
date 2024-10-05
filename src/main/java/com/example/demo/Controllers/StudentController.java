package com.example.demo.Controllers;


import com.example.demo.Dtos.StudentDto;
import com.example.demo.Dtos.StudentDtoResponse;
import com.example.demo.Entities.School;
import com.example.demo.Entities.Student;

import com.example.demo.Repositories.StudentRepository;
import org.springframework.http.HttpStatus;
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





    @PostMapping("/PostStudentDto")
    public StudentDtoResponse postStudentusingDto(@RequestBody StudentDto studentDto) {

        var student = StudentDto(studentDto) ;

        var studentDtoResponse = studentRepository.save(student);

        return studentDtoResponse(studentDtoResponse) ;
        //return studentRepository.save(student);
        //  return Student ;
    }


    private StudentDtoResponse studentDtoResponse(Student student) {

        return new StudentDtoResponse (
            student.getFirstname(),
            student.getLastname(),
            student.getEmail()

        ) ;

    }

    private Student StudentDto (StudentDto studentDto) {

        Student student = new Student();
        student.setFirstname(studentDto.firstname());
        student.setLastname(studentDto.lastname());
        student.setEmail(studentDto.email());
        var school = new School() ;
        school.setId(studentDto.schoolId());
        return student;
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
    @ResponseStatus(HttpStatus.OK)
    public void DeleteStudent (@PathVariable("student-id") int studentId) {

       studentRepository.deleteById(studentId);
    }



}
