package application.model;

import application.controller.Controller;

import java.awt.print.Book;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.LongToIntFunction;

public class Bane {
    private int nummer;
    private boolean inde;
    private LocalTime førsteTid;
    private LocalTime sidsteTid;
    private ArrayList<Booking> bookinger = new ArrayList<>();
    private Kategori kategori;

    public Bane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid, Kategori kategori) {
        this.nummer = nummer;
        this.inde = inde;
        this.førsteTid = førsteTid;
        this.sidsteTid = sidsteTid;
        this.kategori = kategori;
    }

    public int getNummer() {
        return nummer;
    }

    public boolean isInde() {
        return inde;
    }

    public LocalTime getFørsteTid() {
        return førsteTid;
    }

    public LocalTime getSidsteTid() {
        return sidsteTid;
    }

    public ArrayList<Booking> getBookinger() {
        return new ArrayList<>(bookinger);
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        if (this.kategori != kategori) {
            this.kategori = kategori;
        }
    }

    public void addBooking(Booking booking) {
        if (!bookinger.contains(booking)) {
            bookinger.add(booking);
            booking.setBane(this);
        }
    }

    public void removeBooking(Booking booking) {
        if (bookinger.contains(booking)) {
            bookinger.remove(booking);
            booking.setBane(null);
        }
    }

    public int bookedeTimerPåDato(LocalDate dato) {
        int result = 0;

        for (Booking booking : bookinger) {
            if (booking.getDato() == dato) {
                result++;
            }
        }

        return result;
    }

    public int[] antalBookingerPrTime() {
        int[] result = new int[longToIntFunction(førsteTid.until(sidsteTid, ChronoUnit.HOURS)) + 1];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < bookinger.size(); j++) {
                if (bookinger.get(j).getTid() == førsteTid.plus(i, ChronoUnit.HOURS))
                    result[i]++;
            }
        }

        return result;
    }

    public String antalBookingerPrTimeStr() {
        String result = "";

        for (int i = 0; i < antalBookingerPrTime().length; i++) {
            result = result + "Tid: " + (i + 9) + " antal: " + antalBookingerPrTime()[i] + "\n";
        }
        return result;
    }

    public int longToIntFunction(Long num) {
        int result = Integer.parseInt(num.toString());
        return result;
    }

    public boolean tidLedig(LocalDate dato, LocalTime tid) {
        boolean result = false;

        int i = 1;
        for (Bane bane : Controller.getBaner()) {
            while (!result && i < Controller.getBaner().size()) {
                for (int j = 0; j < bane.bookinger.size(); j++) {
                    if (bane.bookinger.get(j).getDato() == dato && bane.bookinger.get(j).getTid() == tid) {
                        result = true;
                    }
                }
            }
        }

        return result;
    }

    @Override
    public String toString() {
        String str;
        if (inde) {
            str = "Nr. " + nummer + " inde (09:00 -> 17:00), " + kategori.getNavn();
        } else {
            str = "Nr. " + nummer + " ude (09:00 -> 17:00), " + kategori.getNavn();
        }
        return str;
    }
}
