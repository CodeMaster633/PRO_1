package application.model;

public class FrivilligForening extends Frivillig {

    private String foreningsNavn;
    private int antalPersoner;

    public FrivilligForening(String navn, String mobil, int maksAntalTimer, String foreningsNavn, int antalPersoner) {
        super(navn, mobil, maksAntalTimer);
        this.antalPersoner = antalPersoner;
        this.foreningsNavn = foreningsNavn;
    }

    public String getForeningsNavn() {
        return foreningsNavn;
    }

    public int getAntalPersoner() {
        return antalPersoner;
    }
}
