package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Java!");
        greetUser();
        calculateAverage(12, 2, false);
    }

    public static void greetUser() {
        System.out.println("Hello, student!");
    }

    public static double calculateAverage(int total, int count, boolean roundResult) {
        double average = (double) total / count;
        if (roundResult) {
            average = Math.round(average);
        }
        return average;
    }
}