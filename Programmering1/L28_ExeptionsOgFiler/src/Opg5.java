import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Opg5 {

    public static void main(String[] args) {

        String fileName = "C:\\Garbage\\Filer_Opg5.txt";

        try {
            PrintWriter printWriter = new PrintWriter(fileName);

            boolean active = true;
            Scanner scan = new Scanner(System.in);
            System.out.println("Tilføj tal til listen. Indtast -1 for at afslutte.");

            while (active) {
                System.out.print("Tilføj nyt tal: ");
                int tal = scan.nextInt();
                if (tal == -1) {
                    scan.close();
                    active = false;
                } else {
                    printWriter.println(tal);
                }
            }

            printWriter.close();
            System.out.println("Filen er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
