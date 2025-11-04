package org.example.debugging;

public class PositiveSum {
//    Find the sum of all the positive numbers
    public static void main(String[] args) {
        int[] values = {-3, 5, -1, 8, -2, 6};
        int sum = 0;

        for (int i = 0; i < values.length; i++) {
            if (values[i] < 0) {
                sum += values[i];
            }
        }

        System.out.println("Sum of positive numbers: " + sum);
    }
}
