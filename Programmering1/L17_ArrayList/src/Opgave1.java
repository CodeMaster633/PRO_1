import java.util.ArrayList;
import java.util.Collections;

public class Opgave1 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("Hans");
        names.add("Viggo");
        names.add("Jens");
        names.add("Bente");
        names.add("Bent");

        System.out.println(names.size());

        names.add(2,"Jane");

        System.out.println(names);

        names.remove(1);

        names.add(0,"Pia");

        names.add("Ib");

        System.out.println(names.size());

        names.set(2,"Hansi");

        System.out.println(names.size());

        System.out.println(names);

        for (int i = 0; i <names.size() ; i++) {
//            String name = names.get(i);
            System.out.println(names.get(i).length());
        }

        System.out.println();

        for (String name : names){
            System.out.println(name.length());
        }




    }
}





//    ArrayList collection = new ArrayList<String>();
//
//        collection.add("Hej");
//
//        collection.add("du!");
//
//        System.out.println(collection.get(0) +" "+ collection.get(1));
//        System.out.println(collection.size());
//
//        collection.set(0,"Godaw");
//        collection.add("Whazzup");
//
//        System.out.println(collection);
//
//        ArrayList<Integer> myList = new ArrayList<Integer>();
//
//        myList.add(12);
//        myList.add(76);
//        myList.add(44);
//
//        System.out.println(myList);
//
//        for (int i:myList){
//            System.out.println(i);
//        }
//
//        Collections.sort(myList);
//        System.out.println(myList);
//
//
//        collection.add(0,"heeh");
//        System.out.println(collection);
//
//        collection.remove(0);
//
//        System.out.println(collection);
//

