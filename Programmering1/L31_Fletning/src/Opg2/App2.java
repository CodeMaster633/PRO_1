package Opg2;

import Opg1.Customer;

import java.util.ArrayList;

public class App2 {

    public static void main(String[] args) {
        int[] list1 = {2, 4, 6, 8, 10, 12, 14};
        int[] list2 = {1, 2, 4, 5, 6, 9, 12, 17};

        ArrayList<Integer> list3 = fletAlleTal(list1,list2);

        for (int i = 0; i < list3.size(); i++) {
            System.out.println(list3.get(i));
        }
    }

    public static ArrayList<Integer> fletAlleTal(int[] l1,int[] l2) {
        ArrayList<Integer> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        // flet sålænge der er noget i begge lister
        while (i1 < l1.length && i2 < l2.length) {
            if (l1[i1]<l2[i2]) {
                // s1's første tal er mindst
                i1++;
            } else if(l1[i1]>l2[i2]){
                i2++;
            } else { // s2's første tal er mindst
                result.add(l2[i2]);
                i1++;
                i2++;

            }
        }
        // tøm den liste der ikke er tom
//        while (i1 < l1.length) {
//            result.add(l1[i1]);
//            i1++;
//        }
//        while (i2 < l2.length) {
//            result.add(l2[i2]);
//            i2++;
//        }

        return result;
    }
}
