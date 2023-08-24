package rep2.application.controller;

import rep2.application.model.*;
import rep2.storage.Storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Controller {

    public static Sælger createSælger(String navn, int studikortNummer, String mobil) {
        Sælger sælger = new Sælger(navn, studikortNummer, mobil);
        Storage.addSælger(sælger);
        return sælger;
    }

    public static Vare createVare(Varekategori kategori, String navn, int udbudspris) {
        Vare vare = new Vare(kategori, navn, udbudspris);
        Storage.addVare(vare);
        return vare;
    }

    public static Salgsannonce createSalgsannonce(Sælger sælger, ArrayList<Vare> varer) {
        Salgsannonce salgsannonce = sælger.createSalgsannonce(sælger, varer);
//        Salgsannonce salgsannonce = new Salgsannonce(sælger,varer);
        return salgsannonce;
    }

    public static Salg createSalg(String navn, int aftaltPris, ArrayList<Vare> varer) {
        Salg salg = new Salg(navn, aftaltPris, varer);
        Storage.addSalg(salg);
        return salg;
    }

    public static void initStorage() {
        Sælger sælger1 = createSælger("Viktor", 23, "45344247");
        Sælger sælger2 = createSælger("Gustav", 35, "56124522");

        Vare vare1 = createVare(Varekategori.MOBILTELEFON, "IPhone", 2000);
        Vare vare2 = createVare(Varekategori.MOBILTELEFON, "Samsung mobil", 1200);
        Vare vare3 = createVare(Varekategori.STUDIEBOG, "Java", 400);
        Vare vare4 = createVare(Varekategori.STUDIEBOG, "Android", 300);
        Vare vare5 = createVare(Varekategori.STUDIEBOG, "Python", 200);
        Vare vare6 = createVare(Varekategori.TØJ, "Regnjakke", 100);
        Vare vare7 = createVare(Varekategori.TØJ, "Regnbukser", 80);

        Salgsannonce salgsannonce1 = createSalgsannonce(sælger1, new ArrayList<>(List.of(vare2)));
        Salgsannonce salgsannonce2 = createSalgsannonce(sælger1, new ArrayList<>(List.of(vare3, vare4, vare5)));
        Salgsannonce salgsannonce3 = createSalgsannonce(sælger2, new ArrayList<>(List.of(vare1)));
        Salgsannonce salgsannonce4 = createSalgsannonce(sælger2, new ArrayList<>(List.of(vare6, vare7)));

        Salg salg1 = createSalg("Stine", 450, new ArrayList<>(List.of(vare4, vare5)));
        Salg salg2 = createSalg("Laura", 120, new ArrayList<>(List.of(vare6, vare7)));

        String filNavn = "C:\\Users\\Benjamin\\Desktop\\Test.txt";
        salgTilFil(filNavn);
    }

    public static void salgTilFil(String filNavn) {

        try {
            PrintWriter printWriter = new PrintWriter(filNavn);

            for (int n = 0; n <= Storage.getSalg().size()-1; n++) {
                Salg salg = Storage.getSalg().get(n);
                printWriter.println(""+salg.getKøbersNavn()+"\n  ");
                for (int i = 0; i < salg.getVarer().size(); i++) {
                    printWriter.println(""+salg.getVarer().get(i)+"\n  ");
                }
                printWriter.println("Aftalt pris: "+salg.getAftaltSampelPris()+"  rabat er: "+salg.getAftaltSampelPris()+"\n \n");
            }

            // skriv filen
            printWriter.close();

            System.out.println("Filen er printet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Salgsannonce> getSalgsannoncer() {

        ArrayList<Salgsannonce> salgsannoncer = new ArrayList<>();
        for (int i = 0; i < Storage.getSælgere().size(); i++) {
            for (int j = 0; j < Storage.getSælgere().get(i).getSalgsannoncer().size(); j++) {
                salgsannoncer.add(Storage.getSælgere().get(i).getSalgsannoncer().get(j));
            }
        }

        return salgsannoncer;
    }
}
