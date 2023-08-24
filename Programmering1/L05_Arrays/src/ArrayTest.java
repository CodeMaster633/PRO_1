import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int ift[] = {4,6,7,2,3};
        int b[] = {4,6,8,2,6};
        int c[] = {4,6,8,2,6,3,9};

        double iftDouble[] = {4.1,6.4,7.8,2.0,3.2};

//        System.out.println(sum(ift));
//        System.out.println(sumDouble(iftDouble));
//        System.out.println(Arrays.toString(sumArrays(ift,b)));
//        System.out.println(Arrays.toString(sumArraysUnequal(ift,c)));
        System.out.println(hasUneven(ift));
        System.out.println(hasUneven(b));
    }


    //Opg 2
    public static int sum(int[] t){
        int sum = 0;
        for(int i = 0; i<t.length; i++){
            sum = sum+t[i];
        }
        return sum;
    }

    public static double sumDouble(double[] t){
        double sum = 0;
        for(int i = 0; i<t.length; i++){
            sum = sum+t[i];
        }
        return sum;
    }


    //Opg 3
    public static int[] sumArrays(int[] a, int[] b){

        if(a.length>b.length){
            int[] longestArray = a;
        } else {
            int[] longestArray = b;
        }

        int[] sum = new int[a.length];
        for(int i = 0; i<a.length; i++){
            sum[i] = a[i]+b[i];
        }
        return sum;
    }
    public static int[] sumArraysUnequal(int[] a, int[] b){
        int[] longestArray = new int[0];
        int[] shortestArray = new int[0];

        if(a.length>b.length){
            longestArray = a;
            shortestArray = b;
        } else {
            longestArray = b;
            shortestArray = a;
        }

        int[] sum = new int[longestArray.length];
        for(int i = 0; i<longestArray.length; i++){
            if(i<shortestArray.length) {
                sum[i] = longestArray[i] + shortestArray[i];
            } else {
                sum[i] = longestArray[i];
            }
            }

        return sum;
    }

    //Opg4
    public static boolean hasUneven(int[] t){
        boolean result = false;
        for(int i = 0; i<t.length; i++){
            if(t[i]%2==1){
                result = true;
            }
        }
        return result;
    }

}
