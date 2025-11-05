package org.example.debugging;

public class AverageScores {
    public static void main(String[] args) {
        // Print out the average score and highest score
        //        Find the errors in this file:

        int[] scores = {80, 90, 70, 100, 60};
        int total = 0;
        int count = scores.length;

        System.out.println("Calculating average score...");
        for (int i = 0; i < count; i++) {
            total += scores[i];
        }

        double average = (double)total / (double)count;
        System.out.println("Average score: " + average);


        int highest = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > highest) {
                highest = scores[i];
            }
        }

        System.out.println("Highest score: " + highest);
    }
}
