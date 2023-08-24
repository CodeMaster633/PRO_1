package application.model;

import javax.xml.transform.Result;
import java.util.ArrayList;

public class Frivillig {

    private String navn;
    private String mobil;
    private int maksAntalTimer;
    private ArrayList<Vagt> vagter = new ArrayList<>();
    public Frivillig (String navn,String mobil,int maksAntalTimer){
        this.navn=navn;
        this.maksAntalTimer=maksAntalTimer;
        this.mobil=mobil;
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public int getMaksAntalTimer() {
        return maksAntalTimer;
    }

    public ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    public void addVagt(Vagt vagt) {
        if (!vagter.contains(vagt)) {
            vagter.add(vagt);
            vagt.setFrivillig(this);
        }
    }

    public void removeVagt(Vagt vagt) {
        if (vagter.contains(vagt)) {
            vagter.remove(vagt);
            vagt.setFrivillig(null);
        }
    }

    public int ledigeTimer(){
        int result = maksAntalTimer;

        for (int i = 0; i < vagter.size(); i++) {
            result-=vagter.get(i).getTimer();
        }

        return result;
    }

//    public int antalFrivillige(){
//        int result = 1;
//
//        if(this==FrivilligForening){
//
//        }
//    }
}
