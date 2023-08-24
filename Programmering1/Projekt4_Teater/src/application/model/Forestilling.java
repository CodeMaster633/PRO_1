package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Forestilling {
    private String navn;
    private LocalDate starDato;
    private LocalDate slutDato;
    private ArrayList<Bestilling> bestillinger;

    public Forestilling(String navn,LocalDate starDato,LocalDate slutDato){
        this.navn=navn;
        this.starDato=starDato;
        this.slutDato=slutDato;
        bestillinger = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getStartDato() {
        return starDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public Bestilling createBestilling(LocalDate date,Kunde kunde){
        Bestilling bestilling = new Bestilling(date,kunde, this);
        bestillinger.add(bestilling);

        return bestilling;
    }

    public ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(bestillinger);
    }

    @Override
    public String toString() {
        return "Navn: "+navn+", Startdato: "+ starDato.toString()+", Startdato: "+ slutDato.toString()+"\n";
    }

    public boolean erPladsLedig(int række,int nr, LocalDate dato){
        boolean ledig = true;

        for (int i = 0; i < bestillinger.size(); i++) {
            if(bestillinger.get(i).getDate().equals(dato)) {
                ArrayList<Plads> pladser = bestillinger.get(i).getPladser();

                for (int j = 0; j < pladser.size(); j++) {
                    if(pladser.get(j).getNr()==nr && pladser.get(j).getRække()==række){
                        ledig=false;
                    }
                }
            }
        }

        return ledig;
    }

    public int antalBestiltePladserPåDag(LocalDate dato) {
        int antalBestiltePladser = 0;
        if (dato.isAfter(starDato) && dato.isBefore(slutDato) || dato.isEqual(starDato) || dato.isEqual(slutDato)) {
            for (Bestilling b : bestillinger) {
                antalBestiltePladser += b.getPladser().size();
            }
        }
        return antalBestiltePladser;
    }

    public LocalDate succesDato() {
        LocalDate succesDato = null;
        int flestBestilte = 0;

        LocalDate start = this.getStartDato();
        LocalDate slut = this.getSlutDato();

        LocalDate dato = start;
        while (!dato.equals(slut.plusDays(1))) {
            int antalBestilte = antalBestiltePladserPåDag(dato);
            if (antalBestilte > flestBestilte) {
                flestBestilte = antalBestilte;
                succesDato = dato;
            }
        }
        return succesDato;
    }
}
