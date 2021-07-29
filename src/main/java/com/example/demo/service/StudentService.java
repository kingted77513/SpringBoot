package com.example.demo.service;

import com.example.demo.SimpleStudent;

import java.util.List;

public interface StudentService {
    void insert(SimpleStudent student);

    void insertList(List<SimpleStudent> students);

    void delete(Integer studentId);

    void update(SimpleStudent student);

    List<SimpleStudent> select();

    SimpleStudent getById(Integer studentId);
}
