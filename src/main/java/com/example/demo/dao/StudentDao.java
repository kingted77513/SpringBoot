package com.example.demo.dao;

import com.example.demo.Student;
import java.util.List;

public interface StudentDao {
    void insert(Student student);

    void insertList(List<Student> students);

    void delete(Integer studentId);

    void update(Student student);

    List<Student> select();

    Student getById(Integer studentId);
}
