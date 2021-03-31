package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired // the current StudentController will automatically be linked as the curent object
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping // everything that needs to be displayed
    public List<Student> getStudents(){
        return studentService.getStudents();
    }


}
