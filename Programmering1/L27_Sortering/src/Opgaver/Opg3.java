package Opgaver;

import model.Customer;

import java.util.ArrayList;

public class Opg3 {

    public static void main(String[] args) {
        String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};

        insertioneSort(s);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
        System.out.println();

        ArrayList<Customer> list = new ArrayList<>();
        Customer c1 = new Customer("Nielsen", "Mikkel",28);
        Customer c2 = new Customer("Jensen", "Åicolai",26);
        Customer c3 = new Customer("Gregersen", "Aoshan",24);

        list.add(c1);
        list.add(c2);
        list.add(c3);

        System.out.println(list);

        insertioneSortCustomer(list);

        System.out.println(list);


    }
    public static void insertioneSort(String[] list) {
        for (int i = 1; i < list.length; i++) {
            String currentElement = list[i];
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (currentElement.compareTo(list[j - 1]) >0) {
                    found = true;
                } else {
                    list[j] = list[j - 1];
                    j--;
                }
            }
            list[j] = currentElement;
        }
    }

    public static void insertioneSortCustomer(ArrayList<Customer> list) {
        for (int i = 1; i < list.size(); i++) {
            Customer currentElement = list.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (currentElement.getFirstName().compareTo(String.valueOf(list.get(j-1))) >0) {
                    found = true;
                } else {
                    list.set(j,list.get(j-1));
                    j--;
                }
            }
            list.set(j,currentElement);
        }
    }
}
