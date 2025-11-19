import java.util.*;

public class SalaryDirectory {
    public static void main(String[] args) {
        Map<String, Double> sal = new HashMap<>();

        sal.put("Arun", 40000.0);
        sal.put("Neha", 55000.0);
        sal.put("Rahul", 38000.0);
        sal.put("Simran", 60000.0);
        sal.put("Amit", 42000.0);
        sal.put("Kiran", 61000.0);

        // give raise
        sal.put("Arun", sal.get("Arun") * 1.10); // 10% raise

        // average salary
        double total = 0;
        for (double s : sal.values()) total += s;
        System.out.println("Average = " + (total / sal.size()));

        // highest paid
        double max = 0;
        for (double s : sal.values()) max = Math.max(max, s);

        System.out.println("Highest salary employees:");
        for (String n : sal.keySet())
            if (sal.get(n) == max)
                System.out.println(n);
    }
}
