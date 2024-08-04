package com.techeazy.demo.repositories;

import com.techeazy.demo.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
