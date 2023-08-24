package Opg3;

import Opg1.Customer;

import java.util.ArrayList;

public class App3 {

    public static void main(String[] args) {
        Customer c1 = new Customer("Benjamin");
        Customer c2 = new Customer("Mikkel");
        Customer c3 = new Customer("Nicolai");
        Customer c4 = new Customer("Lohsan");
        Customer c5 = new Customer("Børge");
        Customer c6 = new Customer("Åge");
        Customer c7 = new Customer("Mikkel");

        ArrayList<Customer> list1 = new ArrayList<>();
        list1.add(c1);
        list1.add(c4);
        list1.add(c2);
        list1.add(c3);

        Customer[] list2 = {c5,c7,c6};

        ArrayList<Customer> list3 = new ArrayList<>(goodCustomers(list1,list2));

        for (int i = 0; i < list3.size(); i++) {
            System.out.println(list3.get(i));
        }
    }

    public static ArrayList goodCustomers(ArrayList<Customer> l1,Customer[] l2){
        ArrayList<Customer> result = l1;
        int i1 = 0;
        int i2 = 0;
        // flet sålænge der er noget i begge lister
        while (i1 < l1.size() && i2 < l2.length) {
            if (l1.get(i1).compareTo(l2[i2]) <0) {
                // s1's første tal er mindst
                i1++;
            } else if (l1.get(i1).compareTo(l2[i2]) >0){
                i2++;
            }else { // s2's første tal er mindst
                result.remove(result.get(i1));
                i1++;
                i2++;
            }
        }
        // tøm den liste der ikke er tom
//        while (i1 < l1.size()) {
//            result.add(l1.get(i1));
//            i1++;
//        }
//        while (i2 < l2.size()) {
//            result.add(l2.get(i2));
//            i2++;
//        }

        return result;
    }
}
