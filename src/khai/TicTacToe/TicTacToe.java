package khai.TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        // Зчитуємо рядок із 9 символів, що описує стан гри
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String cells = scanner.nextLine();

        // Виводимо ігрове поле у форматі 3x3 (як на Етапі 2)
        System.out.println("---------");
        System.out.println("| " + cells.charAt(0) + " " + cells.charAt(1) + " " + cells.charAt(2) + " |");
        System.out.println("| " + cells.charAt(3) + " " + cells.charAt(4) + " " + cells.charAt(5) + " |");
        System.out.println("| " + cells.charAt(6) + " " + cells.charAt(7) + " " + cells.charAt(8) + " |");
        System.out.println("---------");

        // Підраховуємо кількість 'X' та 'O'
        int countX = 0;
        int countO = 0;
        for (char c : cells.toCharArray()) {
            if (c == 'X') countX++;
            else if (c == 'O') countO++;
        }

        // Перевіряємо, чи різниця в кількості символів більша за 1 → неможливий стан
        if (Math.abs(countX - countO) > 1) {
            System.out.println("Impossible");
            return;
        }

        // Створюємо двовимірний масив для зручної перевірки перемоги
        char[][] board = {
                {cells.charAt(0), cells.charAt(1), cells.charAt(2)},
                {cells.charAt(3), cells.charAt(4), cells.charAt(5)},
                {cells.charAt(6), cells.charAt(7), cells.charAt(8)}
        };

        // Перевіряємо, чи виграв 'X' або 'O'
        boolean xWins = checkWin(board, 'X');
        boolean oWins = checkWin(board, 'O');

        // Якщо обидва гравці мають три поспіль — стан неможливий
        if (xWins && oWins) {
            System.out.println("Impossible");
            return;
        }

        // Визначаємо кінцевий стан гри
        if (xWins) {
            System.out.println("X wins");
        } else if (oWins) {
            System.out.println("O wins");
        } else if (cells.contains("_")) {
            System.out.println("Game not finished");
        } else {
            System.out.println("Draw");
        }
    }

    // Допоміжний метод: перевіряє, чи виграв певний гравець
    private static boolean checkWin(char[][] board, char player) {
        // Перевірка рядків
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
        }
        // Перевірка стовпців
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player)
                return true;
        }
        // Перевірка діагоналей
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }
}