package constructors;

//Book.java
public class Book_2{
 // Attributes
 private String title;
 private String author;
 private double price;
 private boolean available;

 // Default constructor
 public Book_2() {
     this.title = "Unknown Title";
     this.author = "Unknown Author";
     this.price = 0.0;
     this.available = true; // By default available
 }

 // Parameterized constructor
 public Book_2(String title, String author, double price, boolean available) {
     this.title = title;
     this.author = author;
     this.price = price;
     this.available = available;
 }

 // Method to borrow a book
 public void borrowBook() {
     if (available) {
         available = false;
         System.out.println("You have successfully borrowed: " + title);
     } else {
         System.out.println("Sorry, the book '" + title + "' is already borrowed.");
     }
 }

 // Method to return a book
 public void returnBook() {
     if (!available) {
         available = true;
         System.out.println("You have successfully returned: " + title);
     } else {
         System.out.println("The book '" + title + "' was not borrowed.");
     }
 }

 // Method to display details
 public void displayDetails() {
     System.out.println("Title: " + title);
     System.out.println("Author: " + author);
     System.out.println("Price: ₹" + price);
     System.out.println("Available: " + (available ? "Yes" : "No"));
     System.out.println("----------------------------");
 }

 // Main method for testing
 public static void main(String[] args) {
     // Create a book
     Book_2 b1 = new Book_2("The Alchemist", "Paulo Coelho", 499.99, true);
     b1.displayDetails();

     // Borrow the book
     b1.borrowBook();
     b1.displayDetails();

     // Try borrowing again
     b1.borrowBook();

     // Return the book
     b1.returnBook();
     b1.displayDetails();
 }
}
