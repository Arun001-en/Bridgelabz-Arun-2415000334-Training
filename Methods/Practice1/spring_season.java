import java.util.Scanner;

public class spring_season{

    // Method to check if spring season
    public static boolean isSpringSeason(int month, int day) {
        return (month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter day: ");
        int day = sc.nextInt();

        if (isSpringSeason(month, day))
            System.out.println("Its a Spring Season");
        else
            System.out.println("Not a Spring Season");

        sc.close();
    }
}
