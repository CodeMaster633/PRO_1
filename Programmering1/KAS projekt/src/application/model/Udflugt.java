package application.model;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {
    private String navn;
    private String lokation;
    private LocalDate dato;
    private int pris;
    private boolean frokost;
    private Konference konference;
    private ArrayList<Ledsager> ledsagere;

    public Udflugt(String navn, String lokation, LocalDate dato, int pris, boolean frokost, Konference konference, ArrayList<Ledsager> ledsager) {
        this.navn = navn;
        this.lokation = lokation;
        this.dato = dato;
        this.pris = pris;
        this.frokost = frokost;
        this.konference = konference;
        this.ledsagere = ledsagere;
    }

    public Konference getKonference() {return konference;}

    public void setKonference(Konference konference) {this.konference = konference;}

    public ArrayList<Ledsager> getLedsager() {return new ArrayList<>(ledsagere);
    }
    public void addLedsager(Ledsager ledsager){
        if (ledsagere == null) {
            ledsagere = new ArrayList<>();
        }
        if (!ledsagere.contains(ledsager)) {
            ledsagere.add(ledsager);
        }
    }
    public void removeLedsager(Ledsager ledsager){
        if(ledsagere.contains(ledsager)){
            ledsagere.remove(ledsager);
        }
    }

    public int getPris() {
        return pris;
    }

    @Override
    public String toString() {
        return navn;
    }
}
