import java.util.Scanner;

public class Question12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter distance in feet: ");
        double distanceInFeet = sc.nextDouble();

        // Convert feet to yards
        double distanceInYards = distanceInFeet / 3.0;

        // Convert yards to miles
        double distanceInMiles = distanceInYards / 1760.0;

        // Output result
        System.out.println("Your distance in feet is " + distanceInFeet +
                           " which is equal to " + distanceInYards + " yards and " +
                           distanceInMiles + " miles.");

        sc.close();
    }
}
