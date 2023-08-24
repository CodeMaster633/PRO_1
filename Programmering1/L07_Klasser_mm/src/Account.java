import java.util.Date;
import java.time.LocalDateTime;

public class Account {

    private int id;
    private static int nextId;
    private double balance;
    private double annualInterestRate;
    private LocalDateTime dateCreated = LocalDateTime.now();
    private LocalDateTime lastTransaction;

    public Account() {
        nextId++;
        id = nextId;

    }

    public Account(int id, double balance, double interestRate) {
        this();
        this.id=id;
        this.balance = balance;
        this.annualInterestRate = interestRate;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public double getBalance() {
        return balance;
    }

    public Date getDateCreated() {
        Date createDate = new Date();
        return createDate;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return annualInterestRate / 12 * balance;
    }

    public void withdraw(int amount) {
        lastTransaction = LocalDateTime.now();
        setBalance(getBalance() - amount);
    }

    public void deposit(int amount) {
        lastTransaction = LocalDateTime.now();
        setBalance(getBalance() + amount);
    }
}
