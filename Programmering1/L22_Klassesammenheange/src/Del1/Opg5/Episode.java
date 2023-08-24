package Del1.Opg5;

import java.util.ArrayList;

public class Episode {
    private int number;
    private int lengthMinutes;
    private ArrayList<String> guestActors = new ArrayList<>();

    public Episode (int number, int lengthMinutes, ArrayList<String> guestActors){
        this.number=number;
        this.lengthMinutes=lengthMinutes;
        this.guestActors=guestActors;
    }

    public int getNumber() {
        return number;
    }

    public int getLengthMinutes() {
        return lengthMinutes;
    }

    public ArrayList<String> getGuestActors() {
        return guestActors;
    }
}
