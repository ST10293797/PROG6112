/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.guessinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GuessingGameTest {
    private GuessingGame game;

    @BeforeEach
    public void setUp() {
        game = new GuessingGame();
    }

    @Test
    public void testCorrectGuess() {
        game.setNumberToGuess(50);
        boolean result = game.checkGuess(50);
        assertTrue(result, "Correct guess should return true.");
        assertEquals(1, game.getAttempts(), "Number of attempts should be 1.");
    }

    @Test
    public void testLowerGuess() {
        game.setNumberToGuess(60);
        boolean result = game.checkGuess(50);
        assertFalse(result, "Lower guess should return false.");
        assertEquals(1, game.getAttempts(), "Number of attempts should be 1.");
    }

    @Test
    public void testHigherGuess() {
        game.setNumberToGuess(40);
        boolean result = game.checkGuess(50);
        assertFalse(result, "Higher guess should return false.");
        assertEquals(1, game.getAttempts(), "Number of attempts should be 1.");
    }

    @Test
    public void testInvalidGuess() {
        game.setNumberToGuess(50);
        boolean result = game.checkGuess(110);
        assertFalse(result, "Invalid guess should return false.");
        assertEquals(0, game.getAttempts(), "Number of attempts should remain 0.");
    }

    @Test
    public void testGameReset() {
        game.setNumberToGuess(75);
        game.checkGuess(50);
        game.resetGame();
        assertEquals(0, game.getAttempts(), "Number of attempts should be reset to 0.");
    }
}
