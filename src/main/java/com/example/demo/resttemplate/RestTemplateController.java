package com.example.demo.resttemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {

    @GetMapping("/getForObject")
    public String getForObject(){

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://mocki.io/v1/53364310-acb9-474a-b660-73ecc22d75b6";
        Student student = restTemplate.getForObject(url, Student.class);

        System.out.println("student id: "  + student.getId());
        System.out.println("student name: " + student.getName());

        return "getForObject success";
    }

}
