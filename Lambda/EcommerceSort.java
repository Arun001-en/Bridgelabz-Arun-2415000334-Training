import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount;

    Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    public String toString() {
        return name + " (₹" + price + ", Rating: " + rating + ", Discount: " + discount + "%)";
    }
}

public class EcommerceSort {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Phone", 50000, 4.5, 10),
            new Product("Laptop", 70000, 4.8, 15),
            new Product("Tablet", 30000, 4.2, 5)
        );

        // Sort by price
        products.sort((a, b) -> Double.compare(a.price, b.price));
        System.out.println("Sorted by Price: " + products);

        // Sort by rating
        products.sort((a, b) -> Double.compare(b.rating, a.rating));
        System.out.println("Sorted by Rating: " + products);

        // Sort by discount
        products.sort((a, b) -> Double.compare(b.discount, a.discount));
        System.out.println("Sorted by Discount: " + products);
    }
}

