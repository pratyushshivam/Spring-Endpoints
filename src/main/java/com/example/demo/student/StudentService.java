package com.example.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents(){
        //	We write the return type so here the returntype is list of strings so we use list
        return List.of(new Student(1L,"Pratyush", "pratyushshivam7@gmail.com",
                LocalDate.of(2000, Month.DECEMBER,5),21));
    }
}
