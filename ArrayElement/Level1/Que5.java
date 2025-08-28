import java.util.Scanner;
public class Que5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int[] mr = new int[4];
        for (int i = 6; i <= 9; i++) {
            mr[i - 6] = number * i;
        }
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + mr[i - 6]);
        }

        sc.close();
    }
}
