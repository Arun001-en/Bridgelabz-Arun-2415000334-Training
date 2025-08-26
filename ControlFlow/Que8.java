import java.util.Scanner;
public class Que8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter countdown starting number: ");
        int counter = scanner.nextInt();
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }

        System.out.println("Lift Off");
        scanner.close();
    }
}
