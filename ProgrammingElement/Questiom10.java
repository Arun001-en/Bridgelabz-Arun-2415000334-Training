import java.util.Scanner;

public class Questiom10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your height in centimeters: ");
        double heightCm = input.nextDouble();
        double totalInches = heightCm / 2.54;
        int feet = (int)(totalInches / 12);
        int inches = (int)(totalInches % 12);
        System.out.println("Your height in cm is " + heightCm +" while in feet is " + feet + " and inches is " + inches);
        input.close();
    }
}