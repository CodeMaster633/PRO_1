package Opgave3;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> players;

    public Team (String name) {
        this.name=name;
        players = new ArrayList<Player>();
    }

    @Override
    public String toString() {
        return "Team (" + name + ")";
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer (Player p){
        players.add(p);
    }

    public void printPlayers (){

        for (Player player : players) {
            System.out.println(player);
        }
    }

    public double calcAverageAge(){
        double ave = 0;
        for (Player player : players) {
            ave+=player.getScore();
        }
        ave=ave/players.size();
        return ave;
    }


    public int calcTotalScore(){
        int sum = 0;
        for (Player player : players) {
            sum+=player.getAge();
        }
        return sum;
    }

    public int calcOldPlayerScore(int ageLimit){
        int sum = 0;
        for (Player player : players) {
            if(player.getAge()>ageLimit){
                sum+=player.getAge();
            }
        }
        return sum;
    }

    public int maxScore(){
        int max = 0;
        for (Player player : players) {
            if(player.getScore()>max){
                max=player.getScore();
            }
        }
        return max;
    }

    public ArrayList<String> bestPlayerNames(){
        ArrayList<String> bestPlayers = new ArrayList<>();
        int goodPlayerScore = 20;

        for (Player player : players) {
            if(player.getScore()>goodPlayerScore){
                bestPlayers.add(player.getName());
                goodPlayerScore=player.getScore();
            }
        }
        return bestPlayers;
    }



}
