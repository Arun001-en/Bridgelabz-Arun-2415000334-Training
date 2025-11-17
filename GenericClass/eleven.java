import java.util.ArrayList;

class Vehicle {}
class Truck extends Vehicle {}
class Bike extends Vehicle {}

class FleetManager<T extends Vehicle> {
    ArrayList<T> fleet=new ArrayList<>();
    void addVehicle(T v){ fleet.add(v); }
    void showFleet(){ System.out.println(fleet); }
    public static void main(String[] args) {
        FleetManager<Truck> fm1=new FleetManager<>();
        fm1.addVehicle(new Truck());
        fm1.showFleet();

        FleetManager<Bike> fm2=new FleetManager<>();
        fm2.addVehicle(new Bike());
        fm2.showFleet();
    }
}
