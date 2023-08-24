package application.controller;

import application.model.*;
import storage.Storage;

import java.time.LocalDate;

public class Controller {

    public static Festival createFestival(String navn, LocalDate fraDato, LocalDate tilDato){
        Festival festival = new Festival(navn,fraDato,tilDato);
        Storage.addFestival(festival);
        return festival;
    }

    public static Frivillig createFrivillig(String navn,String mobil,int maksAntalTimer){
        Frivillig frivillig = new Frivillig(navn, mobil, maksAntalTimer);
        Storage.addFrivillig(frivillig);
        return frivillig;
    }

    public static FrivilligForening createFrivilligForening(String navn, String mobil, int maksAntalTimer, String foreningsNavn, int antalPersoner){
        FrivilligForening frivilligForening = new FrivilligForening(navn, mobil, maksAntalTimer, foreningsNavn, antalPersoner);
        Storage.addFrivillig(frivilligForening);
        return frivilligForening;
    }

    public static Vagt tagVagt(Job job, Frivillig frivillig, int timer){
        Vagt vagt = null;
        try {
            if(job.ikkeBesatTimer()>timer && frivillig.ledigeTimer()>timer){
                vagt = job.createVagt(timer,frivillig);
            }

        }catch (Exception e){
            System.out.println("Wups! Der opstod en fejl. Prøv igen.");
        }
        return vagt;
    }

    public static void initStorage(){
        Festival festival1 = createFestival("Northside", LocalDate.of(2020,06,04),LocalDate.of(2020,06,06));

        Frivillig fri1 = createFrivillig("Jane Jensen","12121212",20);
        Frivillig fri2 =createFrivillig("Lone Jensen","12121212",25);
        Frivillig fri3 =createFrivillig("Anders Jensen","12121212",10);

        FrivilligForening friFor1 =createFrivilligForening("Christian Nielsen","23232323",100,"EAA",40);

        festival1.createJob("T1","Rengøring af toilet",LocalDate.of(2020,06,04),100,5);
        festival1.createJob("T2","Rengøring af toilet",LocalDate.of(2020,06,04),100,5);
        festival1.createJob("T3","Rengøring af toilet",LocalDate.of(2020,06,04),100,5);
        festival1.createJob("T4","Rengøring af toilet",LocalDate.of(2020,06,05),100,5);
        festival1.createJob("T5","Rengøring af toilet",LocalDate.of(2020,06,05),100,5);
        festival1.createJob("T6","Rengøring af toilet",LocalDate.of(2020,06,05),100,5);
        festival1.createJob("T7","Rengøring af toilet",LocalDate.of(2020,06,06),100,5);
        festival1.createJob("T8","Rengøring af toilet",LocalDate.of(2020,06,06),100,5);
        festival1.createJob("T9","Rengøring af toilet",LocalDate.of(2020,06,06),100,5);

    }
}
