package com.example.demo.controller;

import com.example.demo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/my-student")
    public String getStudent(Model model) {
        Student student = new Student();
        student.setId(1);
        student.setName("Judy");

        model.addAttribute("myStudent", student);
        return "student";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
