package Opg4;

import java.util.ArrayList;

public class App {
    private static ArrayList<Hund> hunde = new ArrayList<>();
    public static void main(String[] args) {

        Hund h1 = new Hund("Boogie", true, 11000, Race.PUDDEL);
        Hund h2 = new Hund("Charlie", true, 14000, Race.BOKSER);
        Hund h3 = new Hund("Fido", false, 500, Race.TERRIER);
        Hund h4 = new Hund("Bella", false, 1300, Race.BOKSER);
        Hund h5 = new Hund("Tikka", true, 5000, Race.PUDDEL);

        hunde.add(h1);
        hunde.add(h2);
        hunde.add(h3);
        hunde.add(h4);
        hunde.add(h5);

        System.out.println("Samlet pris: " + samletPris(hunde,Race.PUDDEL));

    }

    public static int samletPris(ArrayList<Hund> hunde, Race race) {
        int samletPris = 0;

        for (int i = 0; i < hunde.size(); i++) {
            if(hunde.get(i).getRace()==race){
                samletPris+=hunde.get(i).getPris();
            }
        }

        return samletPris;
    }

}
