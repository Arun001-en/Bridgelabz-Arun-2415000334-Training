class Product {
    private static double discount = 10.0;

    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public void displayProductDetails() {
        if (this instanceof Product) {
            double totalPrice = price * quantity;
            double discountedPrice = totalPrice - (totalPrice * discount / 100);
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: ₹" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Price (after " + discount + "% discount): ₹" + discountedPrice);
        }
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
}

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product(101, "Laptop", 55000, 1);
        Product p2 = new Product(102, "Headphones", 2000, 2);

        p1.displayProductDetails();
        System.out.println();
        p2.displayProductDetails();

        System.out.println("\nUpdating discount to 20%...\n");
        Product.updateDiscount(20);

        p1.displayProductDetails();
        System.out.println();
        p2.displayProductDetails();
    }
}
