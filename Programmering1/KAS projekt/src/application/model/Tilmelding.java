package application.model;

import javax.naming.Name;
import java.time.LocalDate;
import java.util.ArrayList;

public class Tilmelding {
    private LocalDate ankomstDato;
    private LocalDate afrejseDato;
    private String firmaNavn;
    private String firmaTelefon;
    private boolean foredragsholder;
    private Konference konference;
    private Hotel hotel;
    private ArrayList<Tilmelding> tilmeldinger;
    private Deltager deltager;
    private Ledsager ledsager;
    private int samletPris;
    private ArrayList<Tilvalg> tilvalg;

    public Tilmelding(LocalDate ankomstDato, LocalDate afrejseDato, String firmaNavn, String firmaTelefon, boolean foredragsholder, Konference konference, Hotel hotel, ArrayList<Tilmelding> tilmeldinger, Deltager deltager, ArrayList<Tilvalg> tilvalg) {
        this.ankomstDato = ankomstDato;
        this.afrejseDato = afrejseDato;
        this.firmaNavn = firmaNavn;
        this.firmaTelefon = firmaTelefon;
        this.foredragsholder = foredragsholder;
        this.konference = konference;
        this.hotel = hotel;
        this.tilmeldinger = tilmeldinger;
        this.deltager = deltager;
        this.tilvalg = tilvalg;
    }

    public Tilmelding(boolean foredragsholder, Konference konference, Hotel hotel, Deltager deltager, ArrayList<Tilvalg> tilvalg) {
        this.foredragsholder = foredragsholder;
        this.konference = konference;
        this.hotel = hotel;
        this.deltager = deltager;
        this.tilvalg = tilvalg;
    }

    public void setLedsager(Ledsager ledsager) {
        this.ledsager = ledsager;
    }

    public int samletPris(int konferenceAfgift, int værelsePris, int tilvalgPris, int udflugtPris) {
        int samletPris = konferenceAfgift + værelsePris + tilvalgPris + udflugtPris;
        this.samletPris = samletPris;

        return samletPris;
    }

    public Deltager getDeltager() {
        return deltager;
    }

    public Ledsager getLedsager() {

        return ledsager;
    }

    public Konference getKonference() {
        return konference;
    }

    public Ledsager createLedsager(String navn, int telefonNr, ArrayList<Udflugt> udflugter, Tilmelding tilmelding) {
        Ledsager ledsager = new Ledsager(navn, telefonNr, udflugter, this);
        this.ledsager = ledsager;
        return ledsager;
    }

    public void valgtHotel(Hotel hotel) {

    }

    public int getAntalDage() {
        int result = 3;

        if(afrejseDato!=null){
            result = afrejseDato.compareTo(ankomstDato) + 1;
        }

        return result;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public int getVærelsePris() {
        int værelsePris = 0;
        if (this.hotel != null && this.ledsager != null) {
            værelsePris = hotel.getDobbeltVærelsePris();
        } else if (this.hotel != null) {
            værelsePris = hotel.getEnkeltVærelsePris();
        }

        return værelsePris;
    }

    public int getTilvalgPris() {
        int tilvalgPris = 0;
        if (hotel != null) {
            for (Tilvalg tilvalg : tilvalg) {
                tilvalgPris += tilvalg.getPris();
            }
        }
        return tilvalgPris;
    }

    public void addTilvalg(Tilvalg tilvalg) {
        this.tilvalg.add(tilvalg);
    }

    public boolean getTilvalg() {
        boolean result = false;
        if(tilvalg!=null){result = true;}
        return result;
    }

    public boolean getForedragsholder() {
        return foredragsholder;
    }

    @Override
    public String toString() {
        return ""+ deltager.getNavn()+"\n"+"Fra "+getKonference().getStartDato()+" til "+ getKonference().getSlutDato();
    }
}
