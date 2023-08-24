package Del1.Opg3;

import java.util.ArrayList;

public class Rental {
    private int number;
    private int days;
    private String date;
    private ArrayList<Car> cars = new ArrayList();

    public Rental(int number,String date,int days){
        this.number=number;
        this.date=date;
        this.days=days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public void addCar (Car car){
        cars.add(car);
    }

    public void removeCar (Car car){
        cars.remove(car);
    }

    public ArrayList<Car> getCars (){
        return new ArrayList<>(cars);
    }

    public double getPrice(){
        double resultPrice;
        double pricePerDay=0;

        for (int i = 0; i <cars.size(); i++) {
            pricePerDay =+ cars.get(i).getPricePerDay();
        }

        resultPrice = pricePerDay*days;

        return resultPrice;
    }
}
