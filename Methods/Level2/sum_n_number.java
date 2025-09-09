import java.util.*;

public class sum_n_number {
    public static int sumRecursive(int n) {
        if (n == 1) return 1;
        return n + sumRecursive(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Not a natural number.");
            return;
        }

        int sumRec = sumRecursive(n);
        int sumFormula = n * (n + 1) / 2;

        System.out.println("Sum using Recursion: " + sumRec);
        System.out.println("Sum using Formula: " + sumFormula);

        if (sumRec == sumFormula) {
            System.out.println("Both are equal ");
           
        }
        
    }
}
