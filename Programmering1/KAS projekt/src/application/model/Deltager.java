package application.model;

public class Deltager {
    private String navn;
    private String adresse;
    private String telefonNr;
    private String land;
    private Konference konference;

    public Deltager(String navn, String adresse, String telefonNr, String land, Konference konference) {
        this.navn = navn;
        this.adresse = adresse;
        this.telefonNr = telefonNr;
        this.land = land;
        this.konference = konference;
    }

    public Konference getKonference() {return konference;}

    public void setKonference(Konference konference) {this.konference = konference;}

    public String getNavn() { return navn;
    }

    @Override
    public String toString() {
        return ""+navn;
    }
}
