public class IntroTing {

    //void uden return
    public static void udskriv1_10() {
        int i = 1;
        while(i<=10){
            System.out.println(i);
            i++;
        }
    }

    //int med return
    public static int summer(int n){
        int sum =0;
        int i = 1;
        while (i<=n){
            sum = sum + i;
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        udskriv1_10();
        System.out.println(summer(10));
    }

}
