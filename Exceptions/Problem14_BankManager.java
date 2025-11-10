class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) { super(message); }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) { super(message); }
}

public class Problem14_BankManager {

    public static void verifyAccount(String accountId) throws AccountNotFoundException {
        if (!accountId.equals("ACC123")) {
            throw new AccountNotFoundException("Account " + accountId + " does not exist.");
        }
        System.out.println("Account verified.");
    }

    public static void processTransaction(double balance, double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for this transaction.");
        }
        System.out.println("Transaction processed.");
    }

    public static void executeTransaction(String id, double balance, double amount) throws Exception {
        verifyAccount(id);
        processTransaction(balance, amount);
        System.out.println("Transaction successful.");
    }

    public static void main(String[] args) {
        System.out.println("--- Scenario 1: Account Not Found ---");
        try {
            executeTransaction("ACC456", 1000, 500);
        } catch (AccountNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction complete.\n");
        }
        
        System.out.println("--- Scenario 2: Insufficient Funds ---");
        try {
            executeTransaction("ACC123", 1000, 5000);
        } catch (AccountNotFoundException | InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction complete.\n");
        }
    }
}
