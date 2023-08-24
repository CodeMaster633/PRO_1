package Ex2;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Opgave2 {
        /**
         * Tests all the methods.
         */
        public static void main(String[] args) {
            ArrayList<Integer> ints = new ArrayList<>();
            ints.add(12);
            ints.add(0);
            ints.add(45);
            ints.add(7);
            ints.add(-16);
            ints.add(0);
            ints.add(23);
            ints.add(-10);
// ints.addAll(List.of(12, 0, 45, 7, -16, 0, 23, -10));
            System.out.println("ints: " + ints);
            System.out.println();
// Test of sum1() method: correct sum is 61.
            int total = sum1(ints);
            System.out.println("Sum: " + total);
// Test of sum() method: correct sum is 61.
            System.out.println("Sum: " + sum(ints));
// Test of minimum() method: correct minimum is -16.
            System.out.println("Minimum: " + minimum(ints));
// Test of maximum() method: correct maximum is 45.
            System.out.println("Maximum: " + maximum(ints));
// Test of average() method: correct average is 7.625.
            System.out.println("Average: " + average(ints));
// Test of zeroes() method: correct number of zeroes is 2.
            System.out.println("Zeroes: " + zeroes(ints));
// Test of evens() method: correct result is [12, 0, -16, 0, -10].
            System.out.println(evens(ints));

//    ArrayList<Integer> list1 = new ArrayList<>();
//            System.out.println(list1);
}

    public static int sum1(ArrayList<Integer> list) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                int number = list.get(i);
                sum += number;
            }
            return sum;
        }

        public static int sum(ArrayList<Integer> list){
            int sum = 0;

            for (int num:list){
                sum+=num;
            }
            return sum;
        }

    public static int minimum(ArrayList<Integer> list){
        int min = list.get(0);

        for (int num:list){
            if (num<min){
                min=num;
            };
        }
        return min;
    }

    public static int maximum(ArrayList<Integer> list){
        int max = list.get(0);

        for (int num:list){
            if (num>max){
                max=num;
            };
        }
        return max;
    }

    public static double average(ArrayList<Integer> list){

        double sum = sum(list);

        double ave = sum/list.size();

        return ave;
    }

    public static int zeroes(ArrayList<Integer> list){
        int amount = 0;

        for (int num:list){
            if(num==0){
                amount++;
            }
        }
        return amount;
    }

    public static ArrayList<Integer> evens(ArrayList<Integer> list){
        ArrayList<Integer> newList = new ArrayList<>();

        for (int num:list){
            if (num%2!=1){
                newList.add(num);
            };
        }
        return newList;
    }

    }
