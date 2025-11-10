class SeatUnavailableException extends Exception {
    public SeatUnavailableException(String message) { super(message); }
}

class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) { super(message); }
}

public class Problem13_FlightBooking {

    public static void checkSeatAvailability(boolean available) throws SeatUnavailableException {
        if (!available) {
            throw new SeatUnavailableException("No seats are available on this flight.");
        }
        System.out.println("Seat confirmed.");
    }

    public static void processPayment(boolean success) throws PaymentFailedException {
        if (!success) {
            throw new PaymentFailedException("Payment declined by the bank.");
        }
        System.out.println("Payment successful.");
    }

    public static void bookTicket(boolean seat, boolean payment) throws Exception {
        checkSeatAvailability(seat);
        processPayment(payment);
        System.out.println("Ticket booked!");
    }

    public static void main(String[] args) {
        System.out.println("--- Attempt 1: Payment Failed ---");
        try {
            bookTicket(true, false);
        } catch (SeatUnavailableException e) {
            System.out.println("Booking failed: " + e.getMessage());
        } catch (PaymentFailedException e) {
            System.out.println("Booking failed: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unknown error occurred: " + e.getMessage());
        } finally {
            System.out.println("Thank you for booking with us!\n");
        }
        
        System.out.println("--- Attempt 2: Success ---");
        try {
            bookTicket(true, true);
        } catch (Exception e) {
            System.out.println("Booking failed: " + e.getMessage());
        } finally {
            System.out.println("Thank you for booking with us!\n");
        }
    }
}
