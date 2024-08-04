package com.techeazy.demo.services;

import com.techeazy.demo.Resources.SubjectResource;
import com.techeazy.demo.models.Subject;
import com.techeazy.demo.models.Student;
import com.techeazy.demo.repositories.SubjectRepository;
import com.techeazy.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public List<SubjectResource> getAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();

        // Get all students and map their IDs to names
        Map<Long, String> studentIdToNameMap = studentRepository.findAll().stream()
                .collect(Collectors.toMap(Student::getId, Student::getName));

        return subjects.stream().map(subject -> {
            SubjectResource subjectResource = new SubjectResource();
            subjectResource.setId(subject.getId());
            subjectResource.setName(subject.getName());

            // Map student IDs to names
            Map<Long, String> students = subject.getStudents().stream()
                    .collect(Collectors.toMap(Student::getId, student -> studentIdToNameMap.get(student.getId())));

            subjectResource.setStudents(students);
            return subjectResource;
        }).collect(Collectors.toList());
    }
}
