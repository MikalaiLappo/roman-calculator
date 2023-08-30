package org.example;


public class Main {
    public static void main(String[] args) throws Exception {
        CliCalculator cliCalculator = new CliCalculator(new Calculator(), new RomanParser());
        cliCalculator.run();
    }
}