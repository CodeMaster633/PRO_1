package Opg2;

public class Gift {
    private String description;
    private double price;
    private Person person;

    public Gift(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPerson(Person person) {
        if (this.person != person) {
            this.person = person;
        }
    }

    public Person getPerson() {
        return person;
    }
}
