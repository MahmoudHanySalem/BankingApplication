package bankingapplication;

import java.util.Scanner;

/**
 *
 * @author Mahmoud
 */
public class BankingApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean loggedIn = false;
        // Authentication loop
        while (loggedIn == false) {
            System.out.print("Enter Name:");//manager name=Mahmoud<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            String name = input.next();
            System.out.print("Enter password:");//manager password=123<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            String password = input.next();
            if (name.equalsIgnoreCase("Mahmoud") && password.equals("123")) {
                loggedIn = true;
                System.out.println("Logged into Bank System Successfully");
                boolean continuing = true;
                // Main menu loop
                while (continuing) {
                    System.out.println("Choose action:\n(0)Exit\n(1)Create an Account.\n(2)Delete an Account using Account number and password.\n(3)Change the name of a Account owner using account number and password.\n(4)Change the password of a Account using account number and old password.\n(5)deposit using account number and password\n(6)withdraw using account number and password.\n(7)Show balance using account number and password.\n(8)show Account detiles using account number and password.");
                    int choice = input.nextInt();
                    switch (choice) {
                        case 0 ->
                            continuing = false;
                        case 1 -> {
                            System.out.print("Enter Owner Name:");
                            input.nextLine();
                            String ownerName = input.nextLine();
                            boolean valid = true;
                            String accountPassword = "";
                            while (valid) {
                                System.out.print("Enter password(should be 5 or more characteres/digits or symbols ):");
                                accountPassword = input.next();
                                if (accountPassword.length() >= 5) {
                                    valid = false;
                                } else {
                                    System.out.println("minimum length is 5");
                                }
                            }
                            boolean validBalance = true;
                            double balance = -1;
                            while (validBalance) {
                                System.out.println("Enter balance");
                                try {
                                    balance = input.nextDouble();
                                    validBalance = false;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid value<<must be an number>>");
                                    input.nextLine();
                                }
                            }
                            Account a = new Account(ownerName, accountPassword, balance);
                            Account.CreateAccount(a);
                        }
                        case 2 -> {
                            System.out.print("Enter Account number:");
                            String AccountNumber = input.next();
                            System.out.print("Enter Account password:");
                            String AccountPassword = input.next();
                            Account.DeleteAccount(AccountNumber, AccountPassword);
                        }
                        case 3 -> {
                            System.out.print("Enter Account number:");
                            String AccountNumber = input.next();
                            System.out.print("Enter Account password:");
                            String AccountPassword = input.next();
                            System.out.print("Enter new Account owner name:");
                            input.nextLine();
                            String newName = input.nextLine();
                            Account a = Account.findAccount(AccountNumber, AccountPassword);
                            if (a != null) {
                                a.setOwnerName(newName);
                            }
                        }
                        case 4 -> {
                            System.out.print("Enter Account number:");
                            String AccountNumber = input.next();
                            System.out.print("Enter Account password:");
                            String AccountPassword = input.next();
                            boolean valid = true;
                            String newPassword = "";
                            while (valid) {
                                System.out.print("Enter password(should be 5 or more characteres/digits or symbols ):");
                                newPassword = input.next();
                                if (newPassword.length() >= 5) {
                                    valid = false;
                                } else {
                                    System.out.println("minimum length is 5");
                                }
                            }
                            Account a = Account.findAccount(AccountNumber, AccountPassword);
                            if (a != null) {
                                a.setPassword(newPassword);
                            }
                        }
                        case 5 -> {
                            System.out.print("Enter Account number:");
                            String AccountNumber = input.next();
                            System.out.print("Enter Account password:");
                            String AccountPassword = input.next();
                            System.out.print("Enter amount:");
                            double amount = input.nextDouble();
                            Account a = Account.findAccount(AccountNumber, AccountPassword);
                            if (a != null) {
                                a.deposit(amount);
                            }
                        }
                        case 6 -> {
                            System.out.print("Enter Account number:");
                            String AccountNumber = input.next();
                            System.out.print("Enter Account password:");
                            String AccountPassword = input.next();
                            System.out.print("Enter amount:");
                            double amount = input.nextDouble();
                            Account a = Account.findAccount(AccountNumber, AccountPassword);
                            if (a != null) {
                                a.withdraw(amount);
                            }
                        }
                        case 7 -> {
                            System.out.print("Enter Account number:");
                            String AccountNumber = input.next();
                            System.out.print("Enter Account password:");
                            String AccountPassword = input.next();
                            Account a = Account.findAccount(AccountNumber, AccountPassword);
                            if (a != null) {
                                System.out.println("Balance = " + a.getBalance());
                            }
                        }
                        case 8 -> {
                            System.out.print("Enter Account number:");
                            String AccountNumber = input.next();
                            System.out.print("Enter Account password:");
                            String AccountPassword = input.next();
                            Account a = Account.findAccount(AccountNumber, AccountPassword);
                            if (a != null) {
                                System.out.println(a);
                            }
                        }
                        default ->
                            System.out.println("Invalid choice");
                    }

                }
            } else {
                System.out.println("Authentication failed. Please try again.");
            }
        }
    }
}
