
import static java.lang.Math.*;

public class three {
    public static void main(String[] args) {

        double a = 25.0;
        double b = 3.0;
        double c = -12.5;

        
        System.out.println("Square root of " + a + " = " + sqrt(a));
        System.out.println(a + " raised to power " + b + " = " + pow(a, b));
        System.out.println("Maximum of " + a + " and " + b + " = " + max(a, b));
        System.out.println("Minimum of " + a + " and " + c + " = " + min(a, c));
        System.out.println("Absolute value of " + c + " = " + abs(c));

        
        System.out.println("Value of PI = " + PI);
        System.out.println("Cosine of 90 degrees = " + cos(toRadians(90)));
    }
}

