package spaggethiOpgave.palindrom;

public class PalindromValidator implements PalindromValidatorI {

    @Override
    public boolean erGyldigtPalindrom(String tekst) {
        boolean result = false;
        System.out.println(tekst);
        String tekst1 = tekst.replaceAll("[-+.^:,?!()]","");
        String tekst2 = tekst1.toLowerCase();
        String tekst3 = tekst2.replaceAll("\\s+","");
        System.out.println(tekst3);

        for (int i = 0; i < tekst1.length()/2; i++) {
            if(tekst3.charAt(i)==tekst3.charAt(tekst3.length()-i-1)){
                result = true;
            } else {
                result = false;
            }
        }

        return result;
    }

    @Override
    public boolean erGyldigtPalindromPrimtal(int tal) {
        return false;
    }
}
