public class PrivatKonto extends Konto{

    private int rente;

    public PrivatKonto (int nr1, String indehaver1, int saldo1,int rente1){
        super(nr1, indehaver1,saldo1);

        this.rente=rente1;
    }

    public PrivatKonto(){
        this(0,"Ukendt indehaver",0,0);
    }

    @Override
    public void udskrivKonto() {
        super.udskrivKonto();

        System.out.println("Renten er: " + rente + " % om året");
    }
}
