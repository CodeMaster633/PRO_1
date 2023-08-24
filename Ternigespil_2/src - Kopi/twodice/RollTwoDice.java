package twodice;

import java.util.Scanner;

public class RollTwoDice {

    private static int rollSum = 0;
    private static int rollCount = 0;
    private static int equalEyesCount = 0;
    private static int highestRoll = 0;
    private static int[] countEachNumber = new int[6];

    public static void main(String[] args) {
        System.out.println("Welcome to the game of RollTwoDice");
        printRules();
        System.out.println();

        playOneDie();

        System.out.println();
        System.out.println("Thank you for playing RollTwoDice");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of TwoDice:");
        System.out.println("The player throws two dice as long as he/she wants.");
        System.out.println("=====================================================");
    }

    private static void playOneDie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Roll? ('no' stops) ");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) {
            int[] face = rollTwoDice();
            System.out.println("Eyes: " + face[0] + " & " + face[1]);
            System.out.println();

            updateStatistics(face);

            System.out.print("Roll? ('no' stops) ");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }

    private static int[] rollTwoDice() {

        int[] result = {0,0};

        int roll1 = (int) (Math.random() * 6 + 1);
        int roll2 = (int) (Math.random() * 6 + 1);

        result[0] = roll1;
        result[1] = roll2;

        return result;
    }

    private static void updateStatistics(int[] face) {
        int faceSum = face[0]+face[1];

        rollCount++;
        rollSum = rollSum + faceSum;

        if(face[0]==face[1]){
            equalEyesCount++;
        }

        if(faceSum>highestRoll){
            highestRoll=faceSum;
        }

        int roll1 = face[0];
        int roll2 = face[1];

        countEachNumber[roll1-1]++;
        countEachNumber[roll2-1]++;

    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "The sum is:", rollSum);
        System.out.printf("%17s %4d\n", "Roll count:", rollCount);
        System.out.printf("%17s %4d\n", "Equal count:", equalEyesCount);
        System.out.printf("%17s %4d\n", "Highest roll:", highestRoll);
        System.out.println("-------");
        for (int i = 0; i < 6; i++) {
            System.out.println("Rolls of number " + (i+1) + " : " + countEachNumber[i]);

        }
    }
}
