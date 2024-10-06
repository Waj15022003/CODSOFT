import java.util.Scanner;

// Class to represent user's bank account
class BankAccount {
    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public double checkBalance() {
        return balance;
    }
}

// Class to represent ATM machine
public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= 10000) {
            account.withdraw(amount);
        } else {
            System.out.println("Invalid amount. Please enter amount between 1 and 10000.");
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= 10000) {
            account.deposit(amount);
        } else {
            System.out.println("Invalid amount. Please enter amount between 1 and 10000.");
        }
    }

    private void checkBalance() {
        System.out.println("Your balance: " + account.checkBalance());
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(12345, 1000);
        ATM atm = new ATM(account);
        atm.run();
    }
}

