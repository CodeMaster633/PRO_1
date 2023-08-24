package guifx;

import application.controller.Controller;
import application.model.Bane;
import application.model.Booking;
import application.model.Kategori;
import application.model.Spiller;
import javafx.application.Application;

import java.time.LocalDate;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) {
        initStorage();
        String filNavn = "C:\\Users\\Benjamin\\Desktop\\Test.txt";
        Controller.udskrivBookinger(filNavn);
        Application.launch(Gui.class);
    }

    public static void initStorage(){
        Kategori k1 = Controller.createKategori("Luksus",100,200);
        Kategori k2 = Controller.createKategori("Mellem",50,100);
        Kategori k3 = Controller.createKategori("Begynder",25,50);

        Bane bane1 = Controller.createBane(1,true, LocalTime.parse("09:00:00"),LocalTime.parse("17:00:00"),k1);
        Bane bane2 = Controller.createBane(2,true, LocalTime.parse("09:00:00"),LocalTime.parse("17:00:00"),k1);
        Bane bane3 = Controller.createBane(3,true, LocalTime.parse("09:00:00"),LocalTime.parse("17:00:00"),k2);
        Bane bane4 = Controller.createBane(4,false, LocalTime.parse("09:00:00"),LocalTime.parse("17:00:00"),k2);
        Bane bane5 = Controller.createBane(5,false, LocalTime.parse("09:00:00"),LocalTime.parse("17:00:00"),k3);
        Bane bane6 = Controller.createBane(6,false, LocalTime.parse("09:00:00"),LocalTime.parse("17:00:00"),k3);

        Spiller s1 = Controller.createSpiller("Andreas","DMU");
        Spiller s2 = Controller.createSpiller("Petra","DMU");
        Spiller s3 = Controller.createSpiller("Henrik","ITA");
        Spiller s4 = Controller.createSpiller("Ulla","ITA");

        Booking booking1 = Controller.createBooking(LocalDate.of(20,06,23),LocalTime.of(10,0,0),true,s1,bane3);
        Booking booking2 = Controller.createBooking(LocalDate.of(22,06,23),LocalTime.of(10,0,0),false,s1,bane2);
        Booking booking3 = Controller.createBooking(LocalDate.of(20,06,23),LocalTime.of(11,0,0),false,s3,bane3);
        Booking booking4 = Controller.createBooking(LocalDate.of(20,06,23),LocalTime.of(16,0,0),false,s4,bane3);
        Booking booking5 = Controller.createBooking(LocalDate.of(23,06,23),LocalTime.of(17,0,0),true,s4,bane5);

    }
}
