package application.controller;

import application.model.Bane;
import application.model.Booking;
import application.model.Kategori;
import application.model.Spiller;
import storage.Storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.PublicKey;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public static Kategori createKategori(String navn, int prisKrSingle, int prisKrDouble) {
        Kategori kategori = new Kategori(navn, prisKrSingle, prisKrDouble);
        Storage.addKategori(kategori);
        return kategori;
    }

    public static Bane createBane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid, Kategori kategori) {
        Bane bane = new Bane(nummer, inde, førsteTid, sidsteTid, kategori);
        Storage.addBane(bane);
        return bane;
    }

    public static Spiller createSpiller(String navn, String uddannelse) {
        Spiller spiller = new Spiller(navn, uddannelse);
        Storage.addSpiller(spiller);
        return spiller;
    }

    public static Booking createBooking(LocalDate dato, LocalTime tid, boolean single, Spiller spiller, Bane bane) {
        Booking booking = new Booking(dato, tid, single, spiller, bane);
        return booking;
    }

    public static ArrayList<Bane> getBaner() {
        return new ArrayList<>(Storage.getBaner());
    }

    public static ArrayList<Spiller> getSpillere() {
        return new ArrayList<>(Storage.getSpillere());
    }

    public static int samletBooketDoubleTid(String uddannelse, Kategori kategori) {
        int result = 0;

        for (Spiller spiller : Storage.getSpillere()) {
            if (spiller.getUddannelse() == uddannelse) {
                for (Booking booking : spiller.getBookinger())
                    if (!booking.isSingle()) {
                        if (booking.getBane().getKategori() == kategori) {
                            result++;
                        }
                    }
            }
        }

        return result;
    }


    public static void udskrivBookinger(String filNavn) {

        try {
            PrintWriter printWriter = new PrintWriter(filNavn);

            for (Bane bane : Storage.getBaner()) {
                for (Booking booking : bane.getBookinger()) {
                    printWriter.println("Bane nr:" + booking.getBane().getNummer()+
                            ", dag: "+booking.getDato()+" kl. "+booking.getTid()+", spil: "
                            +booking.isSingle()+", spiller: "+booking.getSpiller().getNavn()+"\n");
                }
            }

            printWriter.close();

            System.out.println("Filen er printet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Bane findLedigBane(LocalDate dato, LocalTime tid, Kategori kategori){
        Bane result = null;

        for (Bane bane : Storage.getBaner()){
            if(bane.tidLedig(dato,tid)){
                if(bane.getKategori()==kategori){
                    result = bane;
                }
            };
        }

        return result;
    }


}