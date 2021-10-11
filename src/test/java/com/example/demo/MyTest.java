package com.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyTest {

    @BeforeEach
    public void beforeEach() {
        System.out.println("before each");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("after each");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }
}
