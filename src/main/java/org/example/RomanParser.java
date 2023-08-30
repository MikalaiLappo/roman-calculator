package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


public class RomanParser {
    final private static Pattern validRomanPattern = Pattern.compile("^[MDCLXVI]+$");
    final private static HashMap<Character, Integer> romanToArabMap = new HashMap<>() {{
        put('M', 1000);
        put('D', 500);
        put('C', 100);
        put('L', 50);
        put('X', 10);
        put('V', 5);
        put('I', 1);
    }};
    final private static Map.Entry[] arabToRomanMap = new Map.Entry[]{
            Map.entry(1000, "M"),
            Map.entry(900, "CM"),
            Map.entry(500, "D"),
            Map.entry(400, "CD"),
            Map.entry(100, "C"),
            Map.entry(90, "XC"),
            Map.entry(50, "L"),
            Map.entry(40, "XL"),
            Map.entry(10, "X"),
            Map.entry(9, "IX"),
            Map.entry(5, "V"),
            Map.entry(4, "IV"),
            Map.entry(1, "I")
    };

    public int fromRoman(String input) throws IllegalArgumentException {
        boolean isValidInput = RomanParser.validRomanPattern.matcher(input).find();
        if (!isValidInput) {
            throw new IllegalArgumentException("Invalid Roman number: " + input);
        }

        char[] chars = new StringBuilder(input).reverse().toString().toCharArray();

        int result = 0;
        int lastVal = Integer.MIN_VALUE;
        for (char ch : chars) {
            int arabVal = RomanParser.romanToArabMap.get(ch);
            if (lastVal > arabVal) {
                result -= arabVal;
                continue;
            }
            result += arabVal;
            lastVal = arabVal;
        }

        return result;
    }

    public String toRoman(int num) throws IllegalArgumentException {
        if (num < 1 || num > 3999) {
            throw new IllegalArgumentException("Roman number has to be >= 1 and <= 3999. " + num + " was given");
        }

        StringBuilder result = new StringBuilder();

        for (Map.Entry<Integer, String> pair : RomanParser.arabToRomanMap) {
            int diver = pair.getKey();
            String roman = pair.getValue();

            int len = num / diver;
            num -= len * diver;

            result.append(roman.repeat(len));
        }

        return result.toString();
    }
}
