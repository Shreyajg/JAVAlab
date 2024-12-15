import java.util.Scanner;
// Main class with switch cases
public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintInfo.print();

        System.out.println("Select Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        Account account = null;

        if (choice == 1) {
            System.out.println("Enter Customer Name:");
            String name = scanner.nextLine();
            System.out.println("Enter Account Number:");
            String accNum = scanner.nextLine();
            System.out.println("Enter Interest Rate:");
            double rate = scanner.nextDouble();
            account = new SavAcct(name, accNum, rate);
        } else if (choice == 2) {
            System.out.println("Enter Customer Name:");
            String name = scanner.nextLine();
            System.out.println("Enter Account Number:");
            String accNum = scanner.nextLine();
            account = new CurAcct(name, accNum);
        } else {
            System.out.println("Invalid choice!");
            System.exit(0);
        }

        int option;
        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            if (account instanceof SavAcct) {
                System.out.println("3. Compound Interest");
            }
            System.out.println("4. Display Balance");
            System.out.println("5. Exit");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    if (account instanceof SavAcct) {
                        ((SavAcct) account).compoundDeposit();
                    } else {
                        System.out.println("Invalid option for Current Account.");
                    }
                    break;

                case 4:
                    account.displayBalance();
                    break;

                case 5:
                    System.out.println("Thank you for using the bank system!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (option != 5);

        scanner.close();
    }
}

// Utility class for printing information
class PrintInfo {
    static void print() {
        System.out.println("C Name:Shreya J G \n USN:1BM23IC061\n");
    }
}

// Abstract Account class
abstract class Account {
    String customerName;
    String accountType;
    String accountNumber;
    double balance;

    public Account(String customerName, String accountType, String accountNumber) {
        this.customerName = customerName;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited amount is: " + amount);
        displayBalance();
    }

    public void displayBalance() {
        System.out.println("Current balance is: " + balance);
    }

    public abstract void withdraw(double amount);
}

// Savings Account class
class SavAcct extends Account {
    double interestRate;

    public SavAcct(String customerName, String accountNumber, double interestRate) {
        super(customerName, "Savings", accountNumber);
        this.interestRate = interestRate;
    }

    public void compoundDeposit() {
        double interest = balance * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest of " + interest + " deposited.");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn amount is: " + amount);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
        displayBalance();
    }
}

// Current Account class
class CurAcct extends Account {
    private static final double minBalance = 1000.0;
    private static final double serviceCharge = 50.0;

    public CurAcct(String customerName, String accountNumber) {
        super(customerName, "Current", accountNumber);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn amount is: " + amount);
        } else {
            System.out.println("Insufficient amount for withdrawal.");
            return;
        }

        if (balance < minBalance) {
            balance -= serviceCharge;
            System.out.println("Balance below minimum! Service charge of " + serviceCharge + " applied.");
        }
        displayBalance();
    }
}


