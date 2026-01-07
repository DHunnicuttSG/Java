package org.example.debugging;

public class FactorialCalc {
    // Calculate the factorial of a number
    public static void main(String[] args) {
        int n = 5;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        System.out.println("Factorial of " + n + " = " + result);
    }
}


