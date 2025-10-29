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
        int attemptsLeft = 8;
        Scanner scanner = new Scanner(System.in);

        System.out.println("HANGMAN");

        while (attemptsLeft > 0) {
            System.out.println(new String(currentState));
            System.out.print("Input a letter: > ");
            char letter = scanner.nextLine().charAt(0);

            // Перевіряємо, чи цю літеру вже пробували
            if (guessedLetters.contains(letter)) {
                System.out.println("No improvements");
                attemptsLeft--;
            } else {
                guessedLetters.add(letter);
                // Чи є літера у слові?
                if (secretWord.indexOf(letter) == -1) {
                    System.out.println("That letter doesn't appear in the word");
                    attemptsLeft--;
                } else {
                    // Відкриваємо всі входження літери
                    for (int i = 0; i < secretWord.length(); i++) {
                        if (secretWord.charAt(i) == letter) {
                            currentState[i] = letter;
                        }
                    }
                }
            }
            System.out.println(); // порожній рядок після кожного ходу

            // Перевірка: чи слово повністю відгадане?
            if (new String(currentState).equals(secretWord)) {
                System.out.println("You guessed the word!");
                System.out.println("You survived!");
                scanner.close();
                return;
            }
        }

        // Якщо вийшли з циклу — спроби закінчилися
        System.out.println("You lost!");
        scanner.close();
    }
}