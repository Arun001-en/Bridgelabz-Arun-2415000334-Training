class Vehicle {
    // Static variable
    static double registrationFee = 5000.0;

    // Instance variables
    String ownerName;
    String vehicleType;
    final String registrationNumber;

    // Constructor using 'this'
    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Static method to update registration fee
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Updated Registration Fee: " + registrationFee);
    }

    // Display vehicle details
    void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: " + registrationFee);
        } else {
            System.out.println("Invalid object.");
        }
    }
}

public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        // Create Vehicle objects
        Vehicle v1 = new Vehicle("Rahul Sharma", "Car", "DL01AB1234");
        Vehicle v2 = new Vehicle("Priya Verma", "Bike", "MH05XY7890");

        // Display vehicle details
        v1.displayVehicleDetails();
        System.out.println("---------------------------");
        v2.displayVehicleDetails();

        // Update registration fee (static method)
        Vehicle.updateRegistrationFee(6000.0);

        System.out.println("---------------------------");
        v1.displayVehicleDetails();
    }
}
