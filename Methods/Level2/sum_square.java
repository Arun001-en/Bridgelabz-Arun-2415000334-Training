import java.util.*;

public class sum_square {
    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }
        int[] factors = new int[count];
        int idx = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) factors[idx++] = i;
        }
        return factors;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int[] factors = findFactors(n);
        System.out.println("Factors: " + Arrays.toString(factors));

        int sum = 0, product = 1, sumSq = 0;
        for (int f : factors) {
            sum += f;
            product *= f;
            sumSq += f * f;
        }
        System.out.println("Sum = " + sum);
        System.out.println("Product = " + product);
        System.out.println("Sum of Squares = " + sumSq);
        sc.close();
    }
}
