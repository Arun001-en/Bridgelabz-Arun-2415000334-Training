import java.util.Scanner;

public class PrimitiveToWrapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        Integer obj = Integer.valueOf(num);
        System.out.println("Primitive value: " + num);
        System.out.println("Wrapper (Integer) object value: " + obj);

        sc.close();
    }
}
