package guifx;

import application.controller.Controller;
import application.model.*;
import javafx.application.Application;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        initStorage();
//        test();
        Application.launch(GUI.class);

    }


    private static void initStorage() {
        Controller.createKonference("Hav og Himmel", LocalDate.of(2023, 05, 18), LocalDate.of(2023, 05, 20), "Odense Universitet", 1500, LocalDate.of(2023, 05, 15), null, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Controller.createKonference("Grøn Energi", LocalDate.of(2023, 05, 25), LocalDate.of(2023, 05, 28), "Aarhus Universitet", 1750, LocalDate.of(2023, 05, 22), null, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        Konference k1 = Controller.getKonferencer().get(0);
        Konference k2 = Controller.getKonferencer().get(1);

        Udflugt u1 = new Udflugt("Egeskov", "", LocalDate.of(2023, 05, 19), 75, false, k1,new ArrayList<>());
        Udflugt u2 = new Udflugt("Trapholt Museum", "Kolding", LocalDate.of(2023, 05, 20), 200, true, k1, new ArrayList<>());
        Udflugt u3 = new Udflugt("Byrundtur", "Odense", LocalDate.of(2023, 05, 20), 125, true, k1, new ArrayList<>());

        Tilvalg til1 = Controller.createTilvalg("WIFI", 50);
        Tilvalg til2 = Controller.createTilvalg("Bad", 200);
        Tilvalg til3 = Controller.createTilvalg("Mad", 100);

        ArrayList<Tilvalg> tilvalg = new ArrayList<>();
        tilvalg.add(til1);

        Hotel h1 = new Hotel("Den Hvide Svane", 13131313, 1050, 1250, tilvalg, new ArrayList<>(), new ArrayList<>());
        Hotel h2 = new Hotel("Hotel Phønix", 13131313, 700, 800, tilvalg, new ArrayList<>(), new ArrayList<>());
        Hotel h3 = new Hotel("Pension Tusindfryd", 13131313, 500, 600, tilvalg, new ArrayList<>(), new ArrayList<>());
        Storage.addHotel(h1);
        Storage.addHotel(h2);
        Storage.addHotel(h3);


        Controller.createDeltager("Finn Madsen", "Vej 1", "12121212", "Danmark", k1);
        Controller.createDeltager("Niels Petersen", "Vej 2", "14121212", "Danmark", k1);

        Tilmelding t1 = new Tilmelding(LocalDate.of(2023, 05, 18), LocalDate.of(2023, 05, 20), null, null, false, k1, null, null, Storage.getDeltagere().get(0), null);
        Tilmelding t2 = new Tilmelding(LocalDate.of(2023, 05, 18), LocalDate.of(2023, 05, 20), null, null, false, k1, null, null, Storage.getDeltagere().get(1), null);

        Ledsager l1 = new Ledsager("Mie Sommer", 16121212, new ArrayList<>(), t1);
        Ledsager l2 = new Ledsager("Lone Jensen", 17121212, new ArrayList<>(), t2);


        k1.addTilmelding(t1);
        k1.addTilmelding(t2);
        k2.addTilmelding(t1);

        h1.addTilmeldinger(t1);

        t1.setLedsager(l1);

        u1.addLedsager(l1);
        u1.addLedsager(l2);
        u2.addLedsager(l1);
        u3.addLedsager(l1);

        Controller.getKonferencer().get(0).addUdflugt(u1);
        Controller.getKonferencer().get(0).addUdflugt(u2);
        Controller.getKonferencer().get(0).addUdflugt(u3);

        Controller.getKonferencer().get(1).addUdflugt(u1);
        Controller.getKonferencer().get(1).addUdflugt(u2);
        Controller.getKonferencer().get(1).addUdflugt(u3);

        Controller.getKonferencer().get(0).addHotel(h1);
        Controller.getKonferencer().get(0).addHotel(h2);
        Controller.getKonferencer().get(0).addHotel(h3);




    }

    private static void test() {
        Konference k1 = new Konference("Hav og Himmel", LocalDate.of(2023, 05, 18), LocalDate.of(2023, 05, 20), "Odense Universitet", 1500, LocalDate.of(2023, 05, 10), null, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Deltager d1 = new Deltager("Finn Madsen", "Vej 1", "12121212", "Danmark", k1);
        Tilmelding t1 = new Tilmelding(LocalDate.of(2023, 05, 18), LocalDate.of(2023, 05, 20), null, null, false, k1, null, null, d1, null);
        Hotel h1 = new Hotel("Den Hvide Svane", 13131313, 1050, 1250, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        Deltager d2 = new Deltager("Niels Petersen", "Vej 2", "14121212", "Danmark", k1);
        Tilmelding t2 = new Tilmelding(LocalDate.of(2023, 05, 18), LocalDate.of(2023, 05, 20), null, null, false, k1, h1, null, d2, null);
        Tilvalg til1 = new Tilvalg("WIFI", 50, h1, new ArrayList<>());
        h1.addTilvalg(til1);
        Udflugt u1 = new Udflugt("Egeskov", "", LocalDate.of(2023, 05, 19), 75, false, k1, new ArrayList<>());
        Udflugt u2 = new Udflugt("Trapholt Museum", "Kolding", LocalDate.of(2023, 05, 20), 200, true, k1, new ArrayList<>());
        k1.addUdflugt(u1);
        k1.addUdflugt(u2);

        Deltager d3 = new Deltager("Peter Sommer", "Vej 3", "15121212", "Danmark", k1);
        Ledsager l1 = new Ledsager("Mie Sommer", 16121212, new ArrayList<>(), null); //Tilmeld fejl?
        l1.addUdflugt(u1);
        l1.addUdflugt(u2);
        Tilmelding t3 = new Tilmelding(LocalDate.of(2023, 05, 18), LocalDate.of(2023, 05, 20), null, null, false, k1, h1, new ArrayList<>(), d3, new ArrayList<>());
        t3.addTilvalg(til1);
        t3.setLedsager(l1);

        Udflugt u3 = new Udflugt("Byrundtur", "Odense", LocalDate.of(2023, 05, 20), 125, true, k1, new ArrayList<>());
        Deltager d4 = new Deltager("Lone Jensen", "Vej 3", "15121212", "Danmark", k1);
        Ledsager l2 = new Ledsager("Jan Madsen", 16121212, new ArrayList<>(), null); //Tilmeld fejl?
        l2.addUdflugt(u1);
        l2.addUdflugt(u3);
        Tilmelding t4 = new Tilmelding(LocalDate.of(2023, 05, 18), LocalDate.of(2023, 05, 20), null, null, true, k1, h1, new ArrayList<>(), d4, new ArrayList<>());
        t4.addTilvalg(til1);
        t4.setLedsager(l2);

        System.out.println("Test");
        System.out.println(Controller.samletPris(t1));
        System.out.println(Controller.samletPris(t2));
        System.out.println(Controller.samletPris(t3));
        System.out.println(Controller.samletPris(t4));

    }
}

