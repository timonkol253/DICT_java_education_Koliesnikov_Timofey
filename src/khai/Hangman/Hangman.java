package khai.Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String[] words = {"python", "java", "javascript", "kotlin"};

        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];

        // Створюємо підказку: перші 2 літери + решта '-'
        StringBuilder hint = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            if (i < 2) {
                hint.append(secretWord.charAt(i));
            } else {
                hint.append('-');
            }
        }

        System.out.println("HANGMAN");
        System.out.print("Guess the word " + hint + ": > ");

        Scanner scanner = new Scanner(System.in);
        String guess = scanner.nextLine().trim(); // ← trim() видаляє пробіли на початку/в кінці

        if (guess.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        scanner.close();
    }
}