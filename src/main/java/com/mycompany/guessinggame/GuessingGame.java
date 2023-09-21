/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.guessinggame;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    private int numberToGuess;
    private int attempts;

    public GuessingGame() {
        // Constructor, initialize fields if needed
    }

    void setNumberToGuess(int number) {
        this.numberToGuess = number;
    }

    boolean checkGuess(int guess) {
        attempts++;
        return guess == numberToGuess;
    }

    int getAttempts() {
        return attempts;
    }

    void resetGame() {
        attempts = 0;
        // Generate a new random number when the game is reset
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lowerBound = 1;
        int upperBound = 100;
        int attempts = 0;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound + ". Can you guess it?");

        // Initialize a game instance
        GuessingGame game = new GuessingGame();
        game.resetGame();

        boolean hasGuessedCorrectly = false;

        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < lowerBound || userGuess > upperBound) {
                System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + ".");
            } else if (game.checkGuess(userGuess)) {
                System.out.println("Congratulations! You guessed the number " + userGuess + " in " + attempts + " attempts.");
                hasGuessedCorrectly = true;
            } else if (userGuess < game.numberToGuess) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }
        }

        scanner.close();
    }
}
