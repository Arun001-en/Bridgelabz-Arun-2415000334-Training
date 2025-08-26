import java.util.Scanner;

public class Que1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year (>=1582): ");
        int year = scanner.nextInt();
        if (year < 1582) {
            System.out.println("Leap year calculation is only valid for years >= 1582.");
        } else {
            System.out.println("--- Approach 1: Using multiple if-else ---");

            if (year % 400 == 0) {
                System.out.println(year + " is a Leap Year.");
            } else if (year % 100 == 0) {
                System.out.println(year + " is NOT a Leap Year.");
            } else if (year % 4 == 0) {
                System.out.println(year + " is a Leap Year.");
            } else {
                System.out.println(year + " is NOT a Leap Year.");
            }
        scanner.close();
    }
}
}
