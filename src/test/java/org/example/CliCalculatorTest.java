package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CliCalculatorTest {

    @Test
    void calculateRoman() {
        CliCalculator cliCalculator = new CliCalculator(new Calculator(), new RomanParser());

        String expected = "C";
        String actual = assertDoesNotThrow(() -> cliCalculator.calculateRoman("*", "X", "X"));
        assertEquals(expected, actual);

        expected = "X";
        actual = assertDoesNotThrow(() -> cliCalculator.calculateRoman("+", "V", "V"));
        assertEquals(expected, actual);

        expected = "V";
        actual = assertDoesNotThrow(() -> cliCalculator.calculateRoman("/", "X", "II"));
        assertEquals(expected, actual);

        expected = "V";
        actual = assertDoesNotThrow(() -> cliCalculator.calculateRoman("-", "X", "V"));
        assertEquals(expected, actual);
    }
}