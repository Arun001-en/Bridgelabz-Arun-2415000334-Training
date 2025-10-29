package constructors;
//CarRental.java
public class CarRental {
 // Attributes
 private String customerName;
 private String carModel;
 private int rentalDays;

 // Default constructor
 public CarRental() {
     this.customerName = "Unknown Customer";
     this.carModel = "Standard";
     this.rentalDays = 1;
 }

 // Parameterized constructor
 public CarRental(String customerName, String carModel, int rentalDays) {
     this.customerName = customerName;
     this.carModel = carModel;
     this.rentalDays = rentalDays;
 }

 // Method to calculate rental cost based on car model
 public double calculateTotalCost() {
     double ratePerDay;

     // Different rates based on car model
     switch (carModel.toLowerCase()) {
         case "suv":
             ratePerDay = 2500; // ₹ per day
             break;
         case "sedan":
             ratePerDay = 1800;
             break;
         case "hatchback":
             ratePerDay = 1200;
             break;
         default:
             ratePerDay = 1500; // Standard rate
     }

     return rentalDays * ratePerDay;
 }

 // Method to display rental details
 public void displayRentalDetails() {
     System.out.println("Customer: " + customerName);
     System.out.println("Car Model: " + carModel);
     System.out.println("Rental Days: " + rentalDays);
     System.out.println("Total Cost: ₹" + calculateTotalCost());
     System.out.println("----------------------------");
 }

 // Main method for testing
 public static void main(String[] args) {
     // Default rental
     CarRental r1 = new CarRental();
     r1.displayRentalDetails();

     // Parameterized rental
     CarRental r2 = new CarRental("Chhavi Varshney", "SUV", 5);
     r2.displayRentalDetails();

     CarRental r3 = new CarRental("Aditi Ruhela", "Sedan", 3);
     r3.displayRentalDetails();
 }
}
