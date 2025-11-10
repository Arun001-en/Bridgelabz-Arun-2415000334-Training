import java.util.Random;

class NegativeAmountException extends Exception {
    public NegativeAmountException(String message) { super(message); }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) { super(message); }
}

class NetworkFailureException extends Exception {
    public NetworkFailureException(String message) { super(message); }
}

class Transaction {
    public void processTransaction() throws NegativeAmountException, InsufficientFundsException, NetworkFailureException {
        Random rand = new Random();
        int failureType = rand.nextInt(4);

        switch (failureType) {
            case 0:
                throw new NegativeAmountException("Transaction failed: Cannot process a negative amount.");
            case 1:
                throw new InsufficientFundsException("Transaction failed: Insufficient funds in account.");
            case 2:
                throw new NetworkFailureException("Transaction failed: A network error occurred.");
            default:
                System.out.println("Transaction successful.");
        }
    }
}

public class Problem5_BankTransaction {
    public static void main(String[] args) {
        Transaction tx = new Transaction();
        for (int i = 0; i < 4; i++) {
            try {
                tx.processTransaction();
            } catch (NegativeAmountException e) {
                System.out.println("Handling Error: " + e.getMessage());
            } catch (InsufficientFundsException e) {
                System.out.println("Handling Error: " + e.getMessage());
            } catch (NetworkFailureException e) {
                System.out.println("Handling Error: " + e.getMessage());
            }
        }
    }
}
