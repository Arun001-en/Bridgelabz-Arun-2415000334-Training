public class WeatherSystem {
    public static void main(String[] args) {
        double[] temperatures = {20, 25, 22, 24, 21};
        int n = 5;

        System.out.println("Testing Algorithm A:");
        double resultA = algorithmA(temperatures, n);
        System.out.println("Result: " + resultA);

        System.out.println("\nTesting Algorithm B:");
        double resultB = algorithmB(temperatures, n);
        System.out.println("Result: " + resultB);
    }

    public static double algorithmA(double[] temperature, int n) {
        double total = 0;
        for (int i = 0; i < n; i++) {
            total = total + temperature[i];
        }
        double average = total / n;
        return average;
    }

    public static double algorithmB(double[] temperature, int n) {
        // Note: This algorithm contains the logical error described in the problem
        double sum = temperature[0];
        for (int i = 1; i < n; i++) {
            sum = sum + temperature[i];
        }
        
        // Error: Dividing inside the loop logic (as per problem description simulation)
        for (int i = 0; i < n; i++) {
            sum = sum / n;
        }
        return sum;
    }
}
