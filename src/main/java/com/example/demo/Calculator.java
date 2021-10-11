package com.example.demo;

public class Calculator {

    public int add(final int x, final int y) {
        return x + y;
    }

    public static void main(final String[] args) {
        final Calculator calculator = new Calculator();
        final int result = calculator.add(1, 2);
        System.out.println("result = " + result);
    }

    public int divide(final int x, final int y) {
        return x / y;
    }
}
