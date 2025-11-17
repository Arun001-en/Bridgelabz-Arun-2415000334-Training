import java.util.*;

class Order {
    String orderId;
    String customerName;
    double amount;

    Order(String orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Order)) return false;
        Order o = (Order) obj;
        return this.orderId.equals(o.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        return "[" + orderId + ", " + customerName + ", ₹" + amount + "]";
    }
}

public class ECommerceOrderSystem {
    public static void main(String[] args) {
        // Step 1: Add orders to List
        List<Order> allOrders = new ArrayList<>();
        allOrders.add(new Order("O101", "Ayush", 1500));
        allOrders.add(new Order("O102", "Rohan", 2000));
        allOrders.add(new Order("O101", "Ayush", 1500)); // duplicate
        allOrders.add(new Order("O103", "Neha", 2500));

        System.out.println("All Orders:");
        allOrders.forEach(System.out::println);

        // Step 2: Remove duplicates using Set
        Set<Order> uniqueOrders = new HashSet<>(allOrders);
        System.out.println("\nUnique Orders:");
        uniqueOrders.forEach(System.out::println);

        // Step 3: Process orders in Queue (FIFO)
        Queue<Order> processingQueue = new LinkedList<>(uniqueOrders);
        Stack<Order> failedOrders = new Stack<>();

        System.out.println("\nProcessing Orders:");
        while (!processingQueue.isEmpty()) {
            Order order = processingQueue.remove();
            // simulate random failure
            if (order.orderId.equals("O102")) {
                System.out.println(order.orderId + " ❌ Failed!");
                failedOrders.push(order);
            } else {
                System.out.println(order.orderId + " ✅ Processed!");
            }
        }

        // Step 4: Retry failed orders using Stack (LIFO)
        System.out.println("\nRe-processing Failed Orders:");
        while (!failedOrders.isEmpty()) {
            Order failed = failedOrders.pop();
            System.out.println(failed.orderId + " 🔁 Retried Successfully!");
        }
    }
}

