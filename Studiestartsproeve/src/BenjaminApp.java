import java.util.Scanner;

public class BenjaminApp {

    public static void main(String[] args) {
        Scanner create = new Scanner(System.in);
        System.out.println("Indtast navn: ");
        String name = create.next();
        System.out.println("Indtast løn: ");
        int løn = Integer.parseInt(create.next());
        System.out.println("Indtast alder: ");
        int alder = Integer.parseInt(create.next());

        double nyLøn = 0;

        if(alder>=50){
            nyLøn=løn*1.1;
        } else if(alder<35){
            nyLøn=løn*1.05;
        } else {
            nyLøn=løn*1.08;
        }

        System.out.println("Din nye løn er: " + nyLøn + "kr.");
    }
}
