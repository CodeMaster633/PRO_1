package Opg1;

public class App {
    public static void main(String[] args) {
        Car car1 = new Car("abc123",1999);
        Car car2 = new Car("dsa223",1998);
        Car car3 = new Car("hgf323",1997);
        Car car4 = new Car("lkj423",1996);
        Car car5 = new Car("ytr523",1995);

        Rental rental1 = new Rental(1,"1. April",7);
        Rental rental2 = new Rental(2,"14. Marts",14);

        rental1.addCar(car1);
        rental1.addCar(car2);
        rental2.addCar(car2);
        rental2.addCar(car3);

        System.out.println("Caryear: " + rental2.getCars().get(0).getPurchaseYear());

        System.out.println("Rental 1 - Rentaldays: " + car2.getRentals().get(0).getDays());
        System.out.println("Rental 2 - Rentaldays: " + car2.getRentals().get(1).getDays());

        System.out.println("Car longest rental: " + car2.longestRental());

    }
}
