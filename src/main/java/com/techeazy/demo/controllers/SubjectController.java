package com.techeazy.demo.controllers;

import com.techeazy.demo.Resources.SubjectResource;
import com.techeazy.demo.models.Subject;
import com.techeazy.demo.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        return ResponseEntity.ok(subjectService.createSubject(subject));
    }

    @GetMapping
    public ResponseEntity<List<SubjectResource>> getAllSubjects() {
        return ResponseEntity.ok(subjectService.getAllSubjects());
    }
    }
