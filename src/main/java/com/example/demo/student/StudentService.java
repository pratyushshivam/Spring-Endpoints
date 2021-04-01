package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired

    public List<Student> getStudents(){
        //	We write the return type so here the returntype is list of strings so we use list
        return studentRepository.findAll(); // returns a list to us
    }

    public void addNewStudent(Student student) {
         Optional<Student> studentOptional =studentRepository.findStudentByEmail(student.getEmail());
         if(studentOptional.isPresent()){
             throw new IllegalStateException("Email already taken");
         }
         else{
             studentRepository.save(student);
         }
        System.out.println(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with id "+ studentId+"does not exist.");
        }
        studentRepository.deleteById(studentId);

    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email){
        Student student = studentRepository.findById(studentId).orElseThrow(()->
                new IllegalStateException("Student with id = "+studentId + "does not exist."));
        if(name!=null && name.length()>0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(), email) ){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email already taken.");
            }//PUT http://localhost:8080/api/v1/student/1?name=Shivam&email=maria@gmail.com
            student.setEmail(email);
        }
    }
}
