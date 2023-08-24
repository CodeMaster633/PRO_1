package pigsgame;

import java.util.Scanner;

public class Pigs {

    private static Scanner scanner = new Scanner(System.in);
    private static int player1Points = 0;
    private static int player2Points = 0;
    private static int endPoint = 100;
    private static int aveThrowCountP1 = 0;
    private static int aveThrowCountP2 = 0;
    private static int totalThrowCountP1 = 0;
    private static int totalThrowCountP2 = 0;
    private static int roundCountP1 = 0;
    private static int roundCountP2 = 0;
    private static int throwAmount = 0;
    private static boolean whosTurn = true;


    public static void main(String[] args) {
        System.out.println("Welcome to the game of Pigs");
        printRules();
        System.out.println();

        setEndPoint();

        playPigs();

        getStatistics();

        System.out.println();
        System.out.println("Thank you for playing Pigs");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Pigs:");
        System.out.println("Two players compete to reach 100 point.");
        System.out.println("Use 'y' to roll the dice and 'n' to stop your turn.");
        System.out.println("A player rolls a dice, if the roll is 1, it's the next players turn.");
        System.out.println("If the player is rolling other than 1, he/she rolls again or ends its turn and save the points");
        System.out.println("=====================================================");
    }

    private static void playPigs() {

        boolean winnerFound = false;
        boolean active = true;

        while (!winnerFound) {
            if (whosTurn) {
                System.out.println("Player 1 turn");
                playRound(whosTurn, player1Points);
                whosTurn = false;
                active = false;

//                winnerFound = true;
            } else if (!whosTurn) {
                System.out.println("Player 2 turn");
                playRound(whosTurn, player2Points);
                whosTurn = true;
                active = false;
            }
            if (player1Points >= endPoint) {
                System.out.println("Player 1 has WON!");
                winnerFound = true;
            } else if (player2Points >= endPoint) {
                System.out.println("Player 2 has WON!");
                winnerFound = true;
            }
        }
        scanner.close();
    }

    public static int playRound(boolean player, int points) {
        int result = 0;
        boolean active = true;
        int tempSum = 0;

        while (active) {

            System.out.println("Roll the dice?");
            String answer = scanner.nextLine();

            int[] roll = new int[2];
            roll[0] = rollDie();
            roll[1] = rollDie();

//            System.out.println("Eyes: " + roll[0] + " " + roll[1]);

            if (answer.equals("y")) {
                System.out.println("Eyes: " + roll[0] + " " + roll[1]);

                throwAmount++;

                if (roll[0] == 1||roll[1]==1) {
                    active = false;
                    System.out.println("You lost your temporary point");

                    updateThowCount(whosTurn,throwAmount);

                } else if (roll[0] == 1&&roll[1]==1){
                    active = false;
                    System.out.println("You lost your ALL your points");
                    removePoints(whosTurn);

                }else {
                    tempSum = tempSum + roll[0] + roll[1];
                    System.out.println("TempSum is: " + tempSum);
                }
            } else if (answer.equals("n")) {
                addPoints(whosTurn, tempSum);
                updateThowCount(whosTurn,throwAmount);
                throwAmount = 0;
                tempSum = 0;
                active = false;
            }
        }
        return result;
    }

    private static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }

    private static void addPoints(boolean player, int points) {
        if (player) {
            player1Points += points;
        } else if (!player) {
            player2Points += points;
        }
        System.out.println("Player1 points: " + player1Points);
        System.out.println("Player2 points: " + player2Points);

    }

    private static void removePoints(boolean player) {
        if (player) {
            player1Points = 0;
        } else if (!player) {
            player2Points = 0;
        }
        System.out.println("Player1 points: " + player1Points);
        System.out.println("Player2 points: " + player2Points);

    }

    public static void setEndPoint() {

        System.out.println("What shall the ending point be?");
        String setPoint = scanner.nextLine();
        int setRealPoint = Integer.valueOf(setPoint);

        endPoint = setRealPoint;
    }

    public static void getStatistics() {

        aveThrowCountP1 = totalThrowCountP1/roundCountP1;
        aveThrowCountP2 = totalThrowCountP2/roundCountP2;

        System.out.println("Player 1's average thrown count per round is: " + aveThrowCountP1);
        System.out.println("Player 2's average thrown count per round is: " + aveThrowCountP2);

    }

    public static void updateThowCount(boolean whosTurn,int throwAmount) {
        if(whosTurn){
            totalThrowCountP1+=throwAmount;
            roundCountP1++;
        }else if(!whosTurn){
            totalThrowCountP2+=throwAmount;
            roundCountP2++;

        }
    }

}


//package pigsgame;
//
//        import java.util.Scanner;
//
//public class Pigs {
//
//    private static Scanner scanner = new Scanner(System.in);
//    private static int player1Points = 0;
//    private static int player2Points = 0;
//    private static boolean whosTurn = true;
//
//
//    public static void main(String[] args) {
//        System.out.println("Welcome to the game of Pigs");
//        printRules();
//        System.out.println();
//
//        playPigs();
//
//        System.out.println();
//        System.out.println("Thank you for playing Pigs");
//    }
//
//    private static void printRules() {
//        System.out.println("=====================================================");
//        System.out.println("Rules of Pigs:");
//        System.out.println("Two players compete to reach 100 point.");
//        System.out.println("Use 'y' to roll the dice and 'n' to stop your turn.");
//        System.out.println("A player rolls a dice, if the roll is 1, it's the next players turn.");
//        System.out.println("If the player is rolling other than 1, he/she rolls again or ends its turn and save the points");
//        System.out.println("=====================================================");
//    }
//
//    private static void playPigs() {
//
//        boolean winnerFound = false;
//        boolean active = true;
//
//        while (!winnerFound) {
//            if (whosTurn) {
//                System.out.println("Player 1 turn");
//                playRound(whosTurn, player1Points);
//                whosTurn = false;
//                active = false;
//
////                winnerFound = true;
//            } else if (!whosTurn) {
//                System.out.println("Player 2 turn");
//                playRound(whosTurn, player2Points);
//                whosTurn = true;
//                active = false;
//            }
//            if(player1Points>=100){
//                System.out.println("Player 1 has WON!");
//                winnerFound=true;
//            } else if(player2Points>=100){
//                System.out.println("Player 2 has WON!");
//                winnerFound=true;
//            }
//        }
//        scanner.close();
//    }
//
//    public static int playRound(boolean player, int points) {
//        int result = 0;
//        boolean active = true;
//        int tempSum = 0;
//
//        while (active) {
//
//            System.out.println("Roll the dice?");
//            String answer = scanner.nextLine();
//
//            int roll = rollDie();
//            System.out.println("Eyes: " + roll);
//
//            if (answer.equals("y")) {
//
//                if (roll == 1) {
//                    active = false;
//                    System.out.println("You lost your temporary point");
//                } else {
//                    tempSum = tempSum + roll;
//                    System.out.println("TempSum is: " + tempSum);
//                }
//            } else if (answer.equals("n")) {
//                addPoints(whosTurn, tempSum);
//                tempSum=0;
//                active = false;
//            }
//        }
//        return result;
//    }
//
//    private static int rollDie() {
//        return (int) (Math.random() * 6 + 1);
//    }
//
//    private static void addPoints(boolean player, int points) {
//        if (player) {
//            player1Points += points;
//        } else if (!player) {
//            player2Points += points;
//        }
//        System.out.println("Player1 points: " + player1Points);
//        System.out.println("Player2 points: " + player2Points);
//
//    }
//}
