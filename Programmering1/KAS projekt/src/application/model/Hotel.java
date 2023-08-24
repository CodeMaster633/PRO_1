package application.model;

import java.sql.Array;
import java.util.ArrayList;

public class Hotel {
    private String navn;
    private int telefonNr;
    private boolean dobbeltVærelse;
    private int enkeltVærelsePris;
    private int dobbeltVærelsePris;
    private ArrayList<Tilvalg> tilvalgt;
    private ArrayList<Konference> konferencer;
    private ArrayList<Tilmelding> tilmeldinger;
    private int værelsePris;

    public Hotel(String navn, int telefonNr, int enkeltVærelsePris, int dobbeltVærelsePris, ArrayList<Tilvalg> tilvalgt, ArrayList<Konference> konferencer, ArrayList<Tilmelding> tilmeldinger) {
        this.navn = navn;
        this.telefonNr = telefonNr;
        this.enkeltVærelsePris = enkeltVærelsePris;
        this.dobbeltVærelsePris = dobbeltVærelsePris;
        this.tilvalgt = tilvalgt;
        this.konferencer = konferencer;
        this.tilmeldinger = tilmeldinger;
    }
    public ArrayList<Tilvalg> getTilvalg(){return new ArrayList<>(tilvalgt);}
    public void addTilvalg(Tilvalg tilvalg){
        if(!tilvalgt.contains(tilvalg)){
            tilvalgt.add(tilvalg);
        }
    }
    public void removeTilvalg(Tilvalg tilvalg){
        if(tilvalgt.contains(tilvalg)){
            tilvalgt.remove(tilvalg);
        }
    }
    public ArrayList<Konference> getKonferencer(){return new ArrayList<>(konferencer);}
    public void addKonference(Konference konference){
        if(!konferencer.contains(konference)){
            konferencer.add(konference);
        }
    }
    public void removeKonference(Konference konference){
        if(konferencer.contains(konference)){
            konferencer.remove(konference);
        }
    }
    public ArrayList<Tilmelding> getTilmeldinger(){return new ArrayList<>(tilmeldinger);}
    public void addTilmeldinger(Tilmelding tilmelding){
        if(!tilmeldinger.contains(tilmelding)){
            tilmeldinger.add(tilmelding);
        }
    }
    public void removeTilmelding(Tilmelding tilmelding){
        if(tilmeldinger.contains(tilmelding)){
            tilmeldinger.remove(tilmelding);
        }
    }
    public ArrayList<Ledsager> getBookinger(){
        ArrayList<Ledsager> ledsagere = new ArrayList<>();
        ArrayList<Deltager> deltagere = new ArrayList<>();

        for (int i = 0; i < tilmeldinger.size(); i++) {
//            if (tilmeldinger.get(i).getLedsager()!=null){
            ledsagere.add(tilmeldinger.get(i).getLedsager());

        }

        return ledsagere;
    }

    public int samletHotelPris(ArrayList<Tilvalg> tilvalg){
        int hotelPris = 0;

        return hotelPris;
    }

    public int getEnkeltVærelsePris() {
        return this.enkeltVærelsePris;
    }

    public int getDobbeltVærelsePris() {
        return this.dobbeltVærelsePris;
    }

    @Override
    public String toString() {
        return ""+navn+" ("+enkeltVærelsePris+"/"+dobbeltVærelsePris+")";
    }
}
