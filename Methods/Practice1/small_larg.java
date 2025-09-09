import java.util.Scanner;

public class small_larg{

    // Method to find smallest and largest
    public static int[] findSmallestAndLargest(int num1, int num2, int num3) {
        int smallest = Math.min(num1, Math.min(num2, num3));
        int largest = Math.max(num1, Math.max(num2, num3));
        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 3 numbers: ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        int[] result = findSmallestAndLargest(n1, n2, n3);

        System.out.println("Smallest = " + result[0] + ", Largest = " + result[1]);

        sc.close();
    }
}
