package java_design;
import java.util.*;

//Bank class
class Bank {
 private String bankName;
 private List<Customer> customers;

 public Bank(String bankName) {
     this.bankName = bankName;
     this.customers = new ArrayList<>();
 }

 public String getBankName() {
     return bankName;
 }

 // Method to open an account for a customer
 public void openAccount(Customer customer, String accountNumber, double initialBalance) {
     BankAccount account = new BankAccount(accountNumber, initialBalance, this);
     customer.addAccount(account);

     if (!customers.contains(customer)) {
         customers.add(customer);
     }

     System.out.println("Account " + accountNumber + " opened for " 
                        + customer.getName() + " in " + bankName);
 }

 public void showCustomers() {
     System.out.println("\nCustomers of " + bankName + ":");
     for (Customer c : customers) {
         System.out.println("- " + c.getName());
     }
 }
}

//Customer class
class Customer {
 private String name;
 private List<BankAccount> accounts;

 public Customer(String name) {
     this.name = name;
     this.accounts = new ArrayList<>();
 }

 public String getName() {
     return name;
 }

 public void addAccount(BankAccount account) {
     accounts.add(account);
 }

 // Method to view all balances
 public void viewBalance() {
     System.out.println("\nAccount balances of " + name + ":");
     for (BankAccount acc : accounts) {
         System.out.println("Account " + acc.getAccountNumber() +
                 " in " + acc.getBank().getBankName() +
                 " -> Balance: ₹" + acc.getBalance());
     }
 }
}

//BankAccount class
class BankAccount {
 private String accountNumber;
 private double balance;
 private Bank bank; // Association with Bank

 public BankAccount(String accountNumber, double balance, Bank bank) {
     this.accountNumber = accountNumber;
     this.balance = balance;
     this.bank = bank;
 }

 public String getAccountNumber() {
     return accountNumber;
 }

 public double getBalance() {
     return balance;
 }

 public Bank getBank() {
     return bank;
 }
}

//Main class
public class Bank{
 public static void main(String[] args) {
     Bank bank1 = new Bank("State Bank of India");
     Bank bank2 = new Bank("HDFC Bank");

     Customer c1 = new Customer("Chhavi");
     Customer c2 = new Customer("Aditi");

     bank1.openAccount(c1, "SBI101", 5000);
     bank1.openAccount(c1, "SBI102", 12000);
     bank2.openAccount(c2, "HDFC201", 8000);

     bank1.showCustomers();
     bank2.showCustomers();

     c1.viewBalance();
     c2.viewBalance();
 }
}
