package Opg1;

import java.util.ArrayList;
import java.util.*;

public class App {

    public static void main(String[] args) {
        Customer c1 = new Customer("Benjamin");
        Customer c2 = new Customer("Mikkel");
        Customer c3 = new Customer("Nicolai");
        Customer c4 = new Customer("Lohsan");
        Customer c5 = new Customer("Børge");
        Customer c6 = new Customer("Åge");

        ArrayList<Customer> list1 = new ArrayList<>();
        list1.add(c1);
        list1.add(c4);
        list1.add(c2);
        list1.add(c3);

        ArrayList<Customer> list2 = new ArrayList<>();
        list2.add(c5);
        list2.add(c6);

        ArrayList<Customer> list3 = new ArrayList<>(fletAlleKunder(list1,list2));

        for (int i = 0; i < list3.size(); i++) {
            System.out.println(list3.get(i));
        }
    }

    public static ArrayList fletAlleKunder(ArrayList<Customer> l1, ArrayList<Customer> l2) {
        ArrayList<Customer> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        // flet sålænge der er noget i begge lister
        while (i1 < l1.size() && i2 < l2.size()) {
            if (l1.get(i1).compareTo((l2.get(i2))) <= 0) {
                // s1's første tal er mindst
                result.add(l1.get(i1));
                i1++;
            } else { // s2's første tal er mindst
                result.add(l2.get(i2));
                i2++;
            }
        }
        // tøm den liste der ikke er tom
        while (i1 < l1.size()) {
            result.add(l1.get(i1));
            i1++;
        }
        while (i2 < l2.size()) {
            result.add(l2.get(i2));
            i2++;
        }

        return result;
    }
}
