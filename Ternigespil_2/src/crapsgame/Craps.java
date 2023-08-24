package crapsgame;

import java.util.Scanner;

public class Craps {

    public static void main(String[] args) {
        System.out.println("Welcome to the game of Craps");

        printRules();
        System.out.println();

        playCraps();

        System.out.println();
        System.out.println("Thank you for playing RollTwoDice");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Craps:");
        System.out.println("The player throws two dice. If 7 or 11 you win. 2, 3, or 12 you lose.");
        System.out.println("Elseyou have to roll again. You keep rolling until you roll the same number, and win, or number 7 and lose.");
        System.out.println("=====================================================");
    }

    private static void playCraps() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Roll? ");
        String answer = scanner.nextLine();

        int rollPoint = rollTwoDice();

        System.out.println("Your 'come out roll' is: " + rollPoint);

        if (rollPoint == (7) || rollPoint == (11)) {
            System.out.println("You have won the game!");
        } else if (rollPoint == (2) || rollPoint == (3) || rollPoint == (12)) {
            System.out.println("You have lost the game..");
        } else {
            System.out.println("You shall continiue to roll!");
            rollforPoint(rollPoint);
        }

        scanner.close();
    }

    
    private static int rollTwoDice() {

        int roll1 = (int) (Math.random() * 6 + 1);
        int roll2 = (int) (Math.random() * 6 + 1);

        int sum = roll1 + roll2;

        return sum;
    }

    public static boolean rollforPoint(int point) {
        boolean result = false;
        boolean active = true;

        while (active) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Roll? ");
            String answer = scanner.nextLine();

            int rollPoint = rollTwoDice();
            System.out.println("Your roll is: " + rollPoint);

            if (rollPoint == 7) {
                System.out.println("You have LOST");
                active = false;
            } else if (rollPoint == point) {
                System.out.println("You have WON!");
                active = false;
                result = true;
            }
        }

        return result;
    }
}
