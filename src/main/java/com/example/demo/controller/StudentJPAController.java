package com.example.demo.controller;

import com.example.demo.Student;
import com.example.demo.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/student-jpa"))
public class StudentJPAController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping()
    public String insert(@RequestBody Student student) {
        studentRepository.save(student);
        return "run insert sql";
    }

    @PutMapping()
    public String update(@RequestBody Student student){

        if (select(student.getId()).isPresent()){
            studentRepository.save(student);
            return "run update sql";
        }else {
            return "failed sql for unknown id";
        }


    }

    @DeleteMapping("/{studentId}")
    public String delete(@PathVariable Integer studentId){
        studentRepository.deleteById(studentId);
        return "run delete sql";
    }

    @GetMapping("/{studentId}")
    public Optional<Student> select(@PathVariable Integer studentId) {
        return studentRepository.findById(studentId);
    }

}
