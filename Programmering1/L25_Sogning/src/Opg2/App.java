package Opg2;

public class App {
    public static void main(String[] args) {
        int[] arr = {3,5,6,7,8};
        int[] arr2 = {2,4,6,10,11};

        System.out.println(findNumber(arr));
        System.out.println(findNumber(arr2));
    }
    public static int findNumber(int[] list){
        int result = -1;
        for (int i = 0; i < list.length; i++) {
            if(list[i] == 10 || list[i]==11 || list[i]==12 || list[i]==13 || list[i]==14 || list[i]==15){
                if(result==-1) {
                    result = list[i];
                }
            }
        }
        return result;
    }
}
