package org.example.debugging;

public class EvenOddCounter {
    public static void main(String[] args) {
//        Count the number of even and odd numbers
        int[] numbers = {2, 5, 8, 11, 14, 17, 20};
        int evenCount = 0;
        int oddCount = 0;

        System.out.println("Counting even and odd numbers...");

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] % 2 == 1) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Even numbers: " + evenCount);
        System.out.println("Odd numbers: " + oddCount);
    }
}

