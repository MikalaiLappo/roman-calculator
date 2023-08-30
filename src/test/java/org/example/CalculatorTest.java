package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calculate() {
        Calculator calculator = new Calculator();

        int expected = 5;
        int actual = assertDoesNotThrow(() -> calculator.calculate("+", 1, 4));
        assertEquals(expected, actual);

        expected = 3;
        actual = assertDoesNotThrow(() -> calculator.calculate("-", 4, 1));
        assertEquals(expected, actual);

        expected = 25;
        actual = assertDoesNotThrow(() -> calculator.calculate("*", 5, 5));
        assertEquals(expected, actual);

        expected = 10;
        actual = assertDoesNotThrow(() -> calculator.calculate("/", 20, 2));
        assertEquals(expected, actual);

        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("INVALID OPERATION", 4, 2));
    }
}