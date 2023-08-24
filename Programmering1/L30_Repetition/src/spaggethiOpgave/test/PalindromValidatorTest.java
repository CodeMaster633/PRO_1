package spaggethiOpgave.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spaggethiOpgave.palindrom.PalindromValidator;
import spaggethiOpgave.palindrom.PalindromValidatorI;

class PalindromValidatorTest
{
    ArrayList<String> palindromer;
    ArrayList<Integer> palindromprimtal;

    @BeforeEach
    void setUp() throws Exception
    {
        palindromer = new ArrayList<String>();

//        URL url = getClass().getResource("test-palindrom.txt");
        File palindromTxt = new File("C:\\Datamatiker Uddannelse\\1. Semester\\PRO\\Programmering1\\L30_Repetition\\src\\spaggethiOpgave\\test\\test-palindrom.txt");
        Scanner palindromScanner = new Scanner(palindromTxt);
        while (palindromScanner.hasNextLine())
        {
            String data = palindromScanner.nextLine();
            palindromer.add(data);
        }
        palindromScanner.close();

        palindromprimtal = new ArrayList<Integer>();

//        url = getClass().getResource("test-palindrom-primtal.txt");
        palindromTxt = new File("C:\\Datamatiker Uddannelse\\1. Semester\\PRO\\Programmering1\\L30_Repetition\\src\\spaggethiOpgave\\test\\test-palindrom-primtal.txt");
        palindromScanner = new Scanner(palindromTxt);
        while (palindromScanner.hasNextLine())
        {
            String data = palindromScanner.nextLine();
            palindromprimtal.add(Integer.parseInt(data));
        }
        palindromScanner.close();
    }

    @Test
    void test(){

        PalindromValidatorI palindromValidator = new PalindromValidator();
        for(String palindrom : palindromer){
            assertTrue(palindromValidator.erGyldigtPalindrom(palindrom));
        }

//        fail("Not yet implemented");
    }

}
