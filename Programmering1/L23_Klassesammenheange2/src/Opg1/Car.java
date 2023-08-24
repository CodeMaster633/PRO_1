package Opg1;

import java.util.ArrayList;

public class Car {
    private String license;
    private double pricePerDay;
    private int purchaseYear;
    private ArrayList<Rental> rentals = new ArrayList();


    public Car(String license, int year) {
        this.license = license;
        this.purchaseYear = year;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public String getLicense() {
        return license;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }

    public void addRental (Rental rental){
        if(!rentals.contains(rental)) {
            rentals.add(rental);
            rental.addCar(this);
        }
    }

    public void removeRental (Rental rental){
        if(rentals.contains(rental)) {
            rentals.remove(rental);
            rental.removeCar(this);
        }
    }

    public ArrayList<Rental> getRentals (){
        return new ArrayList<>(rentals);
    }

    public int longestRental(){
        int resultDays = 0;

        for (int i = 0; i < rentals.size(); i++) {
            if(rentals.get(i).getDays()>resultDays){
                resultDays=rentals.get(i).getDays();
            }
        }
        
        return resultDays;
    }
}
