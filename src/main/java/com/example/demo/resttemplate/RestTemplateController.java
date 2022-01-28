package com.example.demo.resttemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {

    @GetMapping("/getForObject")
    public String getForObject(){

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://mocki.io/v1/3275feb1-25cc-4cc6-8d09-726866048e59";
        Student student = restTemplate.getForObject(url, Student.class);

        System.out.println("student id: "  + student.getId());
        System.out.println("student name: " + student.getName());
        System.out.println("student phone: " + student.getContactPhone());

        return "getForObject success";
    }
}
