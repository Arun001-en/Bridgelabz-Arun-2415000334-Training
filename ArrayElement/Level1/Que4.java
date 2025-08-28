import java.util.Scanner;
public class Que4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        while (true) {
            System.out.print("Enter number " + (index + 1) + ": ");
            double input = sc.nextDouble();
            if (input <= 0) {
                break;
            }
            if (index == 10) {
                System.out.println("Reached maximum limit of 10 numbers.");
                break;
            }
            numbers[index] = input;
            index++;
        }
        System.out.println("\nYou entered the following numbers:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        System.out.println("\nThe total sum of numbers is: " + total);

        sc.close();
    }
}
