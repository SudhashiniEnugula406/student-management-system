package com.sudha.studentapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudha.studentapi.entity.Student;
import com.sudha.studentapi.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }
    @GetMapping("/{id}")
public Student getStudentById(@PathVariable Long id) {
    return service.getStudentById(id);
}

@PutMapping("/{id}")
public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
    return service.updateStudent(id, student);
}
}