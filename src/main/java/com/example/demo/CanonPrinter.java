package com.example.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class CanonPrinter implements Printer, InitializingBean {

    private int count;

    @Override
    public void afterPropertiesSet() throws Exception {
        count = 10;
    }

    @Override
    public void print(String message) {
        count--;
        System.out.println("Canon Print: " + message);
        System.out.println("times: " + count);
    }
}
