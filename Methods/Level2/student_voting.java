import java.util.*;

public class student_voting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            String input = sc.nextLine();
            ages[i] = Integer.parseInt(input);

            if (ages[i] >= 18)
                System.out.println("Student " + (i + 1) + " can vote.");
            else
                System.out.println("Student " + (i + 1) + " cannot vote.");
        }
        sc.close();
    }
}
