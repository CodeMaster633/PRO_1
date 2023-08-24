import java.util.Scanner;

public class Opgave2 {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    //Modtag input
    System.out.print("Enter an integer: ");
    int number = input.nextInt();

    //Selektion
    if(number<0) {
        System.out.println("The number is negative");
    }
    else if(number==0){
        System.out.println("The number is neutral");
    }
    else if (number > 0){
        System.out.println("The number is positive");
    }

}
}
