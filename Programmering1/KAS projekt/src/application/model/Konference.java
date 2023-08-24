package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;
    private String lokation;
    private int konferenceAfgift;
    private LocalDate senestTilmelding;
    private ArrayList<Deltager> karantæneListe;
    private ArrayList<Udflugt> udflugter;
    private ArrayList<Hotel> hoteller;
    private ArrayList<Tilmelding> tilmeldinger;

    public Konference(String navn, LocalDate startDato, LocalDate slutDato, String lokation, int konferenceAfgift, LocalDate senestTilmelding, ArrayList<Deltager> karantæneListe, ArrayList<Udflugt> udflugter, ArrayList<Hotel> hoteller, ArrayList<Tilmelding> tilmeldinger) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.lokation = lokation;
        this.konferenceAfgift = konferenceAfgift;
        this.senestTilmelding = senestTilmelding;
        this.karantæneListe = karantæneListe;
        this.udflugter = udflugter;
        this.hoteller = hoteller;
        this.tilmeldinger = tilmeldinger;
    }
    public ArrayList<Deltager> getKarantæneListe(){return new ArrayList<>(karantæneListe);}
    public void addDeltager(Deltager deltager){
        if(!karantæneListe.contains(deltager)){
            karantæneListe.add(deltager);
        }
    }
    public void removeDeltager(Deltager deltager){
        if(karantæneListe.contains(deltager)){
            karantæneListe.remove(deltager);
        }
    }
    public ArrayList<Udflugt> getUdflugter(){return new ArrayList<>(udflugter);}
    public void addUdflugt(Udflugt udflugt){
        if(!udflugter.contains(udflugt)){
            udflugter.add(udflugt);
        }
    }
    public void removeUdflugt(Udflugt udflugt){
        if(!udflugter.contains(udflugt)){
            udflugter.remove(udflugt);
        }
    }
    public ArrayList<Hotel> getHoteller(){return new ArrayList<>(hoteller);}
    public void addHotel(Hotel hotel){
        if(!hoteller.contains(hotel)){
            hoteller.add(hotel);
        }
    }
    public void removeHotel(Hotel hotel){
        if(hoteller.contains(hotel)){
            hoteller.remove(hotel);
        }
    }
    public ArrayList<Tilmelding> getTilmeldinger(){return new ArrayList<>(tilmeldinger);}
    public void addTilmelding(Tilmelding tilmelding){
        if(!tilmeldinger.contains(tilmelding)){
            tilmeldinger.add(tilmelding);
        }
    }
    public void removeTilmelding(Tilmelding tilmelding){
        if(tilmeldinger.contains(tilmelding)){
            tilmeldinger.remove(tilmelding);
        }
    }
    public String deltagerOversigt(){

        return null;
    }

    public ArrayList<Udflugt> getUdflugterMedLedsager(){return new ArrayList<>(udflugter);}
    public Udflugt createUdflugt(String navn, String lokation, LocalDate dato, int pris, boolean frokost, Konference konference, ArrayList<Ledsager> ledsager){
        Udflugt udflugt = new Udflugt(navn, lokation, dato, pris, frokost, this, ledsager);
        udflugter.add(udflugt);
        return udflugt;
    }
    public String hotellerMedBookingOversigt(){
        return null;
    }

    public int getKonferenceAfgift() {
        return konferenceAfgift;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    @Override
    public String toString() {
        return ""+navn+" ("+konferenceAfgift+"kr.)";
    }
}
