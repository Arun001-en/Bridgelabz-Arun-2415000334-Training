package OOPS_Design;

import java.util.ArrayList;
import java.util.List;


class Book {
    private String title;
    private String author;

     public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    
    @Override
    public String toString() {
        return "Book [Title: " + title + ", Author: " + author + "]";
    }
}


class Library {
    private String name;
    private List<Book> books;   


    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }


    public void addBook(Book book) {
        books.add(book);
    }

   
    public void showBooks() {
        System.out.println("Library: " + name);
        if (books.isEmpty()) {
            System.out.println("No books in this library.");
        } else {
            for (Book b : books) {
                System.out.println("  - " + b);
            }
        }
        System.out.println();
    }
}


public class LibraryManagement {
    public static void main(String[] args) {

       
        Book b1 = new Book("The Alchemist", "Paulo Coelho");
        Book b2 = new Book("Clean Code", "Robert C. Martin");
        Book b3 = new Book("Java Programming", "James Gosling");


        Library lib1 = new Library("City Library");
        Library lib2 = new Library("College Library");

        
        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2); 
        lib2.addBook(b3);

     
        lib1.showBooks();
        lib2.showBooks();

     
        System.out.println("Independent Book Example: " + b1);
    }
}
