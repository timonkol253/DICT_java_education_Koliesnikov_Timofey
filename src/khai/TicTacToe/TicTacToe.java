package khai.TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Початкове порожнє поле
        String cells = "_________";
        printGrid(cells);

        char currentPlayer = 'X'; // Перший гравець — X

        while (true) {
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split("\\s+");

            // Перевірка: чи введено рівно два елементи
            if (parts.length != 2) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int row, col;
            try {
                row = Integer.parseInt(parts[0]);
                col = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            // Перевірка діапазону
            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            // Перетворення координат у індекс
            int index = (row - 1) * 3 + (col - 1);

            // Перевірка, чи клітинка вільна
            if (cells.charAt(index) != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            // Робимо хід
            StringBuilder updated = new StringBuilder(cells);
            updated.setCharAt(index, currentPlayer);
            cells = updated.toString();

            // Виводимо оновлене поле
            printGrid(cells);

            // Перевіряємо результат
            String result = checkGameStatus(cells);
            if (!result.equals("Game not finished")) {
                System.out.println(result);
                break;
            }

            // Зміна гравця
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private static void printGrid(String cells) {
        System.out.println("---------");
        System.out.println("| " + cells.charAt(0) + " " + cells.charAt(1) + " " + cells.charAt(2) + " |");
        System.out.println("| " + cells.charAt(3) + " " + cells.charAt(4) + " " + cells.charAt(5) + " |");
        System.out.println("| " + cells.charAt(6) + " " + cells.charAt(7) + " " + cells.charAt(8) + " |");
        System.out.println("---------");
    }

    private static String checkGameStatus(String cells) {
        // Перевірка всіх можливих ліній
        char[][] board = new char[3][3];
        for (int i = 0; i < 9; i++) {
            board[i / 3][i % 3] = cells.charAt(i);
        }

        // Перевірка рядків
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '_' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0] + " wins";
            }
        }

        // Перевірка стовпців
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '_' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return board[0][j] + " wins";
            }
        }

        // Перевірка діагоналей
        if (board[0][0] != '_' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0] + " wins";
        }
        if (board[0][2] != '_' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2] + " wins";
        }

        // Перевірка на нічию
        if (!cells.contains("_")) {
            return "Draw";
        }

        return "Game not finished";
    }
}