package com.example.amigos.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email used");
        }
        studentRepository.save(student);
    }

    public Long deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (Objects.isNull(student)) {
            throw new IllegalStateException("student not exist");
        }
        studentRepository.deleteById(id);
        return id;
    }

    @Transactional
    public Long updateStudent(Long id, String name, String email) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (Objects.isNull(existingStudent)) {
            throw new IllegalStateException("Student not existed");
        }
        existingStudent.setName(name);
        existingStudent.setEmail(email);
        studentRepository.save(existingStudent);
        return id;
    }
}
