class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class ATM {
    private int balance;

    public ATM(int initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(int amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Withdrawal failed. Available balance is only ?" + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: ?" + balance);
        }
    }
}

public class Problem1_AtmWithdrawal {
    public static void main(String[] args) {
        ATM myAtm = new ATM(10000);
        try {
            System.out.println("Attempting to withdraw ?5000...");
            myAtm.withdraw(5000);
            System.out.println("Attempting to withdraw ?6000...");
            myAtm.withdraw(6000);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
