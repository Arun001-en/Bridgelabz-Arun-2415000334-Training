interface Vehicle {
    void rent();
    void returnVehicle();
}
class Car implements Vehicle {
    public void rent() {
        System.out.println("Car has been rented.");
    }

    public void returnVehicle() {
        System.out.println("Car has been returned.");
    }
}
class Bike implements Vehicle {
    public void rent() {
        System.out.println("Bike has been rented.");
    }

    public void returnVehicle() {
        System.out.println("Bike has been returned.");
    }
}
class Bus implements Vehicle {
    public void rent() {
        System.out.println("Bus has been rented.");
    }

    public void returnVehicle() {
        System.out.println("Bus has been returned.");
    }
}
public class Main2 {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bike = new Bike();
        Vehicle bus = new Bus();

        car.rent();
        bike.rent();
        bus.rent();

        System.out.println("------------------------");

        car.returnVehicle();
        bike.returnVehicle();
        bus.returnVehicle();
    }
}
