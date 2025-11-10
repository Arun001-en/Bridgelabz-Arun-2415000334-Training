abstract class VehicleBase {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    public String getVehicleId(){ return vehicleId; }
    public void setVehicleId(String id){ this.vehicleId = id; }
    public String getDriverName(){ return driverName; }
    public void setDriverName(String n){ this.driverName = n; }
    public double getRatePerKm(){ return ratePerKm; }
    public void setRatePerKm(double r){ this.ratePerKm = r; }
    public String getVehicleDetails(){ return vehicleId+" "+driverName+" @"+ratePerKm; }
    public abstract double calculateFare(double distance);
}
interface GPS {
    String getCurrentLocation();
    void updateLocation(String loc);
}
class CarRide extends VehicleBase implements GPS {
    private String loc = "Unknown";
    @Override
    public double calculateFare(double distance){ return getRatePerKm()*distance; }
    @Override
    public String getCurrentLocation(){ return loc; }
    @Override
    public void updateLocation(String l){ loc = l; }
}
class BikeRide extends VehicleBase implements GPS {
    private String loc = "Unknown";
    @Override
    public double calculateFare(double distance){ return getRatePerKm()*distance*0.8; }
    @Override
    public String getCurrentLocation(){ return loc; }
    @Override
    public void updateLocation(String l){ loc = l; }
}
class AutoRide extends VehicleBase implements GPS {
    private String loc = "Unknown";
    @Override
    public double calculateFare(double distance){ return getRatePerKm()*distance*0.9; }
    @Override
    public String getCurrentLocation(){ return loc; }
    @Override
    public void updateLocation(String l){ loc = l; }
}
public class RideMain {
    public static void main(String[] args){
        VehicleBase[] arr = new VehicleBase[3];
        CarRide c = new CarRide(); c.setVehicleId("V1"); c.setDriverName("D1"); c.setRatePerKm(15);
        BikeRide b = new BikeRide(); b.setVehicleId("V2"); b.setDriverName("D2"); b.setRatePerKm(10);
        AutoRide a = new AutoRide(); a.setVehicleId("V3"); a.setDriverName("D3"); a.setRatePerKm(12);
        arr[0]=c; arr[1]=b; arr[2]=a;
        for(VehicleBase v: arr){
            System.out.println(v.getVehicleDetails()+" Fare for 10km: "+v.calculateFare(10));
            if(v instanceof GPS){ ((GPS)v).updateLocation("MG Road"); System.out.println(((GPS)v).getCurrentLocation()); }
        }
    }
}
