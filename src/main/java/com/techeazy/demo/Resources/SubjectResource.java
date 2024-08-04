package com.techeazy.demo.Resources;

import java.util.HashMap;
import java.util.Map;

public class SubjectResource {
    private Long id;
    private String name;
    private Map<Long, String> students = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Long, String> getStudents() {
        return students;
    }

    public void setStudents(Map<Long, String> students) {
        this.students = students;
    }
}
