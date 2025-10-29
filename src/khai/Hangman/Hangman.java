package khai.Hangman;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Hangman {
    public static void main(String[] args) {
        String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];

        char[] currentState = new char[secretWord.length()];
        for (int i = 0; i < currentState.length; i++) {
            currentState[i] = '-';
        }

        Set<Character> guessedLetters = new HashSet<>();
        int lives = 8;
        Scanner scanner = new Scanner(System.in);

        System.out.println("HANGMAN");

        while (lives > 0) {
            System.out.println(new String(currentState));
            System.out.print("Input a letter: > ");
            String input = scanner.nextLine();

            // Перевірка: чи введено рівно один символ
            if (input.length() != 1) {
                System.out.println("You should input a single letter");
                System.out.println();
                continue;
            }

            char letter = input.charAt(0);

            // Перевірка: чи це мала англійська літера
            if (letter < 'a' || letter > 'z') {
                System.out.println("Please enter a lowercase English letter");
                System.out.println();
                continue;
            }

            // Перевірка: чи літеру вже вводили
            if (guessedLetters.contains(letter)) {
                System.out.println("You've already guessed this letter");
                System.out.println();
                continue;
            }

            // Якщо все добре — додаємо до використаних
            guessedLetters.add(letter);

            // Чи є літера у слові?
            if (secretWord.indexOf(letter) == -1) {
                // Немає — помилка
                System.out.println("That letter doesn't appear in the word");
                lives--;
            } else {
                // Є — відкриваємо всі входження
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == letter) {
                        currentState[i] = letter;
                    }
                }
            }

            System.out.println(); // порожній рядок після ходу

            // Перевірка на перемогу
            if (new String(currentState).equals(secretWord)) {
                System.out.println("You guessed the word " + secretWord + "!");
                System.out.println("You survived!");
                scanner.close();
                return;
            }
        }

        // Програш
        System.out.println("You lost!");
        scanner.close();
    }
}