package com.example.demo.service;

import com.example.demo.Student;
import com.example.demo.dao.StudentDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class StudentServiceImplMockTest {
    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentDao studentDao;

    @Test
    public void getById() {
        final Student mockStudent = new Student();
        mockStudent.setId(1);
        mockStudent.setName("I am mock");

        Mockito.when(studentDao.getById(1)).thenReturn(mockStudent);

        final Student student = studentService.getById(1);
        Assertions.assertNotNull(student);
        Assertions.assertEquals("I am mock", student.getName());
    }

}