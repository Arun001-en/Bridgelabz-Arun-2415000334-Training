import java.util.Scanner;
public class Que7 {
        Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        // Validate input
        if (number <= 0) {
            System.out.println("Please enter a valid positive integer.");
        } else {
            System.out.println("Factors of " + number + " are:");

            // Loop from 1 to number
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    System.out.println(i);
                }
            }
        }

        sc.close();
    }
}
