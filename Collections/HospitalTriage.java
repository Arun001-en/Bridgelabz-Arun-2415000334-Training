import java.util.*;

class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

public class HospitalTriage {
    public static void main(String[] args) {
        PriorityQueue<Patient> queue = new PriorityQueue<>((a, b) -> b.severity - a.severity);

        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        System.out.println("Treatment Order:");
        while (!queue.isEmpty()) {
            Patient p = queue.remove();
            System.out.println(p.name + " (Severity: " + p.severity + ")");
        }
    }
}

