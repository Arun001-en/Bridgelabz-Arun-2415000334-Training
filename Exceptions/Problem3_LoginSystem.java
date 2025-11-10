import java.util.Scanner;

class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}

public class Problem3_LoginSystem {

    public static void validate(String user, String pass) throws InvalidCredentialsException {
        String validUser = "admin";
        String validPass = "password123";

        if (!user.equals(validUser) || !pass.equals(validPass)) {
            throw new InvalidCredentialsException("Invalid username or password.");
        }
        System.out.println("Login successful! Welcome, " + user);
    }

    public static void main(String[] args) {
        try {
            validate("admin", "wrongpass");
        } catch (InvalidCredentialsException e) {
            System.out.println(e.getMessage());
            System.out.println("Please try again.");
        }
        
        try {
            validate("admin", "password123");
        } catch (InvalidCredentialsException e) {
            System.out.println(e.getMessage());
        }
    }
}
