package Opg4;

import java.io.File;
import java.util.Scanner;

public class App4 {
    public static void main(String[] args) {
        System.out.println(linFileSearch("C:\\Garbage\\talfil.txt",219));
        System.out.println(linFileSearch("C:\\Garbage\\talfil.txt",100));
        System.out.println(linFileSearch("C:\\Garbage\\talfil.txt",1284));

        //Kvalitet
    }

    public static boolean linFileSearch(String fileName, int target){
        File filein = new File(fileName) ;
        boolean result = false;

        try {
            Scanner scanner = new Scanner(filein);
            while(scanner.hasNext()){
                if(scanner.nextInt()==target){
                    result=true;
                }
            }
        }catch (Exception e){
            System.out.println("Wuups");
        }

        return result;
    }

}
