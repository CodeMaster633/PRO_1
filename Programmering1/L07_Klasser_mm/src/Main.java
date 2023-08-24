import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ATM atm = new ATM();
        boolean active = true;

        atm.createAccounts();
        atm.accounts[3].setBalance(13);
        while(active){
            atm.enterId();

            }
    }
}



//    public static void enterId(){
//
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter an id: ");
//        int idNumber = input.nextInt();
//
//
//    }
//
//    public static void createAccounts(){
//        Account[] accounts = new Account[10];
//        for(int i = 0; i<accounts.length;i++){
//            accounts[i]= new Account(i,100,1.5);
////            System.out.println(accounts[i].getBalance());
//        }
//    }



//    Account a1 = new Account(20000,4.5);
//
//        System.out.println("Account id: " + a1.getId() + "\nBalance: " + a1.getBalance() + " $  \nDate: " + a1.getDateCreated() + "\nInterest rate: " + a1.getAnnualInterestRate() + "\n..................");


//        a1.withdraw(2500);
//        a1.deposit(3000);

//        System.out.println("New balance: " + a1.getBalance());
//        System.out.println(a1.getDateCreated());