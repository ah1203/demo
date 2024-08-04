package com.techeazy.demo.Resources;

import java.util.HashMap;
import java.util.Map;

public class StudentResource {
    private Long id;
    private String name;
    private String address;
    private Map<Long, String> subjects = new HashMap<>();

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<Long, String> getSubjects() {
        return subjects;
    }

    public void setSubjects(Map<Long, String> subjects) {
        this.subjects = subjects;
    }
}
