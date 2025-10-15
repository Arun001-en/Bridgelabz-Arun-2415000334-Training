public interface PaymentProcessor {
    void processPayment(double amount);

    // New default refund method
    default void refund(double amount) {
        System.out.println("Default refund processing for amount: " + amount);
    }
}
