import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Opg6 {

    public static void main(String[] args) throws IOException {

        System.out.println(max("tal2.txt"));
        System.out.println(min("tal2.txt"));
        System.out.println(gennemsnit("tal2.txt"));


        System.out.println(max("tal3.txt"));
        System.out.println(min("tal3.txt"));
        System.out.println(gennemsnit("tal3.txt"));


    }

    public static int max(String filename) throws IOException{
        int max = 0;

        File filein = new File(filename);

        try (Scanner scan = new Scanner(filein)){
            while (scan.hasNext()) {
                if(Integer.parseInt(scan.nextLine())>max){
                    max=Integer.parseInt(scan.nextLine());
            }}
            scan.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return max;
    }

    public static int min(String filename) throws IOException{
        int min = 99999;

        File filein = new File(filename);

        try (Scanner scan = new Scanner(filein)){
            while (scan.hasNext()) {
                if(Integer.parseInt(scan.nextLine())<min){
                    min=Integer.parseInt(scan.nextLine());
                }}
            scan.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return min;
    }

    public static double gennemsnit(String filename) throws IOException{
        double gennemsnit = 0;
        int sum = 0;
        int count = 0;

        File filein = new File(filename);

        try (Scanner scan = new Scanner(filein)){
            while (scan.hasNext()) {
                sum+=Integer.parseInt(scan.nextLine());
                count++;
                }
            gennemsnit = sum/count;
            scan.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return gennemsnit;
    }

}
