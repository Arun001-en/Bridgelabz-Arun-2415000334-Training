import java.util.Random;

class OutOfStockException extends Exception {
    public OutOfStockException(String message) { super(message); }
}

class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) { super(message); }
}

public class Problem4_OnlineOrder {

    public static void placeOrder() throws OutOfStockException, PaymentFailedException {
        Random rand = new Random();
        int chance = rand.nextInt(3); 

        if (chance == 0) {
            throw new OutOfStockException("Sorry, the product is out of stock.");
        } else if (chance == 1) {
            throw new PaymentFailedException("Payment failed. Please check your card details.");
        } else {
            System.out.println("Order placed successfully!");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println("Attempting to place order...");
            try {
                placeOrder();
            } catch (OutOfStockException e) {
                System.out.println("Order Error: " + e.getMessage());
            } catch (PaymentFailedException e) {
                System.out.println("Payment Error: " + e.getMessage());
            }
        }
    }
}
