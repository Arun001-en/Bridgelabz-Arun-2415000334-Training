import java.util.HashMap;
import java.util.Map;

class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) { super(message); }
}

class InvalidReturnException extends Exception {
    public InvalidReturnException(String message) { super(message); }
}

class UserLimitExceededException extends Exception {
    public UserLimitExceededException(String message) { super(message); }
}

class LibrarySystem {
    private Map<String, Boolean> bookAvailability;
    private Map<String, Integer> userBorrowCount;
    private final int MAX_BORROW_LIMIT = 5;

    public LibrarySystem() {
        bookAvailability = new HashMap<>();
        userBorrowCount = new HashMap<>();
        bookAvailability.put("BookA", true);
        bookAvailability.put("BookB", false); 
        userBorrowCount.put("User1", 4);
    }

    public void borrowBook(String user, String book) throws BookNotAvailableException, UserLimitExceededException {
        int count = userBorrowCount.getOrDefault(user, 0);
        if (count >= MAX_BORROW_LIMIT) {
            throw new UserLimitExceededException(user + " has reached the borrow limit of " + MAX_BORROW_LIMIT);
        }
        
        if (!bookAvailability.getOrDefault(book, false)) {
            throw new BookNotAvailableException(book + " is currently not available.");
        }
        
        bookAvailability.put(book, false);
        userBorrowCount.put(user, count + 1);
        System.out.println(user + " successfully borrowed " + book);
    }

    public void returnBook(String user, String book) throws InvalidReturnException {
        if (bookAvailability.getOrDefault(book, true)) {
            throw new InvalidReturnException(book + " was not borrowed or does not exist.");
        }
        
        bookAvailability.put(book, true);
        userBorrowCount.put(user, userBorrowCount.getOrDefault(user, 1) - 1);
        System.out.println(user + " successfully returned " + book);
    }
}

public class Problem7_LibraryManagement {
    public static void main(String[] args) {
        LibrarySystem lib = new LibrarySystem();
        try {
            lib.borrowBook("User1", "BookB");
        } catch (BookNotAvailableException | UserLimitExceededException e) {
            System.out.println("Log: " + e.getMessage());
        }

        try {
            lib.borrowBook("User1", "BookA");
            lib.borrowBook("User1", "BookC");
        } catch (BookNotAvailableException | UserLimitExceededException e) {
            System.out.println("Log: " + e.getMessage());
        }

        try {
            lib.returnBook("User2", "BookA");
        } catch (InvalidReturnException e) {
            System.out.println("Log: " + e.getMessage());
        }
    }
}
