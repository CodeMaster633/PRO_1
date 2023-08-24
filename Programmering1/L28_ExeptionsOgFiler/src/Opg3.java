import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Opg3 {

    public static void main(String[] args) {
        File filein = new File("C:\\Garbage\\Filer_Opg4.txt");
        ArrayList<Integer> tal = new ArrayList<>();

        try (Scanner scan = new Scanner(filein)){
            while (scan.hasNext()) {
                tal.add(Integer.parseInt(scan.nextLine()));
            }
            System.out.println(tal);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < tal.size(); i++) {
            System.out.println(tal.get(tal.size()-i-1));
        }
        }
    }

