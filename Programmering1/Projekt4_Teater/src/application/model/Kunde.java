package application.model;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Kunde {
    private String navn;
    private String mobil;
    private ArrayList<Bestilling> bestillinger;

    public Kunde(String navn, String mobil){
        this.navn=navn;
        this.mobil=mobil;
        bestillinger = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public void addBestilling(Bestilling bestilling){
        if(!bestillinger.contains(bestilling)){
            bestillinger.add(bestilling);
            bestilling.setKunde(this);
        }
    }

    public ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(bestillinger);
    }

    @Override
    public String toString() {
        return "Navn: "+navn+", Mobil: "+mobil+"\n";
    }

    public ArrayList<Plads> bestiltePladserTilForestillingPåDag(Forestilling forestilling, LocalDate dato) {
        ArrayList<Plads> pladserPåDato = new ArrayList<>();
        for (Bestilling b : bestillinger) {
            if (b.getForestilling().equals(forestilling) && b.getDate().equals(dato)) {
                pladserPåDato.addAll(b.getPladser());
            }
        }
        return pladserPåDato;
    }
}
