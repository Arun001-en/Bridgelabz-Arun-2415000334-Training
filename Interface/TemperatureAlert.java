import java.util.function.Predicate;

public class TemperatureAlert {

    public static void main(String[] args) {
        // Define the threshold
        double threshold = 37.5;
        Predicate<Double> isHighTemperature = temp -> temp > threshold;

        // Test temperatures
        double[] temperatures = {36.5, 37.8, 38.2, 36.9, 39.0};

        for (double temp : temperatures) {
            if (isHighTemperature.test(temp)) {
                System.out.println("ALERT! High temperature detected: " + temp + "°C");
            } else {
                System.out.println("Temperature normal: " + temp + "°C");
            }
        }
    }
}
