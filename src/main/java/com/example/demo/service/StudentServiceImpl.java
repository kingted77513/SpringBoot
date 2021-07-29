package com.example.demo.service;

import com.example.demo.SimpleStudent;
import com.example.demo.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    public void insert(SimpleStudent student) {
        studentDao.insert(student);
    }

    @Override
    public void insertList(List<SimpleStudent> students) {
        studentDao.insertList(students);
    }

    @Override
    public void delete(Integer studentId) {
        studentDao.delete(studentId);
    }

    @Override
    public void update(SimpleStudent student) {
        studentDao.update(student);
    }

    @Override
    public List<SimpleStudent> select() {
        return studentDao.select();
    }

    @Override
    public SimpleStudent getById(Integer studentId) {
        return studentDao.getById(studentId);
    }
}
