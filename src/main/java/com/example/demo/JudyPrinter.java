package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class JudyPrinter implements Printer{

    @Value("${printer.name}")
    private String name;

    @Value("${printer.count}")
    private int count;

    @Override
    public void print(String message) {
        count--;
        System.out.println(name + ": " + message);
        System.out.println("times: " + count);
    }
}
