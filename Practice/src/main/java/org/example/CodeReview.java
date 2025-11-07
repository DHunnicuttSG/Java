package org.example;

import java.util.Random;
import java.util.Scanner;

public class CodeReview {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] rps = {"rock", "paper", "scissor"};
        String computerMove = rps[random.nextInt(rps.length)];
        String playerMove;

        while (true) {
            System.out.print("Enter rock, paper, or scissor (or quit to stop playing): ");
            playerMove = scanner.nextLine().toLowerCase();

            if (playerMove.equals("quit")) {
                System.out.println("Thanks for playing!");
                break;
            }

            if (!playerMove.equals("rock") && !playerMove.equals("paper") && !playerMove.equals("scissor")) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }

            System.out.println("Computer chose: " + computerMove);

            if (playerMove.equals(computerMove)) {
                System.out.println("It's a tie!");
            } else if ((playerMove.equals("rock") && computerMove.equals("scissor")) ||
                    (playerMove.equals("paper") && computerMove.equals("rock")) ||
                    (playerMove.equals("scissor") && computerMove.equals("paper"))) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose!");
            }

            // Generate a new move for the computer for the next round
            computerMove = rps[random.nextInt(rps.length)];
        }

        scanner.close();
    }


}

