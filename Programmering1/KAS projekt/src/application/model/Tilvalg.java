package application.model;

import java.util.ArrayList;

public class Tilvalg {
    private String navn;
    private int pris;
    private Hotel hotel;
    private ArrayList<Tilmelding> tilmeldinger;

    public Tilvalg(String navn, int pris, Hotel hotel, ArrayList<Tilmelding> tilmeldinger) {
        this.navn = navn;
        this.pris = pris;
        this.hotel = hotel;
        this.tilmeldinger = tilmeldinger;
    }

    public Tilvalg(String navn, int pris) {
        this.navn = navn;
        this.pris = pris;
    }

    public Hotel getHotel() {return hotel;}

    public void setHotel(Hotel hotel) {this.hotel = hotel;}

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

    public int samletPris(ArrayList<Tilvalg> tilvalgt){

        int samletPris = 0;

        return samletPris;
    }

    public int getPris() {
        return pris;
    }
}
