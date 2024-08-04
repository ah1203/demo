package com.techeazy.demo.controllers;

import com.techeazy.demo.Resources.StudentResource;
import com.techeazy.demo.models.Student;
import com.techeazy.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@Validated @RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @GetMapping
    public ResponseEntity<List<StudentResource>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}
