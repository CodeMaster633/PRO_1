package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Festival {

    private String navn;
    private LocalDate fraDato;
    private  LocalDate tilDato;
    private ArrayList<Job> jobs = new ArrayList<>();

    public Festival (String navn, LocalDate fraDato, LocalDate tilDato){
        this.navn=navn;
        this.fraDato=fraDato;
        this.tilDato=tilDato;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }

    public ArrayList<Job> getJobs() {
        return new ArrayList<>(jobs);
    }

    public Job createJob(String kode,String beskrivelse, LocalDate dato, int timeHonorar,int antalTimer){
       Job job = new Job(kode,beskrivelse,dato,timeHonorar,antalTimer);
       jobs.add(job);
        return job;
    }

    public int budgetteretJobUdgift(){
        int result = 0;

        for (int i = 0; i < jobs.size(); i++) {
            result+=(jobs.get(i).getAntalTimer()*jobs.get(i).getTimeHonorar());
        }

        return result;
    }

    public int realiseretJobUdgift(){
        int result = 0;

        for (int i = 0; i < jobs.size(); i++) {
            for (int j = 0; j < jobs.get(i).getVagter().size(); j++) {
                result+=(jobs.get(i).getVagter().get(j).getTimer());
            }
        }

        return result;
    }

    public ArrayList<String> gaverTilFrivillige(){
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < jobs.size(); i++) {
            for (int j = 0; j < jobs.get(i).getVagter().size(); j++) {
                Frivillig frivillig = jobs.get(i).getVagter().get(j).getFrivillig();
                result.add(frivillig.getNavn() + " 1");
                }
            }
        //Mangler noget

        return result;
    }
}
