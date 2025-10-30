package khai.CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        int water = 200 * cups;      // мл
        int milk = 50 * cups;        // мл
        int coffeeBeans = 15 * cups; // г

        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
    }
}