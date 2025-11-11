import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;
    Alert(String type) { this.type = type; }

    public String toString() { return type; }
}

public class NotificationFilter {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
            new Alert("Emergency"),
            new Alert("Reminder"),
            new Alert("General")
        );

        Predicate<Alert> onlyEmergency = a -> a.type.equals("Emergency");

        alerts.stream()
              .filter(onlyEmergency)
              .forEach(a -> System.out.println("Showing: " + a));
    }
}
