package khai.TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитуємо початковий стан поля (9 символів)
        System.out.print("Enter cells: ");
        String cells = scanner.nextLine();

        // Виводимо початкове поле (перший вивід)
        printGrid(cells);

        // Цикл для введення координат, поки не буде правильного ходу
        while (true) {
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine().trim();

            // Спроба розбити ввід на дві частини
            String[] parts = input.split("\\s+");

            // Перевірка: чи введено рівно два елементи
            if (parts.length != 2) {
                System.out.println("You should enter numbers!");
                continue;
            }

            // Перевірка, чи обидва елементи — цілі числа
            int row, col;
            try {
                row = Integer.parseInt(parts[0]);
                col = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            // Перевірка діапазону координат (1–3)
            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            // Перетворюємо координати (row, col) у індекс у рядку
            int index = (row - 1) * 3 + (col - 1);

            // Перевірка, чи клітинка вільна
            if (cells.charAt(index) != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            // Робимо хід: замінюємо '_' на 'X'
            StringBuilder updated = new StringBuilder(cells);
            updated.setCharAt(index, 'X');
            cells = updated.toString();

            // Виводимо оновлене поле (другий і останній вивід)
            printGrid(cells);
            break; // Успішний хід — виходимо з циклу
        }
    }

    // Допоміжний метод для виведення ігрового поля у форматі 3x3
    private static void printGrid(String cells) {
        System.out.println("---------");
        System.out.println("| " + cells.charAt(0) + " " + cells.charAt(1) + " " + cells.charAt(2) + " |");
        System.out.println("| " + cells.charAt(3) + " " + cells.charAt(4) + " " + cells.charAt(5) + " |");
        System.out.println("| " + cells.charAt(6) + " " + cells.charAt(7) + " " + cells.charAt(8) + " |");
        System.out.println("---------");
    }
}