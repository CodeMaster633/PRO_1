package Gruppeopg;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Player> players = new ArrayList<>();

        Player p1 = new Player("Mads", 180, 80, 10);
        Player p2 = new Player("Peter", 188, 70, 5);
        Player p3 = new Player("Mikkel", 190, 90, 15);
        Player p4 = new Player("Morten", 170, 60, 20);
        Player p5 = new Player("Mogens", 175, 75, 25);
        Player p6 = new Player("Jonas", 190, 90, 15);

        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        players.add(p5);
        players.add(p6);

        ArrayList<Player> players2 = new ArrayList<>();

        players2.add(p2);
        players2.add(p1);
        players2.add(p3);
        players2.add(p6);
        players2.add(p4);
        players2.add(p5);

        System.out.println((findPlayerLinear(players, 15)));
        System.out.println((findPlayersBinary(players2, 15)));
    }

    public static Player findPlayerLinear(ArrayList<Player> players, int score) {
        Player foundPlayer = null;
        for (Player player : players) {
            if (player.getScoredGoals() == score) {
                foundPlayer = player;
            }
        }
        return foundPlayer;
    }

    public static Player findPlayersBinary(ArrayList<Player> players, int score) {
        Player foundPlayer = null;
        int left = 0;
        int right = players.size() - 1;
        while (foundPlayer == null && left <= right) {
            int middle = (left + right) / 2;
            Player p = players.get(middle);
            if (p.getScoredGoals() == score) {
                foundPlayer = p;
            } else {
                if (p.getScoredGoals() > score) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return foundPlayer;
    }
}
