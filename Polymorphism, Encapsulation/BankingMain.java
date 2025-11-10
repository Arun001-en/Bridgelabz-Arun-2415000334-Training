abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    public String getAccountNumber(){ return accountNumber; }
    public void setAccountNumber(String a){ this.accountNumber = a; }
    public String getHolderName(){ return holderName; }
    public void setHolderName(String n){ this.holderName = n; }
    public double getBalance(){ return balance; }
    public void setBalance(double b){ this.balance = b; }
    public void deposit(double amount){ setBalance(getBalance()+amount); }
    public void withdraw(double amount){ if(amount<=getBalance()) setBalance(getBalance()-amount); }
    public abstract double calculateInterest();
}
interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}
class SavingsAccount extends BankAccount implements Loanable {
    @Override
    public double calculateInterest(){ return getBalance()*4/100; }
    @Override
    public void applyForLoan(double amount){ System.out.println("Loan Applied: "+amount); }
    @Override
    public double calculateLoanEligibility(){ return getBalance()*0.5; }
}
class CurrentAccount extends BankAccount implements Loanable {
    @Override
    public double calculateInterest(){ return 0; }
    @Override
    public void applyForLoan(double amount){ System.out.println("Loan Applied Current: "+amount); }
    @Override
    public double calculateLoanEligibility(){ return getBalance()*0.2; }
}
public class BankingMain {
    public static void main(String[] args){
        BankAccount s = new SavingsAccount(); s.setAccountNumber("A1"); s.setHolderName("S"); s.setBalance(10000);
        BankAccount c = new CurrentAccount(); c.setAccountNumber("A2"); c.setHolderName("C"); c.setBalance(5000);
        BankAccount[] arr = {s,c};
        for(BankAccount b: arr) System.out.println(b.getAccountNumber()+" Interest: "+b.calculateInterest());
        ((Loanable)s).applyForLoan(50000);
        System.out.println("Eligibility: "+((Loanable)c).calculateLoanEligibility());
    }
}
