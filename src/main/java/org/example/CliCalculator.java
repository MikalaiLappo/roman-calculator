package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CliCalculator {
    RomanParser romanParser;
    Calculator calculator;
    final private static Pattern romanPattern = Pattern.compile("([MDCLXVI]+)\\s+([+\\-*/])\\s+([MDCLXVI]+)");
    final private static Pattern arabicPattern = Pattern.compile("([0-9]+)\\s+([+\\-*/])\\s+([0-9]+)");


    CliCalculator(Calculator calculator, RomanParser romanParser) {
        this.calculator = calculator;
        this.romanParser = romanParser;
    }

    final public void run() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();

        // A scrappy approach but I don't want to over-engineer it
        Matcher arabicMatcher = arabicPattern.matcher(line);
        Matcher romanMatcher = romanPattern.matcher(line);
        boolean isArabic = arabicMatcher.matches();
        boolean isRoman = romanMatcher.matches();

        if (!isArabic && !isRoman) {
            throw new IllegalArgumentException("Allowed input formats:\n    Arabic -- `123 + 321`\n    Roman  -- `X - V`");
        }

        if (isArabic) {
            String op = arabicMatcher.group(2);
            int a = Integer.parseInt(arabicMatcher.group(1));
            int b = Integer.parseInt(arabicMatcher.group(3));
            System.out.println(calculator.calculate(op, a, b));
            return;
        }

        System.out.println(calculateRoman(
                romanMatcher.group(2),
                romanMatcher.group(1),
                romanMatcher.group(3)
        ));
    }

    // Should be `private` or carried out into another class. Is `public` for Unit testing
    public String calculateRoman(String op, String romanA, String romanB) throws Exception {
        int a = romanParser.fromRoman(romanA);
        int b = romanParser.fromRoman(romanB);

        if (a > 10 || a < 1 || b > 10 || b < 1) { // Test task condition
            throw new Exception("Either of Roman operands are bigger than 10 or smaller than 1");
        }

        int calcResult = calculator.calculate(op, a, b);

        if (calcResult < 1 || calcResult > 3999) {
            throw new Exception("Roman literals are 1-3999 range limited, non-translatable result is: " + calcResult);
        }

        return romanParser.toRoman(calcResult);
    }
}
