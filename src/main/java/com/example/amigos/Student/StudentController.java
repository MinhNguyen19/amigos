package com.example.amigos.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudent() {
        return studentService.getStudent();
    }

    @PostMapping
    public String createStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return "success";
    }

    @DeleteMapping(path = "{studentId}")
    public Long deleteStudent(@PathVariable("studentId") Long id) {
        return studentService.deleteStudent(id);
    }

    @PutMapping(path = "{id}")
    public Long updateStudent(@PathVariable Long id,
                              @RequestParam String name,
                              @RequestParam String email) {
        return studentService.updateStudent(id, name, email);
    }
}
