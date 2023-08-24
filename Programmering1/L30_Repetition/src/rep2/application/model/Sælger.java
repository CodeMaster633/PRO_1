package rep2.application.model;

import org.junit.platform.commons.util.ReflectionUtils;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sælger {
    private String navn;
    private int studiekortNummer;
    private String mobil;
    private ArrayList<Salgsannonce> salgsannoncer = new ArrayList<>();

    public Sælger(String navn, int studiekortNummer, String mobil) {
        this.navn = navn;
        this.studiekortNummer = studiekortNummer;
        this.mobil = mobil;
    }

    public String getNavn() {
        return navn;
    }

    public int getStudiekortNummer() {
        return studiekortNummer;
    }

    public String getMobil() {
        return mobil;
    }

    public ArrayList<Salgsannonce> getSalgsannoncer() {
        return new ArrayList<>(salgsannoncer);
    }

    public Salgsannonce createSalgsannonce(Sælger sælger,ArrayList<Vare> varer) {
        Salgsannonce salgsannonce = new Salgsannonce(this,varer);
        salgsannoncer.add(salgsannonce);
        return salgsannonce;
    }

    public void addSalgsannonce(Salgsannonce salgsannonce) {
        if (!salgsannoncer.contains(salgsannonce)) {
            salgsannoncer.add(salgsannonce);
        }
    }

    public void removePerson(Salgsannonce salgsannonce) {
        if (salgsannoncer.contains(salgsannonce)) {
            salgsannoncer.remove(salgsannonce);
        }
    }

   public ArrayList<Vare> alleIkkesolgteVarerIKategori(Varekategori kategori){
      ArrayList<Vare> resultat = new ArrayList<>();

       for (int i = 0; i < salgsannoncer.size(); i++) {
           for (int j = 0; j < salgsannoncer.get(i).getVarer().size(); j++) {
               Vare vare = salgsannoncer.get(i).getVarer().get(j);
               if(salgsannoncer.get(i).getAktiv()) {
                   if (vare.getSolgt() == false) {
                       if (vare.getKategori() == kategori) {
                           resultat.add(vare);
                       }
                   }
               }
           }
       }
      
       return resultat;
    }
}
