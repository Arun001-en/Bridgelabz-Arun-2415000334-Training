interface SmartDevice {
    void turnOn();
    void turnOff();
}
class Light implements SmartDevice {
    public void turnOn() {
        System.out.println("Light is turned ON.");
    }

    public void turnOff() {
        System.out.println("Light is turned OFF.");
    }
}
class AirConditioner implements SmartDevice {
    public void turnOn() {
        System.out.println("Air Conditioner is turned ON.");
    }

    public void turnOff() {
        System.out.println("Air Conditioner is turned OFF.");
    }
}
class TV implements SmartDevice {
    public void turnOn() {
        System.out.println("TV is turned ON.");
    }

    public void turnOff() {
        System.out.println("TV is turned OFF.");
    }
}
public class Main {
    public static void main(String[] args) {
        SmartDevice light = new Light();
        SmartDevice ac = new AirConditioner();
        SmartDevice tv = new TV();

        light.turnOn();
        ac.turnOn();
        tv.turnOn();

        System.out.println("------------------------");

        light.turnOff();
        ac.turnOff();
        tv.turnOff();
    }
}
