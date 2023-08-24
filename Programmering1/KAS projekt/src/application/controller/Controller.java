package application.controller;

import storage.Storage;
import application.model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Tilmelding createTilmelding(boolean foredragsholder, Konference konference, Deltager deltager) {
        Tilmelding tilmelding = new Tilmelding(null, null, null, null, foredragsholder, konference, null, null, deltager, null);
        Storage.addTilmelding(tilmelding);
        konference.addTilmelding(tilmelding);
        return tilmelding;
    }

    public static Tilmelding createTilmelding(boolean foredragsholder, Konference konference, Hotel hotel, Deltager deltager, ArrayList<Tilvalg> tilvalg) {
        Tilmelding tilmelding = new Tilmelding(foredragsholder, konference, hotel, deltager, tilvalg);
        Storage.addTilmelding(tilmelding);
        konference.addTilmelding(tilmelding);
        hotel.addTilmeldinger(tilmelding);
        return tilmelding;
    }

    public static Tilmelding createTilmelding(LocalDate ankomstDato, LocalDate afrejseDato, String firmaNavn, String firmaTelefon, boolean foredragsholder, Konference konference, Hotel hotel, ArrayList<Tilmelding> tilmeldinger, Deltager deltager, Ledsager ledsager, ArrayList<Tilvalg> tilvalg) {
        Tilmelding tilmelding = new Tilmelding(ankomstDato, afrejseDato, firmaNavn, firmaTelefon, foredragsholder, konference, hotel, tilmeldinger, deltager, tilvalg);
        Storage.addTilmelding(tilmelding);
        konference.addTilmelding(tilmelding);
        hotel.addTilmeldinger(tilmelding);

        return tilmelding;
    }

    public static Deltager createDeltager(String navn, String adresse, String telefonNr, String land, Konference konference){
        Deltager deltager = new Deltager(navn,adresse,telefonNr,land,konference);
        Storage.addDeltager(deltager);
        return deltager;
    }

    public static void deleteTilmelding(Tilmelding tilmelding) {
        Storage.removeTilmelding(tilmelding);
    }

    public static ArrayList<Tilmelding> getTilmeldinger() {
        return Storage.getTilmeldinger();
    }

    public static void createLedsager(String navn, int telefonNr, ArrayList<Udflugt> udflugter,Tilmelding tilmelding ){
        tilmelding.createLedsager(navn,telefonNr,udflugter,tilmelding);
        Storage.getTilmeldinger().set(Storage.getTilmeldinger().size()-1,tilmelding);
        for (int i = 0; i < udflugter.size(); i++) {
            udflugter.get(i).addLedsager(tilmelding.getLedsager());
        }
    }

    // -------------------------------------------------------------------------
    static Hotel createHotel(String navn, int telefonNr, boolean dobbeltVærelse, int enkeltVærelsePris, int dobbeltVærelsePris, ArrayList<Tilvalg> tilvalgt, ArrayList<Konference> konferencer, ArrayList<Tilmelding> tilmeldinger, int værelsePris) {
        Hotel hotel = new Hotel(navn, telefonNr, enkeltVærelsePris, dobbeltVærelsePris, tilvalgt, konferencer, tilmeldinger);
        Storage.addHotel(hotel);
        return hotel;
    }

    public static void deleteHotel(Hotel hotel) {
        Storage.removeHotel(hotel);
    }

    public static ArrayList<Hotel> getHoteller() {
        return Storage.getHoteller();
    }

    // -------------------------------------------------------------------------
    public static Tilvalg createTilvalg(String navn, int pris, Hotel hotel, ArrayList<Tilmelding> tilmeldinger) {
        Tilvalg tilvalg = new Tilvalg(navn, pris, hotel, tilmeldinger);
        Storage.addTilvalg(tilvalg);
        return tilvalg;
    }
    public static Tilvalg createTilvalg(String navn, int pris) {
        Tilvalg tilvalg = new Tilvalg(navn, pris);
        Storage.addTilvalg(tilvalg);
        return tilvalg;
    }

    public static void deleteTilvalg(Tilvalg tilvalg) {
        Storage.removeTilvalg(tilvalg);
    }

    public static ArrayList<Tilvalg> getTilvalg() {
        return Storage.getTilvalg();
    }

    // -------------------------------------------------------------------------
    static Deltager createKarantæne(String navn, String adresse, String telefonNr, String land, Konference konference) {
        Deltager deltager = new Deltager(navn, adresse, telefonNr, land, konference);
        Storage.addKarantæne(deltager);
        return deltager;
    }

    public static void deleteKarantæne(Deltager deltager) {
        Storage.removeKarantæne(deltager);
    }

    public static ArrayList<Deltager> getKarantæneListe() {
        return Storage.getKarantæneListe();
    }

    // -------------------------------------------------------------------------
    public static Konference createKonference(String navn, LocalDate startDato, LocalDate slutDato, String lokation, int konferenceAfgift, LocalDate senestTilmelding, ArrayList<Deltager> karantæneListe, ArrayList<Udflugt> udflugter, ArrayList<Hotel> hoteller, ArrayList<Tilmelding> tilmeldinger) {
        Konference konference = new Konference(navn, startDato, slutDato, lokation, konferenceAfgift, senestTilmelding, karantæneListe, udflugter, hoteller, tilmeldinger);
        Storage.addKonference(konference);
        return konference;
    }

    public static void deleteKonference(Konference konference) {
        Storage.removeKonference(konference);
    }

    public static ArrayList<Konference> getKonferencer() {
        return Storage.getKonferencer();
    }

    // -------------------------------------------------------------------------
    public static int samletPris(Tilmelding tilmelding) {
        int konferenceafgift = 0;
        if (tilmelding.getForedragsholder() == false) {
            konferenceafgift = tilmelding.getKonference().getKonferenceAfgift() * tilmelding.getAntalDage();
        }
        int værelsePris = tilmelding.getVærelsePris() * (tilmelding.getAntalDage() - 1);
        int tilvalgPris = 0;
        if (tilmelding.getTilvalg() == true) {
            tilvalgPris = tilmelding.getTilvalgPris() * (tilmelding.getAntalDage() - 1);
        }
        int udflugtPris = 0;
        if (tilmelding.getLedsager() != null) {
            udflugtPris = tilmelding.getLedsager().samletUdflugtPris();
        }

        return tilmelding.samletPris(konferenceafgift, værelsePris, tilvalgPris, udflugtPris);
    }

    public static String deltagerOversigt(Konference konference) {
        return null;
    }

    public static String udflugtMedDeltagerOversigt(Tilmelding tilmelding) {
        return null;

    }

    public static String hotellerMedBookinger(Konference konference) {
        return null;

    }

    public static Udflugt createUdflugt(String navn, String lokation, LocalDate dato, int pris, boolean frokost, Konference konference, ArrayList<Ledsager> ledsager) {
        Udflugt udflugt = new Udflugt(navn, lokation, dato, pris, frokost, konference, ledsager);
        konference.addUdflugt(udflugt);
        return udflugt;
    }
    public static ArrayList<Udflugt> getUdflugter(Konference konference) {return konference.getUdflugter();
    }
}
