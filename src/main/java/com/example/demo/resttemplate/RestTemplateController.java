package com.example.demo.resttemplate;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/getForObjectWithParam")
    public String getForObjectWithParam(){

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> queryParamMap = new HashMap<>();
        queryParamMap.put("graduate", true);

        String url = "https://mocki.io/v1/3275feb1-25cc-4cc6-8d09-726866048e59";
        Student student = restTemplate.getForObject(url, Student.class, queryParamMap);

        return "getForObject success with param";
    }

    @GetMapping("/getForEntity")
    public String getForEntity(){

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://mocki.io/v1/3275feb1-25cc-4cc6-8d09-726866048e59";
        ResponseEntity<Student> studentEntity = restTemplate.getForEntity(url, Student.class);

        System.out.println("student entity status code: " + studentEntity.getStatusCode());

        Student student = studentEntity.getBody();
        System.out.println("student id: "  + student.getId());
        System.out.println("student name: " + student.getName());
        System.out.println("student phone: " + student.getContactPhone());

        return "getForObject success";
    }

    @GetMapping("/postForObject")
    public String postForObject(){

        Student requestBody = new Student();
        requestBody.setName("John");

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://mocki.io/v1/3275feb1-25cc-4cc6-8d09-726866048e59";
        Student student = restTemplate.postForObject(url, requestBody, Student.class);

        System.out.println("student id: "  + student.getId());
        System.out.println("student name: " + student.getName());
        System.out.println("student phone: " + student.getContactPhone());

        return "getForObject success";
    }
}
