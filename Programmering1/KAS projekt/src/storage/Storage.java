package storage;
import application.model.*;
import com.sun.javafx.collections.ElementObservableListDecorator;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    private static ArrayList<Hotel> hoteller = new ArrayList<Hotel>();
    private static ArrayList<Tilvalg> tilvalgt = new ArrayList<Tilvalg>();
    private static ArrayList<Deltager> karantæneListe = new ArrayList<Deltager>();
    private static ArrayList<Konference> konferencer = new ArrayList<Konference>();
    private static ArrayList<Deltager> deltagere = new ArrayList<Deltager>();


    // -------------------------------------------------------------------------

    public static ArrayList<Tilmelding> getTilmeldinger() {return new ArrayList<>(tilmeldinger);}
    public static void addTilmelding(Tilmelding tilmeld) {tilmeldinger.add(tilmeld);}
    public static void removeTilmelding(Tilmelding tilmeld) {tilmeldinger.remove(tilmeld);}
    // -------------------------------------------------------------------------
    public static ArrayList<Hotel> getHoteller() {return new ArrayList<>(hoteller);}
    public static void addHotel(Hotel hotel) {hoteller.add(hotel);}
    public static void removeHotel(Hotel hotel) {hoteller.remove(hotel);}
    // -------------------------------------------------------------------------
    public static ArrayList<Tilvalg> getTilvalg() {return new ArrayList<>(tilvalgt);}
    public static void addTilvalg(Tilvalg tilvalg) {tilvalgt.add(tilvalg);}
    public static void removeTilvalg(Tilvalg tilvalg) {tilvalgt.remove(tilvalg);}
    // -------------------------------------------------------------------------
    public static ArrayList<Deltager> getKarantæneListe() {return new ArrayList<>(karantæneListe);}
    public static void addKarantæne(Deltager deltager) {karantæneListe.add(deltager);}
    public static void removeKarantæne(Deltager deltager) {karantæneListe.remove(deltager);}
    // -------------------------------------------------------------------------
    public static ArrayList<Konference> getKonferencer() {return new ArrayList<>(konferencer);}
    public static void addKonference(Konference konference) {konferencer.add(konference);}
    public static void removeKonference(Konference konference) {konferencer.remove(konference);}
    // -------------------------------------------------------------------------

    public static void addDeltager(Deltager deltager) {deltagere.add(deltager);}
    public static ArrayList<Deltager> getDeltagere() {return new ArrayList<Deltager>(deltagere);}
    // -------------------------------------------------------------------------


}
