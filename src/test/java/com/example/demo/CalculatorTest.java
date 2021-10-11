package com.example.demo;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    public void add() {
        final Calculator calculator = new Calculator();
        final int result = calculator.add(1, 2);

        assertEquals(3, result, "加法有問題");
    }

    @Test
    public void divide() {
        final Calculator calculator = new Calculator();
        final int result = calculator.divide(10, 2);

        assertEquals(5, result);
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }

}