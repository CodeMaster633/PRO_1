import java.util.Scanner;

public class ATM {

    Account[] accounts = new Account[10];

    int choice = 0;

    public ATM() {
    }

    public boolean enterId() {
        boolean result = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an id: ");
        int idNumber = input.nextInt();
        if (idNumber < accounts.length) {
            boolean gyldig = true;
            while (gyldig) {
                System.out.println();
                System.out.println("1: check balance" + "\n2: withdraw" + "\n3: deposit" + "\n4: exit");
                System.out.println("Enter a choice: ");
                choice = input.nextInt();
//            menuAction(choice);
//            System.out.println("Account balance: " + accounts[idNumber].getBalance());
                if (choice == 1) {
                    System.out.println("Valg 1 - Balance");
                    System.out.println(accounts[idNumber].getBalance() + " kr.");

                } else if (choice == 2) {
                    System.out.println("Valg 2 - Withdraw");
                    System.out.println("Withdraw amount: ");
                    int amount = input.nextInt();

                   accounts[idNumber].withdraw(amount);

                } else if (choice == 3) {
                    System.out.println("Valg 3 - Deposit");
                    System.out.println("Deposit amount: ");
                    int amount = input.nextInt();

                    accounts[idNumber].deposit(amount);

                } else if (choice == 4) {
                    System.out.println("valg 4");
                    System.out.println("Program afsluttes");
                    System.out.println();
                    gyldig=false;
                    result=false;
                }
                result = true;
            }
        } else {
            System.out.println("Enter a valid id");
        }
        return result;
    }

    public void createAccounts() {
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 100, 1.5);
//            System.out.println(accounts[i].getBalance());
        }
    }

//    public void menuAction(int choice){
//        if(choice==1){
//            System.out.println("valg 1");
//
//        } else if (choice==2) {
//            System.out.println("valg 2");
//
//        }else if (choice==3) {
//            System.out.println("valg 3");
//
//        }else if (choice==4) {
//            System.out.println("valg 4");
//        }
//    }
}
