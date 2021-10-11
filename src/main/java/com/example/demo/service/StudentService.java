package com.example.demo.service;

import com.example.demo.Student;

import java.util.List;

public interface StudentService {
    void insert(Student student);

    void insertList(List<Student> students);

    void delete(Integer studentId);

    void update(Student student);

    List<Student> select();

    Student getById(Integer studentId);
}
