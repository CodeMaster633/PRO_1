package rep2.storage;

import rep2.application.model.Salg;
import rep2.application.model.Sælger;
import rep2.application.model.Vare;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Vare> varer = new ArrayList<>();
    private static ArrayList<Salg> salgene = new ArrayList<>();
    private static ArrayList<Sælger> sælgere = new ArrayList<>();

    public ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    public static ArrayList<Salg> getSalg() {
        return new ArrayList<>(salgene);
    }

    public static ArrayList<Sælger> getSælgere() {
        return new ArrayList<>(sælgere);
    }

    public static void addVare(Vare vare){
        varer.add(vare);
    }
    public static void addSalg(Salg salg){
        salgene.add(salg);
    }
    public static void addSælger(Sælger sælger){
        sælgere.add(sælger);
    }
}
