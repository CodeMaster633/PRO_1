package Opg3;

public class App {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6,6,7,7,7,8,8,9,9,9,9,10};
        int[] arr2 = {2, 4, 6, 10, 6};

        System.out.println(linearSearchArray2(arr,3));
        System.out.println(linearSearchArray2(arr2,3));
    }

    public static boolean linearSearchArray(int[] arr) {
        boolean found = false;
        int i = 1;
        while (!found && i < arr.length) {
            int k = arr[i];
            int g = arr[i - 1];
            if (k == g)
                found = true;
            else
                i++;
        }
        return found;
    }
    public static boolean linearSearchArray2(int[] arr,int n) {
        boolean found = false;
        int i = 1;
        int foundamount = 0;
        int actualNumber = 0;
        while (!found && i < arr.length) {
            int k = arr[i];
            int g = arr[i - 1];
            if (k == g && foundamount!=n) {
                actualNumber = g;
                foundamount++;
                i++;
            } else {
                i++;
            }
        }

        return foundamount==n;
    }

}

