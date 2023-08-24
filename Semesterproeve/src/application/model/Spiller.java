package application.model;

import java.awt.print.Book;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Spiller {
    private String navn;
    private String uddannelse;
    private ArrayList<Booking> bookinger = new ArrayList<>();

    public Spiller(String navn, String uddannelse) {
        this.navn = navn;
        this.uddannelse = uddannelse;
    }

    public String getNavn() {
        return navn;
    }

    public String getUddannelse() {
        return uddannelse;
    }

    public ArrayList<Booking> getBookinger() {
        return new ArrayList<>(bookinger);
    }

    public void addBooking(Booking booking){
        if (!bookinger.contains(booking)) {
            bookinger.add(booking);
        }
    }

    public Booking createPerson(LocalDate dato, LocalTime tid, boolean single, Bane bane) {
        Booking booking = new Booking(dato, tid, single, this, bane);
        bookinger.add(booking);
        return booking;
    }

    public int samletPris(Kategori kategori){
        int result = 0;

        for (Booking booking : bookinger){
           if(booking.getBane().getKategori()==kategori){
               if(booking.isSingle()){
                   result+=booking.getBane().getKategori().getPrisKrSingle();
               } else{
                   result+=booking.getBane().getKategori().getPrisKrDouble();
               }
           };
        }

        return result;
    }

    @Override
    public String toString() {
        return navn +" (" + uddannelse + ')';
    }
}
