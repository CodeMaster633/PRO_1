package rep2.application.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Salgsannonce {

    private static int antalAnnoncer;
    private int annonceNummer = 1;
    private boolean aktiv;
    private LocalDate udløbsdato;
    private final ArrayList<Vare> varer = new ArrayList<>();
    private Sælger sælger;

    public Salgsannonce(Sælger sælger,ArrayList<Vare> varer) {
        this.annonceNummer = antalAnnoncer;
        this.antalAnnoncer++;
        this.aktiv = true;
        this.udløbsdato = LocalDate.now().plusMonths(1);
        this.sælger = sælger;
        for (int i = 0; i < varer.size(); i++) {
            this.varer.add(varer.get(i));
        }
    }

    public ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    public Sælger getSælger() {
        return sælger;
    }

    public int getAnnonceNummer() {
        return annonceNummer;
    }

    public int getAntalAnnoncer() {
        return antalAnnoncer;
    }

    public boolean getAktiv() {
        return aktiv;
    }

    public LocalDate getUdløbsdato() {
        return udløbsdato;
    }

    public void addVare(Vare vare) {
        if (!varer.contains(vare)) {
            varer.add(vare);
            vare.setSalgsannonce(this);
        }
    }

    public void removeVare(Vare vare) {
        if (varer.contains(vare)) {
            varer.remove(vare);
            vare.setSalgsannonce(null);
        }
    }

    public int samletAnnonceUdbud() {
        int result = 0;

        for (int i = 0; i < varer.size(); i++) {
            result+=varer.get(i).getUdbudspris();
        }

        return result;
    }

    public void opdaterSalgsannonce(){
        int count = 0;
        boolean udløbet = false;

        for (Vare vare : varer) {
            if (vare.getSolgt()) {
                count++;
            }
        }

        if(this.udløbsdato==LocalDate.now()){
            udløbet = true;
        }

        if(count==varer.size() || udløbet){
            this.aktiv=false;
        }
    }

    @Override
    public String toString() {
        return ""+ sælger.getNavn()+" "+udløbsdato;
    }
}
