package Opg1;

public class Customer implements Comparable<Customer> {

    private String navn;

    public Customer (String navn){
        this.navn=navn;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return ""+navn;
    }

    @Override
    public int compareTo(Customer o) {
        return this.navn.compareTo(o.navn);
    }
}
