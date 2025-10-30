package khai.CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    // Ресурси кавомашини
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int money = 550;

    // Стани
    private static final String STATE_MAIN = "main";
    private static final String STATE_CHOOSING_COFFEE = "choosing_coffee";
    private static final String STATE_FILLING_WATER = "filling_water";
    private static final String STATE_FILLING_MILK = "filling_milk";
    private static final String STATE_FILLING_BEANS = "filling_beans";
    private static final String STATE_FILLING_CUPS = "filling_cups";

    private String state = STATE_MAIN;

    // Головний метод
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        // Початковий запит
        System.out.println("Write action (buy, fill, take, remaining, exit):");

        while (true) {
            String input = scanner.nextLine();
            machine.processInput(input);
        }
    }

    // Основний метод обробки введення
    public void processInput(String input) {
        switch (state) {
            case STATE_MAIN:
                handleMainAction(input.trim());
                break;
            case STATE_CHOOSING_COFFEE:
                handleCoffeeChoice(input.trim());
                break;
            case STATE_FILLING_WATER:
                water += Integer.parseInt(input.trim());
                System.out.println("Write how many ml of milk do you want to add:");
                state = STATE_FILLING_MILK;
                break;
            case STATE_FILLING_MILK:
                milk += Integer.parseInt(input.trim());
                System.out.println("Write how many grams of coffee beans do you want to add:");
                state = STATE_FILLING_BEANS;
                break;
            case STATE_FILLING_BEANS:
                beans += Integer.parseInt(input.trim());
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                state = STATE_FILLING_CUPS;
                break;
            case STATE_FILLING_CUPS:
                cups += Integer.parseInt(input.trim());
                System.out.println(); // порожній рядок
                state = STATE_MAIN;
                printPrompt();
                break;
        }
    }

    private void handleMainAction(String action) {
        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:");
                state = STATE_CHOOSING_COFFEE;
                break;
            case "fill":
                System.out.println("Write how many ml of water do you want to add:");
                state = STATE_FILLING_WATER;
                break;
            case "take":
                System.out.println("I gave you " + money);
                money = 0;
                System.out.println();
                printPrompt();
                break;
            case "remaining":
                printState();
                printPrompt();
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Unknown action");
                printPrompt();
        }
    }

    private void handleCoffeeChoice(String choice) {
        if ("back".equals(choice)) {
            state = STATE_MAIN;
            printPrompt();
            return;
        }

        int neededWater = 0, neededMilk = 0, neededBeans = 0, price = 0;
        boolean validChoice = true;

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
                validChoice = false;
        }

        if (!validChoice) {
            state = STATE_MAIN;
            printPrompt();
            return;
        }

        // Перевірка ресурсів
        if (water < neededWater) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < neededMilk) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < neededBeans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            water -= neededWater;
            milk -= neededMilk;
            beans -= neededBeans;
            cups -= 1;
            money += price;
            System.out.println("I have enough resources, making you a coffee!");
        }

        state = STATE_MAIN;
        System.out.println();
        printPrompt();
    }

    private void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
        System.out.println();
    }

    private void printPrompt() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }
}