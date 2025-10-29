package java_design;
import java.util.ArrayList;

class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Display book details
    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Library {
    private String name;
    private ArrayList<Book> books;  // Aggregation: Library HAS books

    // Constructor
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Add book to library
    public void addBook(Book book) {
        books.add(book);
    }

    // Display library details
    public void displayLibrary() {
        System.out.println("Library: " + name);
        System.out.println("Books in this library:");
        for (Book b : books) {
            b.displayBook();
        }
        System.out.println();
    }
}

public class library {
    public static void main(String[] args) {
        // Create Books (independent objects)
        Book b1 = new Book("The Alchemist", "Paulo Coelho");
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = new Book("Harry Potter", "J.K. Rowling");

        // Create Libraries
        Library l1 = new Library("City Library");
        Library l2 = new Library("College Library");

        // Add books to libraries (Aggregation)
        l1.addBook(b1);
        l1.addBook(b2);

        l2.addBook(b2); // same book can belong to another library
        l2.addBook(b3);

        // Display details
        l1.displayLibrary();
        l2.displayLibrary();
    }
}
