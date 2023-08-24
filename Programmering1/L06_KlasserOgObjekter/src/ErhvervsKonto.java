public class ErhvervsKonto extends Konto{

    private int bonus;

    public ErhvervsKonto (int nr1, String indehaver1, int saldo1,int bonus1){
        super(nr1, indehaver1,saldo1);

        this.bonus=bonus1;
    }

    public ErhvervsKonto(){
        this(0,"Ukendt indehaver",0,0);
    }

    @Override
    public void udskrivKonto() {
        super.udskrivKonto();

        System.out.println("Bonus ligger på: " + bonus + " kr. om året");
    }
}

