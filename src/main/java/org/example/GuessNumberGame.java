package org.example;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int secret = random.nextInt(100) + 1;
        int guess;

        System.out.println(secret);
        while (true) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            if (guess == secret) {
                System.out.println("GJ.");
                break;
            }
            System.out.println(guess + " is too " + (guess < secret ? "low" : "high"));
        }
    }
}
