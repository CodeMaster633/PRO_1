package Opg1;

public class App {
    public static void main(String[] args) {
        int[] arr = {3,5,6,7,8};
        int[] arr2 = {2,4,6,10,8};

        System.out.println(unevenNumber(arr));
        System.out.println(unevenNumber(arr2));
    }
    public static boolean unevenNumber(int[] list){
        boolean uneven = false;
        for (int i = 0; i < list.length; i++) {
            if(list[i]%2!=0){
                uneven=true;
            }
        }
        return uneven;
    }
}
