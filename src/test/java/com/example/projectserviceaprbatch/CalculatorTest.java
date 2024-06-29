package com.example.projectserviceaprbatch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void Test_add_twonumbers() {
        Calculator calc = new Calculator();
        int sum=calc.addition(1,2);
        assertEquals(3,sum);
    }
    @Test
    void Test_add_twonumbers_maxnumber() {
        Calculator calc = new Calculator();
        int sum=calc.addition(Integer.MAX_VALUE,Integer.MAX_VALUE);
        assertEquals(3,sum);
    }

    @Test
    void subtraction() {
    }

    @Test
    void multiplication() {
    }

    @Test
    void division() {
    }
}