import java.util.Scanner;
public class Que9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter countdown starting number: ");
        int counter = scanner.nextInt();
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }

        System.out.println("Lift Off");
        scanner.close();
    }
}
