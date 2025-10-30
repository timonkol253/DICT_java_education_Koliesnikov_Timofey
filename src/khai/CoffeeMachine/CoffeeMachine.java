package khai.CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запитуємо наявні інгредієнти
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = scanner.nextInt();

        // Запитуємо бажану кількість чашок
        System.out.println("Write how many cups of coffee you will need:");
        int neededCups = scanner.nextInt();

        // Скільки чашок можна приготувати з кожного інгредієнта?
        int maxCupsByWater = water / 200;
        int maxCupsByMilk = milk / 50;
        int maxCupsByBeans = beans / 15;

        // Максимальна кількість чашок — обмежена найменшим значенням
        int maxPossibleCups = Math.min(Math.min(maxCupsByWater, maxCupsByMilk), maxCupsByBeans);

        // Порівнюємо з бажаною кількістю
        if (maxPossibleCups == neededCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (maxPossibleCups > neededCups) {
            int extra = maxPossibleCups - neededCups;
            System.out.println("Yes, I can make that amount of coffee (and even " + extra + " more than that)");
        } else {
            System.out.println("No, I can make only " + maxPossibleCups + " cups of coffee");
        }
    }
}