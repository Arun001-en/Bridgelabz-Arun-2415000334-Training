import java.util.*;

public class GradeTracker {
    public static void main(String[] args) {
        Map<String, Double> grades = new TreeMap<>(); // sorted

        grades.put("Arun", 85.0);
        grades.put("Rahul", 90.0);
        grades.put("Neha", 76.0);

        // update
        grades.put("Neha", 80.0);

        // remove
        grades.remove("Rahul");

        // print sorted
        for (String name : grades.keySet()) {
            System.out.println(name + " -> " + grades.get(name));
        }
    }
}
