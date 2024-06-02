package bankingapplication;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mahmoud
 */
public class Account {

    private String ownerName, password;
    private final String accountNumber;
    private double balance;
    private static int accountNumberCount = 1;
    private static ArrayList<Account> Accounts = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public Account(String ownerName, String password, double balance) {
        this.ownerName = ownerName;
        this.password = password;
        if (balance > 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
        this.accountNumber = accountNumberCount + "";
        accountNumberCount++;
    }

    public Account(String ownerName, String password) {
        this.ownerName = ownerName;
        this.password = password;
        this.balance = 100;
        this.accountNumber = accountNumberCount + "";
        accountNumberCount++;
    }

    public static void CreateAccount(Account a) {
        Accounts.add(a);
        System.out.println(a);
    }

    public static void DeleteAccount(String number, String password) {
        boolean found = false;
        for (Account currentAccount : Account.Accounts) {
            if (currentAccount.accountNumber.equals(number) && currentAccount.password.equals(password)) {
                found = true;
                Accounts.remove(currentAccount);
                System.out.println("Account deleted.");
                break;
            }
        }
        if (found == false) {
            System.out.println("No Account with this number or/and wrong password.");
        }
    }

    public static Account findAccount(String number, String Password) {
        boolean found = false;
        for (Account currentAccount : Account.Accounts) {
            if (currentAccount.accountNumber.equals(number) && currentAccount.password.equals(Password)) {
                found = true;
                return currentAccount;
            }
        }
        if (found == false) {
            System.out.println("No Account with this number or/and password is wrong.");
        }
        return null;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
        System.out.println("Balance after deposit = " + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            if (balance == 0) {
                System.out.println("balance not Enough \ncurrent balance = " + balance);
                return;
            }
            System.out.println("avilable balance =" + balance + "\nNew balance will equal 0.\nDo you want to withdraw(Y/N)");
            if (input.next().equalsIgnoreCase("Y")) {
                balance = 0;
            } else {
                System.out.println("withdraw canceld");
                return;
            }
        } else if (amount > 0) {
            balance -= amount;
        }
        System.out.println("Balance after withdraw = " + balance);
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance > 0) {
            this.balance = balance;
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ownerName=" + ownerName + ", accountNumber=" + accountNumber + ", balance=" + balance;
    }

}
