package khai.Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        // Список слів
        String[] words = {"python", "java", "javascript", "kotlin"};

        // Випадковий вибір слова
        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];

        // Привітання та запит
        System.out.println("HANGMAN");
        System.out.print("Guess the word: > ");

        // Зчитування введення
        Scanner scanner = new Scanner(System.in);
        String guess = scanner.nextLine();

        // Перевірка
        if (guess.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        scanner.close();
    }
}