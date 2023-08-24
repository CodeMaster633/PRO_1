package application.controller;

import application.model.*;
import javafx.scene.control.Alert;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Kunde createKunde (String navn, String mobil){
        Kunde kunde = new Kunde(navn,mobil);
        Storage.addKunde(kunde);

        return kunde;
    }

    public static Forestilling createForestilling (String navn, LocalDate starDato, LocalDate slutDato){
        Forestilling forestilling = new Forestilling(navn,starDato,slutDato);
        Storage.addForestilling(forestilling);

        return forestilling;
    }

    public static Plads createPlads (int række, int nr, int pris, PladsType pladsType){
        Plads plads = new Plads(række,nr,pris,pladsType);
        Storage.addPlads(plads);

        return plads;
    }

    public static ArrayList<Kunde> getKunder(){
        return Storage.getKunder();
    }

    public static ArrayList<Forestilling> getForestillinger(){
        return Storage.getForestillinger();
    }

    public static ArrayList<Plads> getPladser(){
        return Storage.getPladser();
    }

    public static Bestilling opretBestillingMedPladser(Forestilling forestilling, Kunde kunde, LocalDate dato, ArrayList<Plads> pladser){
        Bestilling bestilling = null;
        boolean ledig = true;

        for (int i = 0; i < pladser.size(); i++) {
            if(!forestilling.erPladsLedig(pladser.get(i).getRække(),pladser.get(i).getNr(),dato)){
                ledig=false;
            }
        }

        if(ledig){
            bestilling = new Bestilling(dato,kunde,forestilling);
            for (Plads p : pladser) {
                bestilling.addplads(p);
            }
        }

        return bestilling;
    }
}
