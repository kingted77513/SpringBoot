package com.example.demo.controller;

import com.example.demo.objectmapper.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjectMapperController {

    @GetMapping("/convert")
    public String convert() throws JsonProcessingException {
        User user = new User();
        user.setId(1);
        user.setName("Judy");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(user);
        System.out.println("jsonResult = " + jsonResult);

        String json = "{\"id\":3,\"name\":\"Amy\"}";
        User userResult = objectMapper.readValue(json, User.class);
        System.out.println("user id: " + userResult.getId());
        System.out.println("user name: " + userResult.getName());

        return "convert success";
    }
}
