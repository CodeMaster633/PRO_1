package application.model;

import java.sql.Array;
import java.util.ArrayList;

public class Ledsager {
    private String navn;
    private int telefonNr;
    private ArrayList<Udflugt> udflugter;
    private Tilmelding tilmelding;


    public Ledsager(String navn, int telefonNr, ArrayList<Udflugt> udflugter, Tilmelding tilmelding) {
        this.navn = navn;
        this.telefonNr = telefonNr;
        this.udflugter = udflugter;
        this.tilmelding = tilmelding;
    }
    public Tilmelding getTilmelding(){return tilmelding;}

    public void setTilmelding(Tilmelding tilmelding) {this.tilmelding = tilmelding;}

    public ArrayList<Udflugt> getUdflugt(){return new ArrayList<>(udflugter);}
    public void addUdflugt(Udflugt udflugt){
        if(!udflugter.contains(udflugt)){
            udflugter.add(udflugt);
        }
    }
    public void removeUdflugt(Udflugt udflugt){
        if(udflugter.contains(udflugt)){
            udflugter.remove(udflugt);
        }
    }
    public int samletUdflugtPris(){
        int udflugtPris = 0;

        if(udflugter!=null) {
            for (Udflugt udflugt : udflugter) {
                udflugtPris += udflugt.getPris();
            }
        }

        return udflugtPris;
    }

    @Override
    public String toString() {
        if (tilmelding.getLedsager() == null) {
            return tilmelding.getDeltager().getNavn() + " med ledsager " + navn + "\n" + "Fra " + tilmelding.getKonference().getStartDato() + " til " + tilmelding.getKonference().getSlutDato();
        }else{
            return tilmelding.getDeltager().getNavn()+"\n" + "Fra " + tilmelding.getKonference().getStartDato() + " til " + tilmelding.getKonference().getSlutDato();
        }
    }
}
