package Inheritance;

class Veehicle {
    int maxSpeed;
    String fuelType;

    public Veehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public void displayInfo() {
        System.out.println("Vehicle Info:");
        System.out.println("Max Speed: " + maxSpeed);
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Subclass: Car
class Car extends Veehicle {
    int seatCapacity;

    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car Info:");
        System.out.println("Max Speed: " + maxSpeed);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Seat Capacity: " + seatCapacity);
        System.out.println();
    }
}


class Truck extends Veehicle {
    int loadCapacity;

    public Truck(int maxSpeed, String fuelType, int loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

  
    public void displayInfo() {
        System.out.println("Truck Info:");
        System.out.println("Max Speed: " + maxSpeed);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Load Capacity: " + loadCapacity + " tons");
        System.out.println();
    }
}


class MotorCycle extends Veehicle {
    boolean hasCarrier;

    public MotorCycle(int maxSpeed, String fuelType, boolean hasCarrier) {
        super(maxSpeed, fuelType);
        this.hasCarrier = hasCarrier;
    }

   
    public void displayInfo() {
        System.out.println("MotorCycle Info:");
        System.out.println("Max Speed: " + maxSpeed);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Has Carrier: " + (hasCarrier ? "Yes" : "No"));
        System.out.println();
    }
}


public class VehicleAndTransport {
    public static void main(String[] args) {
      
        Veehicle[] vehicles = new Veehicle[3];
        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 10);
        vehicles[2] = new MotorCycle(100, "Petrol", true);

    
        for (Veehicle v : vehicles) {
            v.displayInfo();
        }
    }
}