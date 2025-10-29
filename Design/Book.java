package constructors;
//Book.java
public class book {
 // Attributes
 private String title;
 private String author;
 private double price;

 // Default constructor
 public book() {
     this.title = "Unknown Title";
     this.author = "Unknown Author";
     this.price = 0.0;
 }

 // Parameterized constructor
 public book(String title, String author, double price) {
     this.title = title;
     this.author = author;
     this.price = price;
 }

 // Method to display book details
 public void displayDetails() {
     System.out.println("Title: " + title);
     System.out.println("Author: " + author);
     System.out.println("Price: ₹" + price);
     System.out.println("---------------------------");
 }

 // Main method to test the class
 public static void main(String[] args) {
     // Using default constructor
     book book1 = new book();
     book1.displayDetails();

     // Using parameterized constructor
     book book2 = new book("The Alchemist", "Paulo Coelho", 499.99);
     book2.displayDetails();
 }
}
