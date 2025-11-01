import java.util.ArrayList;
import java.util.Collections;

public class Que7 {
    public static void main(String[] args) {
        // Given array of primitive double values
        double[] prices = {10.5, 20.0, 35.75, 5.5};

        // Convert to ArrayList<Double> using auto-boxing
        ArrayList<Double> priceList = new ArrayList<>();
        for (double p : prices) {
            priceList.add(p); // Auto-boxing: double → Double
        }

        // Find the highest price
        double maxPrice = Collections.max(priceList);

        // Calculate average price
        double sum = 0;
        for (double price : priceList) {
            sum += price; // Auto-unboxing: Double → double
        }
        double average = sum / priceList.size();

        // Print results
        System.out.println("Highest price = " + maxPrice);
        System.out.println("Average price = " + average);
}
}
