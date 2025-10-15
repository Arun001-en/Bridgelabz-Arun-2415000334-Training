public interface Vehicle {
    void displaySpeed();

    // New default method for electric vehicle battery display
    default void displayBatteryStatus() {
        // Default: Do nothing, or optionally print "Battery info not available"
    }
}

public class PetrolCar implements Vehicle {
    public void displaySpeed() {
        System.out.println("Speed: 80 km/h");
    }
    // Inherits default displayBatteryStatus (does nothing)
}

public class ElectricCar implements Vehicle {
    public void displaySpeed() {
        System.out.println("Speed: 80 km/h");
    }
    // Override to show battery for EVs
    @Override
    public void displayBatteryStatus() {
        System.out.println("Battery: 65%");
    }
}
