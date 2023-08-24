//import com.sun.jdi.VMDisconnectedException;
import java.util.Scanner;

public class Opgave7_30 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of values: ");
        int amount = input.nextInt();

        System.out.print("Enter the values: ");
        String values = (input.next());
        int[] arr = new int[amount];

        for(int i = 0; i<amount; i++){
            arr[i] = values.charAt(i);
        }
        isConsecutiveFour(arr);
    }

    public static void isConsecutiveFour(int[] arr){

        int repetitions = 1;
        int lastNumber = 0;

        for(int j = 0; j<arr.length; j++){
            if(arr[j]==lastNumber){
                repetitions=repetitions+1;

            } else {
                lastNumber=arr[j];
            }
        }

        if(repetitions==4){
            System.out.println("The list has consecutive four");
        } else {
            System.out.println("The list has no consecutive four");
        }
    }
}
