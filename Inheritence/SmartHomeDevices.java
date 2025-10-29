package Inheritance;

class Devices{ //super class
	int deviceId;
	String status;
	Devices(int deviceId,String status){
		this.deviceId= deviceId;
		this.status = status;
	}
	
	void displayStatus(String status) {
		System.out.println("The device is:"+status);
	}
}

class Thermostat extends Devices{
	int temperatureSetting;
	Thermostat(int deviceId,String status,int temperatureSetting ){
		super(deviceId,status);
		this.temperatureSetting= temperatureSetting;
	}
}




public class SmartHomeDevices {


	public static void main(String[] args) {
		Thermostat thermostat = new Thermostat(2,"not working",20);
		
		thermostat.displayStatus(thermostat.status);
		
		
	}

}