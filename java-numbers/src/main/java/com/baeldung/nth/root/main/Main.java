package com.baeldung.nth.root.main;

import com.baeldung.nth.root.calculator.NthRootCalculator;

public class Main {
    public static void main(String[] args) {
        NthRootCalculator calculator = new NthRootCalculator();
        double base = Double.parseDouble(args[0]);
        double n = Double.parseDouble(args[1]);
        double result = calculator.calculateWithRound(base, n);
        System.out.println("The " + n + " root of " + base + " equals to " + result + ".");
    }
}
