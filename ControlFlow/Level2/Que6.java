import java.util.Scanner;

public class Que6{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for Amar
        System.out.print("Enter Amar's age: ");
        int ageAmar = scanner.nextInt();
        System.out.print("Enter Amar's height (in cm): ");
        int heightAmar = scanner.nextInt();

        // Take input for Akbar
        System.out.print("Enter Akbar's age: ");
        int ageAkbar = scanner.nextInt();
        System.out.print("Enter Akbar's height (in cm): ");
        int heightAkbar = scanner.nextInt();

        // Take input for Anthony
        System.out.print("Enter Anthony's age: ");
        int ageAnthony = scanner.nextInt();
        System.out.print("Enter Anthony's height (in cm): ");
        int heightAnthony = scanner.nextInt();

        // Find youngest friend
        if (ageAmar < ageAkbar && ageAmar < ageAnthony) {
            System.out.println("Youngest friend is Amar (Age: " + ageAmar + ")");
        } else if (ageAkbar < ageAmar && ageAkbar < ageAnthony) {
            System.out.println("Youngest friend is Akbar (Age: " + ageAkbar + ")");
        } else if (ageAnthony < ageAmar && ageAnthony < ageAkbar) {
            System.out.println("Youngest friend is Anthony (Age: " + ageAnthony + ")");
        } else {
            System.out.println("There is a tie in ages.");
        }

        // Find tallest friend
        if (heightAmar > heightAkbar && heightAmar > heightAnthony) {
            System.out.println("Tallest friend is Amar (Height: " + heightAmar + " cm)");
        } else if (heightAkbar > heightAmar && heightAkbar > heightAnthony) {
            System.out.println("Tallest friend is Akbar (Height: " + heightAkbar + " cm)");
        } else if (heightAnthony > heightAmar && heightAnthony > height
