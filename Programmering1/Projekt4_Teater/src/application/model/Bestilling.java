package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
    private LocalDate date;
    private ArrayList<Plads> pladser;
    private Kunde kunde;
    private Forestilling forestilling;

    public Bestilling (LocalDate date,Kunde kunde, Forestilling forestilling){
        this.date=date;
        this.kunde=kunde;
        kunde.addBestilling(this);
        pladser=new ArrayList<>();
        this.forestilling=forestilling;
    }

    public LocalDate getDate() {
        return date;
    }

    public void addplads(Plads plads){
        if(!pladser.contains(plads)){
            pladser.add(plads);
        }
    }

    public ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Forestilling getForestilling() {
        return forestilling;
    }

    @Override
    public String toString() {
        return "Bestilling oprettet for "+ kunde.getNavn()+" til "+forestilling.getNavn()+" d. "+date+" med pladserne "+pladser.size();
    }

    public int samletPris() {
        int samletPris = 0;
        for (Plads p : pladser) {
            samletPris += p.getPris();
        }
        return samletPris;
    }
}
