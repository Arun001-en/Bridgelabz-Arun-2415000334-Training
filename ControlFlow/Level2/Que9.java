import java.util.Scanner;
public class Que9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        int greatestFactor = 1;

        if (number <= 1) {
            System.out.println("Please enter an integer greater than 1.");
        } else {
            // Loop from number-1 to 1
            for (int i = number - 1; i >= 1; i--) {
                if (number % i == 0) {
                    greatestFactor = i;
                    break; // Stop at first factor found (largest among smaller numbers)
                }
            }

            System.out.println("Greatest factor of " + number + " (other than itself) is: " + greatestFactor);
        }

        scanner.close();
    }
}
