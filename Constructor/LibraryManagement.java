package constructors;
class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void displayDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends Book {
    private double fileSize;

    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    public void displayEBookDetails() {
        System.out.println("EBook ISBN: " + ISBN);
        System.out.println("EBook Title: " + title);
        System.out.println("Author: " + getAuthor());
        System.out.println("File Size: " + fileSize + " MB");
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Book b1 = new Book("ISBN12345", "Java Programming", "James Gosling");
        b1.displayDetails();

        System.out.println("-----------------------");

        EBook eb1 = new EBook("ISBN67890", "Advanced Java", "Chhavi Varshney", 5.2);
        eb1.displayEBookDetails();
    }
}
