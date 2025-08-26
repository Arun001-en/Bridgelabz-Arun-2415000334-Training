import java.util.Scanner;
public class Que2 {
    public static void main(String[] args) {
        
    Scanner sc = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee's salary: ");
        double salary = scanner.nextDouble();
        
        System.out.print("Enter years of service: ");
        int years = scanner.nextInt();

        double bonus = 0;
        if (years > 5) {
            bonus = 0.05 * salary;
            System.out.println("Bonus amount = " + bonus);
        } else {
            System.out.println("No bonus");
        }

        scanner.close();
    }
}
