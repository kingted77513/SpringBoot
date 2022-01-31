package com.example.demo.controller;

import com.example.demo.Student;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    final private List<Student> studentList = new LinkedList<>();

    @PostMapping()
    public String create( @Valid Student student) {
        this.studentList.add(student);
        return "create student successful";
    }

    @GetMapping("/{id}")
    public Student read(@PathVariable Integer id) {
        return studentList.stream()
                .filter(student -> id.equals(student.getId()))
                .findFirst()
                .orElse(null);
    }

    @GetMapping()
    public List<Student> read() {
        return this.studentList;
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Integer id,
                         @RequestBody Student student) {
        for (int index = 0 ; index < studentList.size() ; index++) {
            if (studentList.get(index).getId().equals(id)){
                studentList.set(index, student);
                break;
            }
        }
        return "update student of id = " + id;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        for (int index = 0 ; index < studentList.size() ; index++) {
            if (studentList.get(index).getId().equals(id)){
                studentList.remove(index);
                break;
            }
        }
        return "delete student of id = " + id;
    }
}
