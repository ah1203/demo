package com.techeazy.demo.services;

import com.techeazy.demo.Resources.StudentResource;
import com.techeazy.demo.models.Student;
import com.techeazy.demo.repositories.StudentRepository;
import com.techeazy.demo.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techeazy.demo.models.Subject;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<StudentResource> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        // Get all subjects and map their IDs to names
        Map<Long, String> subjectIdToNameMap = subjectRepository.findAll().stream()
                .collect(Collectors.toMap(Subject::getId, Subject::getName));

        return students.stream().map(student -> {
            StudentResource studentResource = new StudentResource();
            studentResource.setId(student.getId());
            studentResource.setName(student.getName());
            studentResource.setAddress(student.getAddress());

            // Map subject IDs to names
            Map<Long, String> subjects = student.getSubjects().stream()
                    .collect(Collectors.toMap(Subject::getId, subject -> subjectIdToNameMap.get(subject.getId())));

            studentResource.setSubjects(subjects);
            return studentResource;
        }).collect(Collectors.toList());
    }
}
