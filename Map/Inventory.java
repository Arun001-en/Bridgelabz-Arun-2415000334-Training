import java.util.*;

public class Inventory {
    public static void main(String[] args) {
        Map<String, Integer> stock = new HashMap<>();

        stock.put("Pen", 50);
        stock.put("Book", 20);
        stock.put("Bag", 5);

        // customer buys
        stock.put("Book", stock.get("Book") - 20);
        if (stock.get("Book") <= 0) stock.put("Book", 0);

        // shipment arrives
        stock.put("Bag", stock.get("Bag") + 10);

        // out of stock items
        System.out.println("Out of stock:");
        for (String p : stock.keySet())
            if (stock.get(p) == 0)
                System.out.println(p);

        // query
        String q = "Pen";
        System.out.println(q + " remaining: " + stock.getOrDefault(q, -1));
    }
}
