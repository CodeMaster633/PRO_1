public class MainName {

    public static void main(String[] args) {
        Name name1 = new Name("Jens","Jensbakkesen");
        Name name2 = new Name("Jens","Jensen","Jensbakkesen");

        System.out.println(name1.getFullName());

        System.out.println(name2.getFullName());

        System.out.println(name2.getUsername());

    }
}
