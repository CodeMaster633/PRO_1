package modelwhile;

import java.util.Scanner;

public class Opgave1 {

    //LøkkeOpgaver
    public static void main(String[] args) {

        //Modtag input
        /*
        Scanner input = new Scanner(System.in);
        System.out.print("The amount invested: ");
        int amount = input.nextInt();

        System.out.print("Annual interest rate: ");
        double rate = (input.nextInt())/100.0;
        //double rate = 0.09;

        System.out.println(futureInvestmentValue2(amount,rate,30));

         */

//        Kald af metoder der afprøver opgave 1

        // System.out.println(summerEven(100));
        // System.out.println(summerSquare(10));
        //System.out.println(sumOdd(3, 19));
        // allPowers(20);
        //  System.out.println(sumDigits(234));
        // System.out.println(sumOddDigits(32677));
        //System.out.println(reverse(3456));
        //System.out.println(reverse(number));
        //System.out.println(futureInvestmentValue(10000,0.05/12,5));
    }

    // Metoden returnerer summen af alle lige tal mellem 2 og n
    public static int summerEven(int n) {
        int i = 2;
        int sum = 0;
        while (i <= n) {
            if (i % 2 == 0) {
                sum += i;
            }
            i++;
        }
        return sum;
    }

    // Metoden returnerer summen af alle kvdrater mellem 1*1 og n*n
    public static int summerSquare(int n) {
        int i = 0;
        int sum = 0;
        while (i <= n) {
            sum = sum + i * i;
            i++;
        }

        return sum;
    }

    // Metoden returnerer summen af alle ulige tal mellem a og b
    public static int sumOdd(int a, int b) {
        int i = a;
        int sum = 0;
        while (i <= b) {
            if (i % 2 != 0) {
                sum = sum + i;
            }
            i++;
        }
        return sum;
    }

    // Metoden udskriver 2 potenser fra  f
    public static void allPowers(int n) {
        int i = 0;
        int result = 0;
        while (i <= n) {
            if (i == 0) {
                result = result + 1;
                System.out.println(result);
            } else if (i == 1) {
                result = result + 1;
                System.out.println(result);
            } else {
                result = result * 2;
                System.out.println(result);
            }
            i++;
        }

    }

    public static int sumDigits(int n) {
        int sum = 0;

        while (n > 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static int sumOddDigits(int n) {
        int sum1 = 0;
        int sum2 = 0;
        int a = 0;

        while (n > 0) {

            a = n % 10;
            n = n / 10;

            if (a % 2 != 0) {
                sum2 = sum2 + a;
            }
        }
        return sum2;
    }

    public static int reverse(int n) {
        int i = 0;
        int length = (int) (Math.log10(n));
        int revNum = 0;

        while (i <= length) {
            revNum = (revNum*10) + n % 10;
            n = n / 10;
            i++;
        }

        return revNum;
    }
    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years){

        double futureInvestmentValue = investmentAmount*Math.pow((1+monthlyInterestRate),(years*12));

        return futureInvestmentValue;
    }
    public static double futureInvestmentValue2(double investmentAmount, double monthlyInterestRate, int years){



        double futureInvestmentValue = investmentAmount*Math.pow((1+monthlyInterestRate),(years+1));

        return futureInvestmentValue;
    }


}