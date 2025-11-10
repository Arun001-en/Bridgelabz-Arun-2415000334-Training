abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    public String getVehicleNumber(){ return vehicleNumber; }
    public void setVehicleNumber(String n){ this.vehicleNumber = n; }
    public String getType(){ return type; }
    public void setType(String t){ this.type = t; }
    public double getRentalRate(){ return rentalRate; }
    public void setRentalRate(double r){ this.rentalRate = r; }
    public abstract double calculateRentalCost(int days);
}
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}
class Car extends Vehicle implements Insurable {
    @Override
    public double calculateRentalCost(int days){ return getRentalRate() * days; }
    @Override
    public double calculateInsurance(){ return 1000; }
    @Override
    public String getInsuranceDetails(){ return "Car Insurance"; }
}
class Bike extends Vehicle implements Insurable {
    @Override
    public double calculateRentalCost(int days){ return getRentalRate() * days * 0.5; }
    @Override
    public double calculateInsurance(){ return 300; }
    @Override
    public String getInsuranceDetails(){ return "Bike Insurance"; }
}
class Truck extends Vehicle {
    @Override
    public double calculateRentalCost(int days){ return getRentalRate() * days * 2; }
}
public class RentalMain {
    public static void main(String[] args){
        Vehicle[] arr = new Vehicle[3];
        Car car = new Car(); car.setVehicleNumber("KA01"); car.setRentalRate(2000);
        Bike bike = new Bike(); bike.setVehicleNumber("KA02"); bike.setRentalRate(500);
        Truck truck = new Truck(); truck.setVehicleNumber("KA03"); truck.setRentalRate(5000);
        arr[0]=car; arr[1]=bike; arr[2]=truck;
        for(Vehicle v: arr){
            System.out.println(v.getVehicleNumber()+" cost for 3 days: "+v.calculateRentalCost(3));
            if(v instanceof Insurable) System.out.println(((Insurable)v).getInsuranceDetails()+" "+((Insurable)v).calculateInsurance());
        }
    }
}
