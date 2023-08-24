import java.util.Arrays;

public class Opgave1 {
    public static void main(String[] args) {
        int[] a = {0,0,0,0,0,0,0,0,0,0};
        int[] b = {2,44,-23,99,8,-5};

        int[] c = new int[10];
//        for(int i = 0;i<c.length;i++){
//            c[i] = i;
//        }
//        System.out.println(Arrays.toString(c));

        int[] d = new int[10];
        int value = 2;
        for(int i = 0;i<d.length;i++){
            d[i] = value;
            value=value +2;
        }
//        System.out.println(Arrays.toString(d));

        int[] e = new int[10];
//        int j = 0;
        for(int i = 0;i<10;i++){
            e[i] = i*i;
//            if(i%2!=0){
//                j++;
//            }
        }
//        System.out.println(Arrays.toString(e));

        int[] f = new int[10];
        for(int i = 0;i<f.length;i++){
            if(i%2!=0){
            f[i] = 1;
            }
        }
//        System.out.println(Arrays.toString(f));

        int[] g = new int[10];
        int k = 0;
        for(int i = 0;i<g.length;i++){
            g[i] = k;
            k++;
            if(i==4){
                k = 0;
            }
        }
//        System.out.println(Arrays.toString(g));

        int[] h = new int[10];
        int y = 0;
        for(int i = 1;i<h.length;i++){
            if(i%2==0){
                y=y+1;
            } else {
                y=y+3;
            }
            h[i] = y;
        }
        System.out.println(Arrays.toString(h));


    }
}
