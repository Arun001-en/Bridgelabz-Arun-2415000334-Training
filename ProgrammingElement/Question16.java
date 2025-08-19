
 import java.util.Scanner;
 public class Question16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
        System.out.println("The maximum number of possible handshakes among "  + numberOfStudents + " students is " + handshakes);

        input.close();
    }
}
