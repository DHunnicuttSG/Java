package org.example.debugging;

public class SmallestNumber {
//    Find the smallest number
    public static void main(String[] args) {
        int[] nums = {45, 22, 89, 12, 67};
        int smallest = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > smallest) {
                smallest = nums[i];
            }
        }

        System.out.println("Smallest number is: " + smallest);
    }
}
