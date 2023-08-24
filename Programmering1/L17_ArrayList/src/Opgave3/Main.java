package Opgave3;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Ib",23);
        Player player2 = new Player("Karsten",46);
        Player player3 = new Player("Benjamin",99);
        Player player4 = new Player("Mikkel",34);

        Team team1 = new Team("A-Team");

        System.out.println();
        System.out.println(team1);

        player1.setScore(13);
        player2.setScore(44);
        player3.setScore(11);
        player4.setScore(56);

        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);
        team1.addPlayer(player4);

        team1.printPlayers();
        System.out.println();

        System.out.println("Average age: " + team1.calcAverageAge());

        System.out.println("Total score: " + team1.calcTotalScore());

        System.out.println("Old player score: " + team1.calcOldPlayerScore(40));

        System.out.println("Max score: " + team1.maxScore());

        System.out.println("Best players: " + team1.bestPlayerNames());

    }
}
