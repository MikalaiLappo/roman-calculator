package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanParserTest {
    RomanParser romanParser;
    RomanParserTest() {
        this.romanParser = new RomanParser();
    }

    @Test
    void fromRoman() {
        int actual = assertDoesNotThrow(() -> romanParser.fromRoman("X"));
        int expected = 10;
        assertEquals(expected, actual);

        actual = assertDoesNotThrow(() -> romanParser.fromRoman("XXI"));
        expected = 21;
        assertEquals(expected, actual);

        actual = assertDoesNotThrow(() -> romanParser.fromRoman("I"));
        expected = 1;
        assertEquals(expected, actual);

        actual = assertDoesNotThrow(() -> romanParser.fromRoman("IV"));
        expected = 4;
        assertEquals(expected, actual);

        actual = assertDoesNotThrow(() -> romanParser.fromRoman("MMVIII"));
        expected = 2008;
        assertEquals(expected, actual);

        actual = assertDoesNotThrow(() -> romanParser.fromRoman("MDCLXVI"));
        expected = 1666;
        assertEquals(expected, actual);

        assertThrows(IllegalArgumentException.class, () -> romanParser.fromRoman("INVALID INPUT"));
    }

    @Test
    void toRoman() {
        String actual = assertDoesNotThrow(() -> romanParser.toRoman(1));
        String expected = "I";
        assertEquals(expected, actual);

        actual = assertDoesNotThrow(() -> romanParser.toRoman(2));
        expected = "II";
        assertEquals(expected, actual);

        actual = assertDoesNotThrow(() -> romanParser.toRoman(3));
        expected = "III";
        assertEquals(expected, actual);

        actual = assertDoesNotThrow(() -> romanParser.toRoman(4));
        expected = "IV";
        assertEquals(expected, actual);

        actual = assertDoesNotThrow(() -> romanParser.toRoman(5));
        expected = "V";
        assertEquals(expected, actual);

        actual = assertDoesNotThrow(() -> romanParser.toRoman(9));
        expected = "IX";
        assertEquals(expected, actual);

        actual = assertDoesNotThrow(() -> romanParser.toRoman(10));
        expected = "X";
        assertEquals(expected, actual);

        actual = assertDoesNotThrow(() -> romanParser.toRoman(11));
        expected = "XI";
        assertEquals(expected, actual);

        actual = assertDoesNotThrow(() -> romanParser.toRoman(15));
        expected = "XV";
        assertEquals(expected, actual);

        actual = assertDoesNotThrow(() -> romanParser.toRoman(19));
        expected = "XIX";
        assertEquals(expected, actual);

        actual = assertDoesNotThrow(() -> romanParser.toRoman(22));
        expected = "XXII";
        assertEquals(expected, actual);

        assertThrows(IllegalArgumentException.class, () -> romanParser.toRoman(-1));
        assertThrows(IllegalArgumentException.class, () -> romanParser.toRoman(0));

    }
}