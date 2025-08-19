import java.util.Scanner;
public class HarryAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The BirthYear is:");
        int birthyear = sc.nextInt();
        System.out.print("Enter the currentyear:");
        int currentYear = sc.nextInt();
        int age = currentYear-birthyear;
        System.out.print("The age of the Sam :"+age);
       
    }
}
