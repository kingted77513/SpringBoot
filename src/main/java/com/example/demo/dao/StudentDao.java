package com.example.demo.dao;

import com.example.demo.SimpleStudent;
import java.util.List;

public interface StudentDao {
    void insert(SimpleStudent student);

    void insertList(List<SimpleStudent> students);

    void delete(Integer studentId);

    void update(SimpleStudent student);

    List<SimpleStudent> select();

    SimpleStudent getById(Integer studentId);
}
