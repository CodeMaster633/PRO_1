import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opg4 {

    public static void main(String[] args) {
        String file = "C:/Garbage/Filer_Opg4.txt";
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("file");
        } catch (FileNotFoundException e) {
            System.out.println("Filen ikke fundet");
            throw new RuntimeException();
        }
        System.out.println("test");
        for (int i = 0; i < 100; i++) {
            if(i%2!=0){
            printWriter.println(i);
                System.out.println(i);
        }
            printWriter.close();
        }

//        try {
//            File newFile = new File(file);
//            Scanner scan = new Scanner(newFile);
//
//            while (scan.hasNext()) {
//                System.out.println(scan.nextLine());
//            }
//
//            scan.close();
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }
}
