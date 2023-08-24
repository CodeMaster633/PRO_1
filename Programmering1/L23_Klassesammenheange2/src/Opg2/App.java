package Opg2;

public class App {
    public static void main(String[] args) {
        Person p1 = new Person("Benjamin",24);
        Person p2 = new Person("Mikkel",28);


        Gift g1 = new Gift("Kage");
        g1.setPrice(200.5);
        Gift g2 = new Gift("PC");
        g2.setPrice(3000);

        p1.addGift(g1);
        p1.addGift(g2);

        System.out.println(p1);
        System.out.println("Total gift value: "+p1.giftsValue());

        g1.setPerson(p2);
        System.out.println("Given by: "+g1.getPerson());

    }
}
