import java.util.Scanner;
public class maximum {



    // Method to calculate handshakes
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();

        // Calculate
        int handshakes = calculateHandshakes(numberOfStudents);

        // Output
        System.out.println("Maximum possible handshakes = " + handshakes);

        sc.close();
    }
}

    

