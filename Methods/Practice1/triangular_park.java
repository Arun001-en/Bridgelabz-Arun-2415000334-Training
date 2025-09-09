 
    
import java.util.Scanner;

public class triangular_park {

    // Method to calculate number of rounds
    public static double calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        double distance = 5000; // 5 km in meters
        return distance / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter side 1 of the triangle (meters): ");
        double a = sc.nextDouble();

        System.out.print("Enter side 2 of the triangle (meters): ");
        double b = sc.nextDouble();

        System.out.print("Enter side 3 of the triangle (meters): ");
        double c = sc.nextDouble();

        // Calculate
        double rounds = calculateRounds(a, b, c);

        // Output
        System.out.println("The athlete must complete " + rounds + " rounds to finish 5 km.");

        sc.close();
    }
}

