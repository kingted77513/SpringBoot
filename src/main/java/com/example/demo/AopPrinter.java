package com.example.demo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AopPrinter implements Printer{

    @Override
    public void print(String message) {
        System.out.println("AOP Print: " + message);
    }
}
