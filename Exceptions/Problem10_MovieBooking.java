import java.util.HashMap;
import java.util.Map;

class InvalidSeatException extends Exception {
    public InvalidSeatException(String message) { super(message); }
}

class SeatAlreadyBookedException extends Exception {
    public SeatAlreadyBookedException(String message) { super(message); }
}

public class Problem10_MovieBooking {
    private Map<String, Boolean> seats;

    public Problem10_MovieBooking() {
        seats = new HashMap<>();
        seats.put("A1", true);
        seats.put("A2", true);
        seats.put("A3", false); 
    }

    public void bookSeat(String seat) throws InvalidSeatException, SeatAlreadyBookedException {
        if (!seats.containsKey(seat)) {
            throw new InvalidSeatException("Seat " + seat + " does not exist.");
        }
        if (!seats.get(seat)) {
            throw new SeatAlreadyBookedException("Seat " + seat + " is already booked.");
        }
        seats.put(seat, false);
        System.out.println("Successfully booked seat: " + seat);
    }

    public static void main(String[] args) {
        Problem10_MovieBooking booking = new Problem10_MovieBooking();
        
        try {
            booking.bookSeat("A1");
            booking.bookSeat("A3"); 
        } catch (InvalidSeatException | SeatAlreadyBookedException e) {
            System.out.println("Booking Error: " + e.getMessage());
        }

        try {
            booking.bookSeat("Z9");
        } catch (InvalidSeatException | SeatAlreadyBookedException e) {
            System.out.println("Booking Error: " + e.getMessage());
        }
    }
}
