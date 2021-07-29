package com.example.demo.controller;

import com.example.demo.SimpleStudent;
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
    public String insert(@RequestBody SimpleStudent simpleStudent) {
        studentService.insert(simpleStudent);
        return "run insert sql";
    }

    @PostMapping("/batch")
    public String insertList(@RequestBody List<SimpleStudent> simpleStudents) {
        studentService.insertList(simpleStudents);
        return "run batch insert sql";
    }

    @DeleteMapping("/{studentId}")
    public String delete(@PathVariable Integer studentId){
        studentService.delete(studentId);
        return "run delete sql";
    }

    @PutMapping()
    public String update(@RequestBody SimpleStudent simpleStudent){
        studentService.update(simpleStudent);
        return "run update sql";
    }

    @GetMapping()
    public List<SimpleStudent> select() {
        return studentService.select();
    }

    @GetMapping("{studentId}")
    public SimpleStudent select(@PathVariable Integer studentId) {
        return studentService.getById(studentId);
    }

}
