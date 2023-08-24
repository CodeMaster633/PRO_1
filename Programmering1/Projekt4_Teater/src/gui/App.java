package gui;

import application.controller.Controller;
import application.model.Forestilling;
import application.model.Kunde;
import application.model.Plads;
import application.model.PladsType;
import javafx.application.Application;
import storage.Storage;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        initStorage();
        testPrint();
        Application.launch(Pane.class);

    }

    public static void initStorage() {
        Forestilling f1 = Controller.createForestilling("Evita", LocalDate.of(2023, 8, 10), LocalDate.of(2023, 8, 20));
        Forestilling f2 = Controller.createForestilling("Lykke Per", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 10));
        Forestilling f3 = Controller.createForestilling("Chess", LocalDate.of(2023, 8, 21), LocalDate.of(2023, 8, 30));

        Kunde k1 = Controller.createKunde("Anders Hansen", "11223344");
        Kunde k2 = Controller.createKunde("Peter Jensen", "12345678");
        Kunde k3 = Controller.createKunde("Niels Madsen", "12341234");

        for (int række = 1; række < 15; række++) {
            for (int kolonne = 1; kolonne < 20; kolonne++) {

                PladsType pladsType = PladsType.STANDART;
                if (række == 10 && kolonne < 7 && kolonne < 13) {
                    pladsType = PladsType.KØRESTOL;
                } else if (række == 11 && kolonne < 7 && kolonne < 13) {
                    pladsType = PladsType.EKSTRABEN;
                }

                int pris =0;
                if (række < 6 && kolonne < 3 || kolonne>18) {
                    pris = 450;
                }else if (række > 5 && række <11 && kolonne > 2 && kolonne<19) {
                    pris = 450;
                }else if(række<6 && kolonne>2 && kolonne<19){
                    pris=500;
                }else{
                    pris=400;
                }

                Plads plads = Controller.createPlads(række, kolonne, pris, pladsType);

            }

        }

    }

    public static void testPrint(){
        System.out.println();
        System.out.println("Forestillinger:");
        for (int i = 0; i < Controller.getForestillinger().size(); i++) {
            System.out.print(Controller.getForestillinger().get(i));
        }

        System.out.println();
        System.out.println("Kunder:");
        for (int i = 0; i < Controller.getKunder().size(); i++) {
            System.out.print(Controller.getKunder().get(i));
        }

        System.out.println();
        System.out.println("Pladser:");
        for (int i = 0; i < Controller.getPladser().size(); i++) {
            System.out.print(Controller.getPladser().get(i));
        }


    }
}
