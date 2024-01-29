package org.cofeeMachine;

import java.util.Scanner;

public class CoffeeDrink {
    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int cups = 9;
    private static int money = 550;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input;
        while (true) {
            String action = "Write action (buy, fill, take, remaining, exit): ";
            System.out.println(action);
            input = scanner.next();
            switch (input) {
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
                    coffeeMachineHasPrint();
                    break;
                case "exit":
                    return;
                default:
                    break;
            }
        }
    }


    public static void coffeeMachineHasPrint() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add: ");
        int addWater = scanner.nextInt();
        water = water + addWater;
        System.out.println("Write how many ml of milk you want to add: ");
        int addMilk = scanner.nextInt();
        milk = milk + addMilk;
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int addBeans = scanner.nextInt();
        coffeeBeans = coffeeBeans + addBeans;
        System.out.println("Write how many disposable cups you want to add: ");
        int addCups = scanner.nextInt();
        cups = cups + addCups;
    }

    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, 4 - to main menu:");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Espresso espresso = new Espresso();
                if (water < espresso.water) {
                    System.out.println("Sorry, not enough water!\n");
                    return;
                } else if (coffeeBeans < espresso.coffeeBeans) {
                    System.out.println("Sorry, not enough coffee beans!\n");
                    return;
                } else {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    coffeeBeans = coffeeBeans - espresso.coffeeBeans;
                    money = money + espresso.cost;
                    water = water - espresso.water;
                    cups--;
                }
                break;
            case 2:
                Latte latte = new Latte();
                if (water < latte.water) {
                    System.out.println("Sorry, not enough water!\n");
                    return;
                } else if (coffeeBeans < latte.coffeeBeans) {
                    System.out.println("Sorry, not enough coffee beans!\n");
                    return;
                } else if (milk < latte.milk) {
                    System.out.println("Sorry, not enough milk !");
                } else {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    water = water - latte.water;
                    milk = milk - latte.milk;
                    coffeeBeans = coffeeBeans - latte.coffeeBeans;
                    money = money + latte.cost;
                    cups--;
                }
                break;
            case 3:
                Cappuccino cappuccino = new Cappuccino();
                if (water < cappuccino.water) {
                    System.out.println("Sorry, not enough water!\n");
                    return;
                } else if (coffeeBeans < cappuccino.coffeeBeans) {
                    System.out.println("Sorry, not enough coffee beans!\n");
                    return;
                } else if (milk < cappuccino.milk) {
                    System.out.println("Sorry, not enough milk !");
                } else {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    water = water - cappuccino.water;
                    milk = milk - cappuccino.milk;
                    coffeeBeans = coffeeBeans - cappuccino.coffeeBeans;
                    money = money + cappuccino.cost;
                    cups--;
                }
                break;
            case 4:
                return;
            default:
                break;
        }
    }
    public static void take() {
        System.out.println("I gave you $" + money + "\n");
        money = 0;
    }
}
