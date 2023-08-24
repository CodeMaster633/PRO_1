package Del1.Opg3;

public class Car {
    private String license;
    private double pricePerDay;
    private int purchaseYear;

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
}
