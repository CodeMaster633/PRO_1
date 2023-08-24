

public class Konto {

    private int nr;
    private String indehaver;
    private int saldo;

    public Konto (int nr1, String indehaver1, int saldo1){
        this.nr=nr1;
        this.indehaver=indehaver1;
        this.saldo=saldo1;
    }

    public Konto(){
        this(0,"Ukendt indehaver",0);
    }

    public void udskrivKonto(){
        System.out.println("...................");
        System.out.println("Kontonummer: " + nr);
        System.out.println("Indehaver: " + indehaver);
        System.out.println("Saldo: " + saldo + " kr.");

    }
}
