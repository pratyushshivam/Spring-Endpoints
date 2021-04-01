package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
         return args -> {
             Student pratyush = new Student("Pratyush", "pratyushshivam7@gmail.com",
                     LocalDate.of(2000, Month.DECEMBER,5));
             Student robin = new Student("Robin", "robin@gmail.com",
                     LocalDate.of(2003, Month.DECEMBER,2));
             repository.saveAll(
                     List.of(pratyush,robin) // save a list of students to database
             );

         };
    }
}
