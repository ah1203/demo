package com.techeazy.demo.repositories;

import com.techeazy.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
