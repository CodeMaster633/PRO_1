package Opgaver;

import model.Customer;

import java.util.ArrayList;

public class Opg2 {

    public static void main(String[] args) {
        String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};

        selectionSort(s);
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

        selectionSortCustomer(list);

        System.out.println(list);


    }

    private static void swap(String[] list, int i, int j) {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    private static void swapCustomer(ArrayList<Customer> list, int i, int j) {
        Customer temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }

    public static void selectionSort(String[] list) {
        for (int i = 0; i < list.length; i++) {
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j].compareTo(list[currentMinIndex])<0) {
                    currentMinIndex = j;
                }
            }
            swap(list, i, currentMinIndex);
        }
    }

    public static void selectionSortCustomer(ArrayList<Customer> list) {
        for (int i = 0; i < list.size(); i++) {
            int currentMinIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getFirstName().compareTo(list.get(currentMinIndex).getFirstName())<0) {
                    currentMinIndex = j;
                }
            }
            swapCustomer(list, i, currentMinIndex);
        }
    }
}
