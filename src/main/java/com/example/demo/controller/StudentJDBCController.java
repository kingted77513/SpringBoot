package com.example.demo.controller;

import com.example.demo.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-jdbc")
public class StudentJDBCController {

    @Autowired
    private StudentService studentService;

    @PostMapping()
    public String insert(@RequestBody Student student) {
        studentService.insert(student);
        return "run insert sql";
    }

    @PostMapping("/batch")
    public String insertList(@RequestBody List<Student> students) {
        studentService.insertList(students);
        return "run batch insert sql";
    }

    @DeleteMapping("/{studentId}")
    public String delete(@PathVariable Integer studentId){
        studentService.delete(studentId);
        return "run delete sql";
    }

    @PutMapping()
    public String update(@RequestBody Student student){
        studentService.update(student);
        return "run update sql";
    }

    @GetMapping()
    public List<Student> select() {
        return studentService.select();
    }

    @GetMapping("{studentId}")
    public Student select(@PathVariable Integer studentId) {
        return studentService.getById(studentId);
    }

}
