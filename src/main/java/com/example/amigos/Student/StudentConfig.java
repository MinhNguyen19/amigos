package com.example.amigos.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student s1 = new Student("a", "b", LocalDate.of(2000, 12, 12));
            Student s2 = new Student("a1", "b1", LocalDate.of(2000, 12, 12));
            studentRepository.saveAll(List.of(s1, s2));
        };
    }
}
