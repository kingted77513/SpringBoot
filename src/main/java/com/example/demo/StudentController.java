package com.example.demo;

import com.example.demo.SimpleStudent;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    final private List<SimpleStudent> studentList = new LinkedList<>();

    @PostMapping()
    public String create(@RequestBody @Valid SimpleStudent student) {
        this.studentList.add(student);
        return "create student successful";
    }

    @GetMapping("/{id}")
    public SimpleStudent read(@PathVariable Integer id) {
        return studentList.stream()
                .filter(student -> id.equals(student.getId()))
                .findFirst()
                .orElse(null);
    }

    @GetMapping()
    public List<SimpleStudent> read() {
        return this.studentList;
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Integer id,
                         @RequestBody SimpleStudent student) {
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
