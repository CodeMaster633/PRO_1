public class Opgave2 {
    public static void main(String[] arg) {
    String ord1 = "Datamatiker";
    String ord2 = "Uddannelsen";

    //a)
        System.out.println(ord1.toUpperCase());

    //b)
        System.out.println(ord2.toLowerCase());
        //c)
        System.out.println(ord1 + " " + ord2);
        //d)
        String ord3 = ord1 + ord2.toLowerCase();
        System.out.println(ord3);
        //e)
        System.out.println(ord3.length());
        //f)
        System.out.println(ord1.charAt(0));
        System.out.println(ord1.charAt(1));
        System.out.println(ord1.charAt(2));
        System.out.println(ord1.charAt(3));
        System.out.println(ord1.charAt(4));
        System.out.println(ord1.charAt(5));
        System.out.println(ord1.charAt(6));
        //g)
        System.out.println(ord1.charAt(2));
        System.out.println(ord1.charAt(3));
        System.out.println(ord1.charAt(4));
        System.out.println(ord1.charAt(5));
        System.out.println(ord1.charAt(6));
        //e)
        System.out.println(ord3.replace("Datamatiker",""));
    }
}
