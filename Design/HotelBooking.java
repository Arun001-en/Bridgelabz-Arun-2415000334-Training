package constructors;
//HotelBooking.java
public class HotelBooking {
 // Attributes
 private String guestName;
 private String roomType;
 private int nights;

 // Default constructor
 public HotelBooking() {
     this.guestName = "Unknown Guest";
     this.roomType = "Standard";
     this.nights = 1;
 }

 // Parameterized constructor
 public HotelBooking(String guestName, String roomType, int nights) {
     this.guestName = guestName;
     this.roomType = roomType;
     this.nights = nights;
 }

 // Copy constructor
 public HotelBooking(HotelBooking other) {
     this.guestName = other.guestName;
     this.roomType = other.roomType;
     this.nights = other.nights;
 }

 // Method to display booking details
 public void displayBooking() {
     System.out.println("Guest: " + guestName);
     System.out.println("Room Type: " + roomType);
     System.out.println("Nights: " + nights);
     System.out.println("----------------------------");
 }

 // Main method for testing
 public static void main(String[] args) {
     // Default booking
     HotelBooking b1 = new HotelBooking();
     b1.displayBooking();

     // Parameterized booking
     HotelBooking b2 = new HotelBooking("Chhavi Varshney", "Deluxe", 3);
     b2.displayBooking();

     // Copy booking
     HotelBooking b3 = new HotelBooking(b2);
     b3.displayBooking();
 }
}
