public class Opgave7 {
    // Underviser madpakker til børn

    // Del 1: Gennemsnitsalder

    public static void main(String[] args) {

        double gennemsnitDreng = (6+6+8)/3.0;
        double gennemsnitPige = (15+16+18)/3.0;
        double gennemsnitSamlet = (gennemsnitDreng+gennemsnitPige)/2.0;

        System.out.println("\nGennemsnitsalder for drengene: " + gennemsnitDreng);
        System.out.println("Gennemsnitsalder for pigerne: " + gennemsnitPige);
        System.out.println("Gennemsnitsalder for børne: " + gennemsnitSamlet);

        //Del 2: Madpakker smurt til nytår underviser

        double madÅrEnPerson = 2*200;
        double startAlder = 1;
        double barn1 = (6-startAlder+0.5)*madÅrEnPerson;
        double barn2 = (6-startAlder+0.5)*madÅrEnPerson;
        double barn3 = (8-startAlder+0.5)*madÅrEnPerson;
        double barn4 = (15-startAlder-5)*madÅrEnPerson;
        double barn5 = (16-startAlder-6)*madÅrEnPerson;
        double barn6 = (18-startAlder-8)*madÅrEnPerson;

        double smurtIAlt = barn1+barn2+barn3+barn4+barn5+barn6;

        System.out.println( "\nMadpakker smurt af underviser i alt: " + smurtIAlt);

        //Del 3: Madpakker smurt til nytår børn

        double stortBarn1 = (15-10+0.5)*madÅrEnPerson;
        double stortBarn2 = (16-10+0.5)*madÅrEnPerson;
        double stortBarn3 = (18-10+0.5)*madÅrEnPerson;

        double børnSmurtIAlt = stortBarn1+stortBarn2+stortBarn3;

        System.out.println("\nMadpakker smurt af børn i alt: " + børnSmurtIAlt);

    }
}
