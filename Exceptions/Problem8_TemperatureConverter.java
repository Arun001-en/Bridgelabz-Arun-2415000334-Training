class InvalidTemperatureException extends Exception {
    public InvalidTemperatureException(String message) { super(message); }
}

public class Problem8_TemperatureConverter {

    private static final double ABSOLUTE_ZERO_C = -273.15;
    private static final double ABSOLUTE_ZERO_F = -459.67;

    public static double convert(double temp, String unit) throws InvalidTemperatureException {
        if (unit.equalsIgnoreCase("C")) {
            if (temp < ABSOLUTE_ZERO_C) {
                throw new InvalidTemperatureException("Temperature below absolute zero is not possible!");
            }
            return (temp * 9/5) + 32;
        } else if (unit.equalsIgnoreCase("F")) {
            if (temp < ABSOLUTE_ZERO_F) {
                throw new InvalidTemperatureException("Temperature below absolute zero is not possible!");
            }
            return (temp - 32) * 5/9;
        } else {
            throw new IllegalArgumentException("Invalid unit. Use 'C' or 'F'.");
        }
    }

    public static void main(String[] args) {
        try {
            double f = convert(100, "C");
            System.out.println("100°C is " + f + "°F");

            double c = convert(32, "F");
            System.out.println("32°F is " + c + "°C");

            convert(-300, "C");

        } catch (InvalidTemperatureException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
