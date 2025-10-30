package khai.CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    // Початковий стан кавомашини
    private static int water = 400;
    private static int milk = 540;
    private static int beans = 120;
    private static int cups = 9;
    private static int money = 550;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine().trim();

            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    printState();
                    break;
                case "exit":
                    return; // завершення програми
                default:
                    System.out.println("Unknown action");
            }
        }
    }

    private static void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
        System.out.println(); // порожній рядок для читабельності
    }

    private static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:");
        String choice = scanner.nextLine().trim();

        if ("back".equals(choice)) {
            return; // повертаємось до головного меню
        }

        int neededWater = 0, neededMilk = 0, neededBeans = 0, price = 0;

        switch (choice) {
            case "1": // espresso
                neededWater = 250;
                neededMilk = 0;
                neededBeans = 16;
                price = 4;
                break;
            case "2": // latte
                neededWater = 350;
                neededMilk = 75;
                neededBeans = 20;
                price = 7;
                break;
            case "3": // cappuccino
                neededWater = 200;
                neededMilk = 100;
                neededBeans = 12;
                price = 6;
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        // Перевірка ресурсів
        if (water < neededWater) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (milk < neededMilk) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (beans < neededBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }
        if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return;
        }

        // Виконуємо покупку
        water -= neededWater;
        milk -= neededMilk;
        beans -= neededBeans;
        cups -= 1;
        money += price;

        System.out.println("I have enough resources, making you a coffee!");
    }

    private static void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        scanner.nextLine(); // спожити залишок рядка

        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        scanner.nextLine();

        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();
        scanner.nextLine();

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += scanner.nextInt();
        scanner.nextLine();
    }

    private static void take() {
        System.out.println("I gave you " + money);
        money = 0;
    }
}