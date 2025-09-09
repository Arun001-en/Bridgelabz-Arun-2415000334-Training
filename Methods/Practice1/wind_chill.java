import java.util.Scanner;

public class wind_chill {

    // Method to calculate wind chill
    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature +
               (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature (Fahrenheit): ");
        double temp = sc.nextDouble();

        System.out.print("Enter wind speed (mph): ");
        double wind = sc.nextDouble();

        double windChill = calculateWindChill(temp, wind);

        System.out.println("Wind Chill Temperature = " + windChill);

        sc.close();
    }
}
