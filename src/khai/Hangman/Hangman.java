package khai.Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];

        char[] guessedWord = new char[secretWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '-';
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("HANGMAN");

        for (int attempt = 0; attempt < 8; attempt++) {
            System.out.println(new String(guessedWord));
            System.out.print("Input a letter: > ");

            char letter = scanner.nextLine().charAt(0);

            boolean found = false;
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == letter) {
                    guessedWord[i] = letter;
                    found = true;
                }
            }

            if (!found) {
                System.out.println("That letter doesn't appear in the word");
            }
            System.out.println();
        }

        System.out.println("Thanks for playing!");
        System.out.println("We'll see how well you did in the next stage");

        scanner.close();
    }
}