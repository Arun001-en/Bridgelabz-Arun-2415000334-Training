class Book {
    private static String libraryName = "Central Library";
    private final String isbn;
    private String title;
    private String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("Library: " + libraryName);
            System.out.println("ISBN: " + isbn);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
}

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("978-101", "Java Programming", "James Gosling");
        Book b2 = new Book("978-102", "Data Structures", "Mark Allen");

        b1.displayBookDetails();
        System.out.println();
        b2.displayBookDetails();

        System.out.println();
        Book.displayLibraryName();

        System.out.println("\nISBN of first book: " + b1.getIsbn());
    }
}
