package storage;

import application.model.Festival;
import application.model.Frivillig;
import application.model.Vagt;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Festival> festivaler = new ArrayList<>();
    private static ArrayList<Frivillig> frivillige = new ArrayList<>();

    public ArrayList<Festival> getFestivaller() {
        return new ArrayList<>(festivaler);
    }

    public ArrayList<Frivillig> getFrivillige() {
        return new ArrayList<>(frivillige);
    }

    public static void addFestival(Festival festival){
        if (!festivaler.contains(festival)) {
            festivaler.add(festival);
        }
    }

    public static void addFrivillig(Frivillig frivillig){
        if (!frivillige.contains(frivillig)) {
            frivillige.add(frivillig);
        }
    }


}
