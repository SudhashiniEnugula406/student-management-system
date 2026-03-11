package com.sudha.studentapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sudha.studentapi.entity.Student;
import com.sudha.studentapi.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
    public Student getStudentById(Long id) {
    return repo.findById(id).orElse(null);
}
   public Student updateStudent(Long id, Student student) {

    Student existingStudent = repo.findById(id).orElse(null);

    if (existingStudent != null) {
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setCourse(student.getCourse());

        return repo.save(existingStudent);
    }

    return null;
}
}