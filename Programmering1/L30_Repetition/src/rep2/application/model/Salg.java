package rep2.application.model;

import java.util.ArrayList;

public class Salg {

    private String købersNavn;
    private int aftaltSampelPris;
    private ArrayList<Vare> varer = new ArrayList<>();

    public Salg(String købersNavn, int aftaltSampelPris, ArrayList<Vare> varer) {
        this.købersNavn = købersNavn;
        this.aftaltSampelPris = aftaltSampelPris;
        this.varer = varer;
        for (Vare vare : varer){
            vare.setSolgt();
            if(vare.getSalgsannonce()!=null){
                vare.getSalgsannonce().opdaterSalgsannonce();
            }
        }

    }

    public String getKøbersNavn() {
        return købersNavn;
    }

    public int getAftaltSampelPris() {
        return aftaltSampelPris;
    }

    public ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

}
