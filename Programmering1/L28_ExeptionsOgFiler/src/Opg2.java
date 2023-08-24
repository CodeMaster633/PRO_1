import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Opg2 {

    public static void main(String[] args) {
        File filein = new File("C:\\Garbage\\Filer_Opg2.txt");

        try (Scanner scan = new Scanner(filein);){
            while (scan.hasNext()) {
                int result = Integer.parseInt(scan.nextLine())*2;
                System.out.println(result);
            }
            scan.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
