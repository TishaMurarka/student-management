package com.example.studentmanagement.controller;

import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public Student registerStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.registerStudent(studentDTO);
    }

    @PutMapping("/{id}")
    public Student updateStudentInfo(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        return studentService.updateStudentInfo(id, studentDTO);
    }

    @GetMapping("/{id}")
    public Student getStudentInfo(@PathVariable Long id) {
        return studentService.getStudentInfo(id);
    }
}
