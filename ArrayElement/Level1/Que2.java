import java.util.Scanner;
public class Que2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];

            if (num > 0) {
                if (num % 2 == 0) {
                    System.out.println("Number " + num + " is Positive and Even.");
                } else {
                    System.out.println("Number " + num + " is Positive and Odd.");
                }
            } else if (num < 0) {
                System.out.println("Number " + num + " is Negative.");
            } else {
                System.out.println("Number " + num + " is Zero.");
            }
        }
        if (numbers[0] == numbers[numbers.length - 1]) {
            System.out.println("First element (" + numbers[0] + ") is EQUAL to last element (" + numbers[numbers.length - 1] + ").");
        } else if (numbers[0] > numbers[numbers.length - 1]) {
            System.out.println("First element (" + numbers[0] + ") is GREATER than last element (" + numbers[numbers.length - 1] + ").");
        } else {
            System.out.println("First element (" + numbers[0] + ") is LESS than last element (" + numbers[numbers.length - 1] + ").");
        }

        scanner.close();
    }
}
