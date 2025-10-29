class BankAccount {
    private static String bankName = "State Bank of India";
    private static int totalAccounts = 0;

    private final String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        totalAccounts++;
    }

    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Balance: ₹" + balance);
        }
    }

    public static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("BA101", "Akshit", 25000);
        BankAccount acc2 = new BankAccount("BA102", "Preeti", 40000);

        acc1.displayAccountDetails();
        System.out.println();
        acc2.displayAccountDetails();

        System.out.println();
        BankAccount.getTotalAccounts();
    }
}
